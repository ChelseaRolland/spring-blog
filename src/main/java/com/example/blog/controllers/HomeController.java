package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/") @ResponseBody
    public String index(){
        return "This is the landing page!";
    }

    @GetMapping("/home")
    public String welcome(){ return "/home";}

    @GetMapping("/join")
    public String showJoinForm(Model model){
        List<String> cohortNames = new ArrayList<>();
        cohortNames.add("Bash");
        cohortNames.add("Apex");
        cohortNames.add("Io");

        model.addAttribute("cohortNames", cohortNames);
        return "/join";
    }

    @PostMapping("/join")
    public String postJoinForm(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "/join";
    }


}
