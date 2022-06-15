package bg.softuni.shoppinglist.model.binding;

import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;
import org.aspectj.lang.annotation.Before;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past!")
    private LocalDateTime neededBefore;

    @Positive(message = "Price must be positive number!")
    private BigDecimal price;

    @NotNull(message = "Category must be selected!")
    private CategoryNameEnum category;

    public ProductAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }



    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }
}
