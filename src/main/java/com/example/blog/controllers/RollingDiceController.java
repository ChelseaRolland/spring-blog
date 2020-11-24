package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RollingDiceController {
    @GetMapping("/roll-dice")
    public String rollDice(){
        return "/roll-dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String diceSide(Model model){
        return "/roll-dice";
    }

    @PostMapping("/roll-dice/{num}")
    public int

}
