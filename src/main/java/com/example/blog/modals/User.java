package com.example.blog.modals;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    //Constructors
    public User(){}

    //Insert/Create
    public User(String email, String username, String password, List<Post> posts) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.posts = posts;
    }

    //Read
    public User(long id, String email, String username, String password, List<Post> posts) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.posts = posts;
    }

    //Getters and Setters
    public long getId(){
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
