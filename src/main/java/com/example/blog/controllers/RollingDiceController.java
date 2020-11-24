package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class RollingDiceController {
    @GetMapping("/roll-dice")
    public String viewRollDice(){
        return "/roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model){
        //Set up the random number
        Random random = new Random();

        //Bound the random number from 1 - 6
        int randomRoll = random.nextInt(6 - 1) + 1;

        //Compare the guessed value to the random number roll
        //Set/Add the attributes on the /roll-page so we can see the results from users guess, random number for roll, and comparing results into an attribute
        model.addAttribute("isCorrectGuess", randomRoll == guess);
        model.addAttribute("userGuess", guess);
        model.addAttribute("randomNumber", randomRoll);

        return "/roll-dice";
    }

    @RequestMapping(value = "/roll-dice", params = "1", method = RequestMethod.POST)
    public void btn1(){
        System.out.println("Btn 1 was called");
    }

    @RequestMapping(value = "/roll-dice", params = "2", method = RequestMethod.POST)
    public void btn2(){
        System.out.println("Btn 2 was called");
    }

    @PostMapping("/roll-dice")
    public String rollDice2(Model model){
        //setting up random number
        Random random = new Random();
        int randomRoll = random.nextInt(6 - 1) + 1;




        return "/roll-dice";
    }

}
