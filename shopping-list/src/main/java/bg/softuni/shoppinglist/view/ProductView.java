package bg.softuni.shoppinglist.view;

import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;

import java.math.BigDecimal;

public class ProductView {

    private Long id;
    private String name;

    private BigDecimal price;

    private CategoryNameEnum category;

    public ProductView() {
    }

    public String getName() {
        return name;
    }

    public ProductView setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductView setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ProductView setId(Long id) {
        this.id = id;
        return this;
    }
}
