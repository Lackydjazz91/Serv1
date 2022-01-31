package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class Controller {

    @Value("${Serv2.url}")
    private String url;


    @GetMapping("/")
    public String defaultMeth() {
        return "Страница сервиса 1";
    }

    @GetMapping("/serv2")
    public String Serv2() {
        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        return webClient.get().uri("/").retrieve().bodyToMono(String.class).block();
    }
}
