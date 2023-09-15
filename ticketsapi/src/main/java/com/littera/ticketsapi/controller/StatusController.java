package com.littera.ticketsapi.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class StatusController {

    @GetMapping(path = "/api/status")
    public String check(){
        return "online";
    }

}
