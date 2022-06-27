package bg.softuni.spotifyplaylist.model.binding;

import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;
import bg.softuni.spotifyplaylist.utils.validation.UniquePerformerName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static bg.softuni.spotifyplaylist.utils.messages.InvalidMessages.*;

public class SongAddBindingModel {

    @UniquePerformerName
    @NotNull
    @Size(min = 3, max = 20, message = INVALID_PERFORMER_LENGTH)
    private String performer;

    @NotNull
    @Size(min = 2, max = 20, message = INVALID_TITLE_LENGTH)
    private String title;

    @NotNull(message = RELEASE_DATE_EMPTY)
    @PastOrPresent(message = RELEASE_DATE_FUTURE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotNull(message = DURATION_EMPTY)
    @Positive(message = DURATION_NOT_POSITIVE)
    private Integer duration;

    @NotNull(message = STYLE_NOT_SELECTED)
    private StyleNameEnum style;

    public String getPerformer() {
        return performer;
    }

    public SongAddBindingModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongAddBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongAddBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongAddBindingModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public StyleNameEnum getStyle() {
        return style;
    }

    public SongAddBindingModel setStyle(StyleNameEnum style) {
        this.style = style;
        return this;
    }
}
