package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.models.enums.LevelEnum;
import bg.softuni.pathfinder.models.users.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(name = "gpx_coordinates", nullable = false, columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LevelEnum level;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private User author;

    @Column(name = "video_url")
    private String videoURL;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

    public Route() {
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public Route setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public Route setVideoURL(String videoURL) {
        this.videoURL = videoURL;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Route setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }
}
