package com.example.blog.modals;

import javax.persistence.*;

@Entity
@Table(name = "ad_images")
public class AdImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String path;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    //Constructor
    public AdImage(){}

    //Create
    public AdImage(String path, Ad ad) {
        this.path = path;
        this.ad = ad;
    }

    //Read
    public AdImage(long id, String path, Ad ad) {
        this.id = id;
        this.path = path;
        this.ad = ad;
    }

    //Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
