package bg.softuni.battleship.init;

import bg.softuni.battleship.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private CategoryService categoryService;

    public DatabaseInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.categoryService.initCategories();
    }
}
