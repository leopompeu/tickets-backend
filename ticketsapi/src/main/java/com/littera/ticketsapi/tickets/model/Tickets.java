package com.littera.ticketsapi.tickets.model;

import com.littera.ticketsapi.tickets.dto.TicketsRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "tickets")
@Entity(name = "tickets")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotBlank
    private String title;
    private String image;
    @NotBlank
    private Float price;
    @NotBlank
    private Date eventDate;
    @NotBlank
    private Date addDate;
    @NotBlank
    private Date sellingDate;

    public Tickets(TicketsRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
        this.eventDate = data.eventDate();
        this.addDate = data.addDate();
        this.sellingDate = data.sellingDate();
    }
}
