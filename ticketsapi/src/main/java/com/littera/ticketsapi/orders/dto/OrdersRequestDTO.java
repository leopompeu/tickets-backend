package com.littera.ticketsapi.orders.dto;

import com.littera.ticketsapi.tickets.model.Tickets;
import com.littera.ticketsapi.user.model.Users;

import java.sql.Date;
import java.util.List;

public record OrdersRequestDTO( Date dateOrder, List<Tickets> ticketId, Integer status, Users userId, Float price) {
}
