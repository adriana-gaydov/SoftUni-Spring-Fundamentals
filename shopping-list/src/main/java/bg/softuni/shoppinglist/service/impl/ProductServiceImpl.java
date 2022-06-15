package bg.softuni.shoppinglist.service.impl;

import bg.softuni.shoppinglist.model.entity.Category;
import bg.softuni.shoppinglist.model.entity.Product;
import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;
import bg.softuni.shoppinglist.model.service.ProductServiceModel;
import bg.softuni.shoppinglist.repository.ProductRepository;
import bg.softuni.shoppinglist.security.CurrentUser;
import bg.softuni.shoppinglist.service.CategoryService;
import bg.softuni.shoppinglist.service.ProductService;
import bg.softuni.shoppinglist.view.ProductView;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CurrentUser currentUser;
    private ModelMapper modelMapper;
    private CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CurrentUser currentUser, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {

        Product product = this.modelMapper.map(productServiceModel, Product.class);

        Category category = this.categoryService.findByCategoryNameEnum(productServiceModel.getCategory());
        product.setCategory(category);

       this.productRepository.save(product);
    }

    @Override
    public List<ProductView> findByCategoryNameEnum(CategoryNameEnum category) {

        return this.productRepository.findByCategoryName(category).stream().map(p -> this.modelMapper.map(p, ProductView.class))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getTotalPriceOfProducts() {

        return this.productRepository.findAll().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void buyById(Long id) {

        this.productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {

        this.productRepository.deleteAll();
    }
}
