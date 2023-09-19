package com.littera.ticketsapi.tickets.controller;

import com.littera.ticketsapi.tickets.dto.TicketsRequestDTO;
import com.littera.ticketsapi.tickets.dto.TicketsResponseDTO;
import com.littera.ticketsapi.tickets.model.Tickets;
import com.littera.ticketsapi.tickets.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketsRepository repository;

    @PostMapping
    public void saveTicket(@RequestBody TicketsRequestDTO data){
        Tickets ticketsData = new Tickets(data);
        repository.save(ticketsData);
    }

    @GetMapping
    public List<TicketsResponseDTO> getAll(){
        List<TicketsResponseDTO> ticketsList = repository.findAll().stream().map(TicketsResponseDTO::new).toList();
        return ticketsList;
    }
}
