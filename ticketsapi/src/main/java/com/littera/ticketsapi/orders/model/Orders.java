package com.littera.ticketsapi.orders.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.littera.ticketsapi.orders.dto.OrdersRequestDTO;
import com.littera.ticketsapi.tickets.model.Tickets;
import com.littera.ticketsapi.user.model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity(name = "orders")
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date dateOrder;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private List<Tickets> ticketId;
    private Integer status;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users userId;
    private Float price;

    public Orders(OrdersRequestDTO data) {
        this.dateOrder = data.dateOrder();
        this.ticketId = data.ticketId();
        this.status = data.status();
        this.userId = data.userId();
        this.price = data.price();
    }

}
