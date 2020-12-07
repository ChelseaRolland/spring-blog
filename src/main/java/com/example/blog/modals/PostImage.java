package com.example.blog.modals;

import javax.persistence.*;

@Entity
@Table(name = "post_images")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String urlPath;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    //Constructor
    public PostImage(){}

    //Create
    public PostImage(String urlPath, Post post){
        this.urlPath = urlPath;
        this.post = post;
    }

    //Read
    public PostImage(long id, String urlPath, Post post) {
        this.id = id;
        this.urlPath = urlPath;
        this.post = post;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
