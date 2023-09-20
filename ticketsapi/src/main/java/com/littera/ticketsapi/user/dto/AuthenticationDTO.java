package com.littera.ticketsapi.user.dto;

public record AuthenticationDTO(String username, String password, Boolean isEnabled, Boolean isNonExpired, Boolean isNonLocked) {
}
