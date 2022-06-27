package bg.softuni.battleship.model.binding;

import bg.softuni.battleship.model.enums.CategoryNameEnum;
import bg.softuni.battleship.validation.UniqueShipName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipAddBindingModel {

    @NotNull
    @Size(min = 2, max = 10, message = "The name must be between 2 and 10 characters.")
    @UniqueShipName
    private String name;

    @NotNull(message = "The power cannot be empty.")
    @Positive(message = "The power must be positive.")
    private Long power;

    @NotNull(message = "The health cannot be empty.")
    @Positive(message = "The health must be positive.")
    private Long health;

    @NotNull(message = "The date cannot be empty.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Created date cannot be in the future.")
    private LocalDate created;

    @NotNull(message = "You  must select the category.")
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
