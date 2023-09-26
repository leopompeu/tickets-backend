package com.littera.ticketsapi.tickets.repository;

import com.littera.ticketsapi.tickets.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets, String> {

}
