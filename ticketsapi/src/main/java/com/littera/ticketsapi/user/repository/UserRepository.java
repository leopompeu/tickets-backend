package com.littera.ticketsapi.user.repository;

import com.littera.ticketsapi.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, String> {
    UserDetails findByUsername(String username);
    UserDetails findByEmail(String email);
    UserDetails findByCpf(String cpf);

}
