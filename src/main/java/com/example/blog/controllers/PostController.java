package com.example.blog.controllers;

import com.example.blog.modals.Post;
import com.example.blog.modals.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postsDao;

    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        List<Post> blogPosts = new ArrayList<Post>();
        blogPosts.add(new Post("Day 1", "Time for back to school after the Thanksgiving Holiday Break"));
        blogPosts.add(new Post("So this is happening...", "Got 3 more weeks until I officially freak out about graduating as a software developer"));
        blogPosts.add(new Post("Post 3", "Testing 3"));

        model.addAttribute("posts", blogPosts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        Post newPost = new Post("Post " + id, "Some cool stuff " + id + ".");

        model.addAttribute("currentPost", newPost);
        System.out.println("view individual posts and the id is: " + id);
        return "posts/show";
    }

    @GetMapping("/posts/create") @ResponseBody
    public String viewCreateForm(){
        return "view the form for creating a blog post";
    }

    @PostMapping("/posts/create") @ResponseBody
    public String submitPost(){
        return "create new blog post";
    }

    @PostMapping("/posts/edit")
    public String editPost(Model viewModel){

        return "";
    }

    @PostMapping("/posts/delete")
    public String deletePost(Model viewModel){

        return "posts/index";
    }
}
