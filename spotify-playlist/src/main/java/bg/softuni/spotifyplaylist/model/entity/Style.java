package bg.softuni.spotifyplaylist.model.entity;

import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private StyleNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Style() {
    }

    public StyleNameEnum getName() {
        return name;
    }

    public Style setName(StyleNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Style setDescription(String description) {
        this.description = description;
        return this;
    }
}
