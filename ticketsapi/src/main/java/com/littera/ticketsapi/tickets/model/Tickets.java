package com.littera.ticketsapi.tickets.model;

import com.littera.ticketsapi.orders.model.Orders;
import com.littera.ticketsapi.tickets.dto.TicketsRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Date;

@Table(name = "tickets")
@Entity(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String title;
    private String image;
    private Float price;
    private Date eventDate;
    private Date addDate;
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
