package com.littera.ticketsapi.tickets.model;

import com.littera.ticketsapi.tickets.dto.TicketsRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String title;
    private String image;
    private Float price;

    public Tickets(TicketsRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }
}
