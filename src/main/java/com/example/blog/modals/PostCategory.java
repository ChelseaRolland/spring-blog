package com.example.blog.modals;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

    public PostCategory(){}

    //Create
    public PostCategory(String name, List<Post> posts){
        this.name = name;
        this.posts = posts;
    }

    //Read
    public PostCategory(long id, String name, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
