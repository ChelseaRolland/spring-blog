package com.example.blog.modals;
import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<AdImage> images;

    @ManyToMany(cascade = CascadeType.ALL)
    //new table will be created with the combining of columns of ad_id and category_id
    @JoinTable(
            name = "ads_categories",
            joinColumns = {@JoinColumn(name = "ad_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<AdCategory> categories;


    public Ad(){}

    //CREATE/INSERT
    public Ad(String title, String description, User owner, List<AdImage> images) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.images = images;
    }

    //READ
    public Ad(long id, String title, String description, User owner, List<AdImage> images){
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<AdImage> getImages() {
        return images;
    }

    public void setImages(List<AdImage> images) {
        this.images = images;
    }

    public List<AdCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<AdCategory> categories) {
        this.categories = categories;
    }
}
