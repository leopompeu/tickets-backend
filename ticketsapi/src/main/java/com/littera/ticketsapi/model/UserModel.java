package com.littera.ticketsapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user_data")
public class UserModel {

    @Id
    public Integer id;
    @Column(nullable = false, length = 70)
    public String name;
    @Column(nullable = false, length = 30)
    public String username;
    @Column(nullable = false, length = 15)
    public String password;

}
