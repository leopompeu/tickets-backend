package com.littera.ticketsapi.tickets.dto;

import com.littera.ticketsapi.tickets.model.Tickets;

public record TicketsResponseDTO(String id, String title, String image, Float price) {

    public TicketsResponseDTO(Tickets tickets){
        this(tickets.getId(), tickets.getTitle(), tickets.getImage(), tickets.getPrice());
    }

}
