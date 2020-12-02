package com.example.blog.controllers;

import com.example.blog.modals.Post;
import com.example.blog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postsDao;

    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        Post newPost = new Post("Post " + id, "Some cool stuff " + id + ".");

        model.addAttribute("currentPost", newPost);
        System.out.println("view individual posts and the id is: " + id);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(){
        return "posts/new";
    }

    @PostMapping("/posts/create") @ResponseBody
    public String submitPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Post post = new Post(title, body);
        Post dbPost = postsDao.save(post);
        return "create new blog post with id " + dbPost.getId();
    }


    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit") @ResponseBody
    public String editPost(
            //@RequestParam(name = "postId") long id, -->Anyone can change this so put it as/in your URL
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        //Existing information
        Post dbPost = postsDao.getOne(id);
        //Setting the new information
        dbPost.setTitle(title);
        dbPost.setBody(body);

        //sending the update to the database
        postsDao.save(dbPost);

        //redirect to the specific posts page
        return "redirect:/posts/" + dbPost.getId();
    }

    @GetMapping("/posts/delete")@ResponseBody
    public String viewDelete(){
        return "this is the delete page";
    }

    @PostMapping("/posts/delete") @ResponseBody
    public String deletePostById(@RequestParam(name = "postId") long id){
        //Post post = postsDao.delete();
        postsDao.deleteById(id);
        //postsDao.deletePostById(id);
        return "deleted the post with the ID of" + id;
    }
}
