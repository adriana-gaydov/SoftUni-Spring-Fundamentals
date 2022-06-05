package bg.softuni.mobiLeLeLe;

import bg.softuni.mobiLeLeLe.models.Brand;
import bg.softuni.mobiLeLeLe.services.BrandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner  {

    private BrandService brandService;

    public ApplicationRunner(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public void run(String... args) throws Exception {


        Brand brand = new Brand("Adidas");
        this.brandService.saveBrand(brand);

    }
}
