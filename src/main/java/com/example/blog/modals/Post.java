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

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    @ManyToMany(cascade = CascadeType.ALL)
    //new table will be created with the combining of columns of ad_id and category_id
    @JoinTable(
            name = "posts_categories",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<PostCategory> categories;

    public Post(){}

    //Insert/Create
    public Post(String title, String body, User user, List<PostImage> images){
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
    }

    //Update
    public Post(long id, String title, String body, User user, List<PostImage> images) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
    }

    //Search
    public Post(long id, String title, String body, String createTime, User user, List<PostImage> images) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createTime = createTime;
        this.user = user;
        this.images = images;
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

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public List<PostCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PostCategory> categories) {
        this.categories = categories;
    }
}
