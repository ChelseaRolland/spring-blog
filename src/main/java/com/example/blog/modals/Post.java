package com.example.blog.modals;

public class Post {
    private long id;
    private String title;
    private String body;
    private String createTime;

    public Post(){}

    public Post(long id) {
        this.id = id;
    }

    public Post(String aTitle, String aBody){
        this.title = aTitle;
        this.body = aBody;
    }

    public Post(String title, String body, String createTime) {
        this.title = title;
        this.body = body;
        this.createTime = createTime;
    }

    public Post(long id, String title, String body, String createTime) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createTime = createTime;
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


}
