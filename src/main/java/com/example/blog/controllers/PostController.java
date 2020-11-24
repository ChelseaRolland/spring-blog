package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts") @ResponseBody
    public String index(){
        return "post's index page";
    }

    @GetMapping("/posts/{id}") @ResponseBody
    public String individualPost(@PathVariable long id){
        return "view individual posts and the id is: " + id;
    }

    @GetMapping("/posts/create") @ResponseBody
    public String viewCreateForm(){
        return "view the form for creating a blog post";
    }

    @PostMapping("/posts/create") @ResponseBody
    public String submitPost(){
        return "create new blog post";
    }
}
