package com.littera.ticketsapi.tickets.dto;

import com.littera.ticketsapi.tickets.model.Tickets;

import java.sql.Date;

public record TicketsResponseDTO(Integer id, String title, String image, Float price, Date eventDate, Date addDate, Date sellingDate) {

    public TicketsResponseDTO(Tickets tickets){
        this(tickets.getId(), tickets.getTitle(), tickets.getImage(), tickets.getPrice(), tickets.getEventDate(), tickets.getAddDate(), tickets.getSellingDate());
    }

}
