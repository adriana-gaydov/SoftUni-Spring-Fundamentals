package bg.softuni.spotifyplaylist.model.view;

public class SongViewModel {

    private Long id;

    private String performer;

    private String title;

    private Integer duration;

    private String durationInMin;

    public SongViewModel() {
    }

    public Long getId() {
        return id;
    }

    public SongViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongViewModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongViewModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getDurationInMin() {
        return String.format("%d:%02d", duration / 60, duration % 60);
    }
}
