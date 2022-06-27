package bg.softuni.battleship.model.entity;

import bg.softuni.battleship.model.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, unique = true)
    private CategoryNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
