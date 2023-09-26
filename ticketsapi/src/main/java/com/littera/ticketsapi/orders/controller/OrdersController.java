package com.littera.ticketsapi.orders.controller;

import com.littera.ticketsapi.orders.dto.OrdersRequestDTO;
import com.littera.ticketsapi.orders.dto.OrdersResponseDTO;
import com.littera.ticketsapi.orders.model.Orders;
import com.littera.ticketsapi.orders.repository.OrdersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository repository;

    @PostMapping
    public void saveOrder(@RequestBody @Valid OrdersRequestDTO data){
        Orders ordersData = new Orders(data);
        repository.save(ordersData);
    }

    @GetMapping
    public List<OrdersResponseDTO> getAll(){
        List<OrdersResponseDTO> ordersList = repository.findAll().stream().map(OrdersResponseDTO::new).toList();
        return ordersList;
    }


}
