package com.littera.ticketsapi.user.controller;

import com.littera.ticketsapi.services.TokenService;
import com.littera.ticketsapi.user.dto.AuthenticationDTO;
import com.littera.ticketsapi.user.dto.LoginResponseDTO;
import com.littera.ticketsapi.user.dto.RegisterDTO;
import com.littera.ticketsapi.user.model.UserRole;
import com.littera.ticketsapi.user.model.Users;
import com.littera.ticketsapi.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        if(data.isEnabled() && data.isNonExpired() && data.isNonLocked()){
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((Users) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByUsername(data.username()) != null ||
                this.repository.findByEmail(data.email()) != null ||
                this.repository.findByCpf(data.cpf()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.username(), encryptedPassword, UserRole.USER , data.name(), data.email(), data.address(), data.city(), data.state(), data.country(), data.postalCode(), data.cpf(), data.birthDate(), data.registerDate(), true, true, true);

        this.repository.save(newUser);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/registerAdmin")
    public ResponseEntity registerAdmin(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByUsername(data.username()) != null ||
                this.repository.findByEmail(data.email()) != null ||
                this.repository.findByCpf(data.cpf()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.username(), encryptedPassword, data.role(), data.name(), data.email(), data.address(), data.city(), data.state(), data.country(), data.postalCode(), data.cpf(), data.birthDate(), data.registerDate(), true, true, true);

        this.repository.save(newUser);

        return ResponseEntity.ok().build();

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}
