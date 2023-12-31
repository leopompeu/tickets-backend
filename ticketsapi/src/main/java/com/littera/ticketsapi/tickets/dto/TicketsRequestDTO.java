package com.littera.ticketsapi.tickets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public record TicketsRequestDTO(String title, String image, Float price, Date eventDate, Date addDate, Date sellingDate) {
}
