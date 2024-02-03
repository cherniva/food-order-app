package com.cherniva.tacoorderapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/order")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class OrderController {

    @GetMapping
    public String orderForm() {
        return "orderForm";
    }

}
