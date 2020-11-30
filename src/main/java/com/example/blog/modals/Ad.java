package com.example.blog.modals;
import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    //default length is 255, so if you want to adjust it then you will input the length like above
    //if dont want to update the length, then dont add it to the column properties
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    public Ad(){}

    public Ad(long id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
