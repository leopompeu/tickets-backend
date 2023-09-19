package com.littera.ticketsapi.user.controller;

import com.littera.ticketsapi.services.TokenService;
import com.littera.ticketsapi.user.dto.AuthenticationDTO;
import com.littera.ticketsapi.user.dto.LoginResponseDTO;
import com.littera.ticketsapi.user.dto.RegisterDTO;
import com.littera.ticketsapi.user.model.Users;
import com.littera.ticketsapi.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByUsername(data.username()) != null ||
                this.repository.findByEmail(data.email()) != null ||
                this.repository.findByCpf(data.cpf()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.username(), encryptedPassword, data.role(), data.email(), data.address(), data.city(), data.state(), data.country(), data.postalCode(), data.cpf(), data.birthDate(), data.registerDate());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();

    }

}
