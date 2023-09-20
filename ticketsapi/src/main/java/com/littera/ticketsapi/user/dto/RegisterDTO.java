package com.littera.ticketsapi.user.dto;

import com.littera.ticketsapi.user.model.UserRole;

import java.sql.Date;

public record RegisterDTO(String username, String password, UserRole role, String name, String email, String address, String city, String state, String country, String postalCode, String cpf, Date birthDate, Date registerDate, Boolean isEnabled, Boolean isNonExpired, Boolean isNonLocked) {
}
