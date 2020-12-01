package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollingDiceController {
    @GetMapping("/roll-dice")
    public String viewRollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model){
        //Set up the random number
        Random random = new Random();

        //Bound the random number from 1 - 6
        int randomRoll = random.nextInt(6 - 1) + 1;

        //int randomNum = ThreadLocalRandom.current().nextInt(1,6 + 1);

        //Compare the guessed value to the random number roll
        //Set/Add the attributes on the /roll-page so we can see the results from users guess, random number for roll, and comparing results into an attribute
        model.addAttribute("userGuess", guess);
        model.addAttribute("randomNumber", randomRoll);
        model.addAttribute("isCorrectGuess", randomRoll == guess);

        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String rollDice2(Model model){
        //setting up random number
        Random random = new Random();
        int randomRoll = random.nextInt(6 - 1) + 1;

        return "roll-dice";
    }

//Button Selections
//    @RequestMapping(value = "/roll-dice", params = "btn1", method = RequestMethod.POST)
//    public void btn1(){
//        System.out.println("Btn 1 was called");
//    }
//
//    @RequestMapping(value = "/roll-dice", params = "btn2", method = RequestMethod.POST)
//    public void btn2(){
//        System.out.println("Btn 2 was called");
//    }
//
//    @RequestMapping(value = "/roll-dice", params = "btn3", method = RequestMethod.POST)
//    public void btn3(){
//        System.out.println("Btn 3 was called");
//    }
//
//    @RequestMapping(value = "/roll-dice", params = "btn4", method = RequestMethod.POST)
//    public void btn4(){
//        System.out.println("Btn 4 was called");
//    }
//
//    @RequestMapping(value = "/roll-dice", params = "btn5", method = RequestMethod.POST)
//    public void btn5(){
//        System.out.println("Btn 5 was called");
//    }
//
//    @RequestMapping(value = "/roll-dice", params = "btn6", method = RequestMethod.POST)
//    public void btn6(){
//        System.out.println("Btn 6 was called");
//    }

//    @GetMapping("/roll-dice")
//    public String promptUserGuess(Model viewModel){
//        //Generate Buttons
//        List<Integer> buttonOptions = new ArrayList<Integer>();
//        for (int i = 1; i<= 6; i++){
//            buttonOptions.add(i);
//        }
//
//        viewModel.addAttribute("buttonOptions", buttonOptions);
//        return  "roll-dice";
//    }
//
//    @PostMapping("/roll-dice")
//    public String postUserGuess(
//            @RequestParam(name = "option") int option,
//            Model viewModel
//    ){
//        //Set up the random number
//        Random random = new Random();
//        //Bound the random number from 1 - 6
//        int randomRoll = random.nextInt(6 - 1) + 1; //+1 ensures the minimum is 1
//         viewModel.addAttribute("option", option);
//         viewModel.addAttribute("randomNumber", randomRoll);
//         viewModel.addAttribute("isCorrectGuess", option == randomRoll);
//
//         return "roll-dice";
//
//    }

}
