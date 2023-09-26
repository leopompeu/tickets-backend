package com.littera.ticketsapi.orders.repository;

import com.littera.ticketsapi.orders.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, String> {

}
