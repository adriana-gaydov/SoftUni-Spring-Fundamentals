package bg.softuni.spotifyplaylist.model.service;

import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;

import java.time.LocalDate;

public class SongServiceModel {

    private Long id;
    private String performer;
    private String title;
    private Integer duration;
    private LocalDate releaseDate;
    private StyleNameEnum style;

    public SongServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public SongServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongServiceModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongServiceModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongServiceModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public StyleNameEnum getStyle() {
        return style;
    }

    public SongServiceModel setStyle(StyleNameEnum style) {
        this.style = style;
        return this;
    }
}
