package com.sofka.agenda.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
    @RequestMapping("/api")
    public String hola() {
        return "Hola Mundo";
    }
}
