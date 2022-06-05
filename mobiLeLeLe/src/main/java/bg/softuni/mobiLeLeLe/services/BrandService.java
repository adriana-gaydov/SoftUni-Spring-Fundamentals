package bg.softuni.mobiLeLeLe.services;

import bg.softuni.mobiLeLeLe.models.Brand;
import bg.softuni.mobiLeLeLe.repositories.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void saveBrand(Brand brand) {
        this.brandRepository.save(brand);
    }
}
