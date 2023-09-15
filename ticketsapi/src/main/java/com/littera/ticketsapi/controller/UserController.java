package com.littera.ticketsapi.controller;

import com.littera.ticketsapi.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.littera.ticketsapi.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/api/user/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/user/register")
    public UserModel register(@RequestBody UserModel user){
        return repository.save(user);
    }


}
