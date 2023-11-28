package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/web")
public class telaInicial {

    @GetMapping(path = "/")
    public String indexLogin(){
        return "indexLogin";
    }
}
