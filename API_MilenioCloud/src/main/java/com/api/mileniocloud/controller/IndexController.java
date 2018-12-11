package com.api.mileniocloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "Hola y Bienvenido Lucho al API de Inventario (Milenio - Cloud)";
    }
}
