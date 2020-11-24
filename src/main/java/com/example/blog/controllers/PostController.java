package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndexPg(){
        return "this is the blog post's index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id){
        return String.valueOf(id);
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePostForm(){
        return "this will be viewing the create post form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "this will create the new blog post";
    }
}
