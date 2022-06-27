package bg.softuni.battleship.service.model;

import bg.softuni.battleship.model.entity.Category;
import bg.softuni.battleship.model.entity.User;
import bg.softuni.battleship.model.enums.CategoryNameEnum;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class ShipServiceModel {

    public Long id;
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipServiceModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
