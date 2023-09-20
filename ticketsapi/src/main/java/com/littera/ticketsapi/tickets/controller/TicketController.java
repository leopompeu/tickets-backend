package com.littera.ticketsapi.tickets.controller;

import com.littera.ticketsapi.tickets.dto.TicketsRequestDTO;
import com.littera.ticketsapi.tickets.dto.TicketsResponseDTO;
import com.littera.ticketsapi.tickets.model.Tickets;
import com.littera.ticketsapi.tickets.repository.TicketsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketsRepository repository;

    @PostMapping
    public void saveTicket(@RequestBody @Valid TicketsRequestDTO data){
        Tickets ticketsData = new Tickets(data);
        repository.save(ticketsData);
    }

    @GetMapping
    public List<TicketsResponseDTO> getAll(){
        List<TicketsResponseDTO> ticketsList = repository.findAll().stream().map(TicketsResponseDTO::new).toList();
        return ticketsList;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}
