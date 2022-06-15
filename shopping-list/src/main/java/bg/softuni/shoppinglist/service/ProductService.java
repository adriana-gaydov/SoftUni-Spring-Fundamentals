package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;
import bg.softuni.shoppinglist.model.service.ProductServiceModel;
import bg.softuni.shoppinglist.view.ProductView;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void addProduct(ProductServiceModel productServiceModel);

    List<ProductView> findByCategoryNameEnum(CategoryNameEnum food);

    BigDecimal getTotalPriceOfProducts();

    void buyById(Long id);

    void buyAll();
}
