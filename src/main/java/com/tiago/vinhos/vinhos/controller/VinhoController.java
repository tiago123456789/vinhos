package com.tiago.vinhos.vinhos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/vinho")
public class VinhoController {

    @GetMapping
    public String novo() {
        return "vinhos/cadastro-vinho.html";
    }
}
