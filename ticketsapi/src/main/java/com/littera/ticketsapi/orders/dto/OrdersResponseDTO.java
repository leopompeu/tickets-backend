package com.littera.ticketsapi.orders.dto;

import com.littera.ticketsapi.orders.model.Orders;
import com.littera.ticketsapi.tickets.model.Tickets;
import com.littera.ticketsapi.user.model.Users;

import java.sql.Date;
import java.util.List;

public record OrdersResponseDTO(Date dateOrder, List<Tickets> ticketId, Integer status, Users userId, Float price) {

    public OrdersResponseDTO(Orders orders){
        this(orders.getDateOrder(), orders.getTicketId(), orders.getStatus(), orders.getUserId(), orders.getPrice());
    }

}
