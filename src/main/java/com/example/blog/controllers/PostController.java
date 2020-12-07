package com.example.blog.controllers;

import com.example.blog.modals.Post;
import com.example.blog.modals.User;
import com.example.blog.repos.PostRepository;
import com.example.blog.repos.UserRepository;
import com.example.blog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService){
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }


    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/new";
    }

    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post postToBeSaved){
        User userDb = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postToBeSaved.setUser(userDb);
        Post dbPost = postsDao.save(postToBeSaved);
        emailService.prepareAndSend(dbPost, "Post has been Created", "You can find it with the id of " + dbPost.getId());
        return "redirect:/posts/" + dbPost.getId();
    }


    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post postToBeUpdated){
        User user = usersDao.getOne(1L); //a user obj coming from a session
        postToBeUpdated.setUser(user);
        postsDao.save(postToBeUpdated);

        //redirect to the specific posts page
        return "redirect:/posts/" + postToBeUpdated.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePostById(@PathVariable long id){
        System.out.println("Does this run?");
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/rick-roll")
    public String rickRoll(){
        // redirecting to an absolute url
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }

    @GetMapping("/redirect-me")
    public String redirect() {
        // a relative (to the base domain) redirect, usually you will use this version
        // Will redirect the users to `/about`
        return "redirect:/posts";
    }
}
