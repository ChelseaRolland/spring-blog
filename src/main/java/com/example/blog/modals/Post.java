package com.example.blog.modals;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private String createTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Post(){}

    //Insert/Create
    public Post(String aTitle, String aBody, User aUser){
        this.title = aTitle;
        this.body = aBody;
        this.user = aUser;
    }

    //Update
    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    //Search
    public Post(long id, String title, String body, String createTime, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createTime = createTime;
        this.user = user;
    }

    //Getters and Setters
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String aTitle){
        this.title = aTitle;
    }

    public String getBody(){
        return this.body;
    }

    public void setBody(String aBody){
        this.body = aBody;
    }

    public String getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(String newCreateTime) {
        this.createTime = newCreateTime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
