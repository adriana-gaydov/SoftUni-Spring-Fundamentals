package bg.softuni.battleship.service.impl;

import bg.softuni.battleship.model.entity.Category;
import bg.softuni.battleship.model.entity.Ship;
import bg.softuni.battleship.model.entity.User;
import bg.softuni.battleship.model.view.ShipViewModel;
import bg.softuni.battleship.repository.ShipRepository;
import bg.softuni.battleship.security.CurrentUser;
import bg.softuni.battleship.service.CategoryService;
import bg.softuni.battleship.service.ShipService;
import bg.softuni.battleship.service.UserService;
import bg.softuni.battleship.service.model.ShipServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {

    private ShipRepository shipRepository;
    private ModelMapper modelMapper;
    private CategoryService categoryService;
    private UserService userService;
    private CurrentUser currentUser;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CategoryService categoryService, UserService userService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public boolean existsByShipName(String name) {

        return this.shipRepository.findByName(name).isPresent();
    }

    @Override
    public ShipServiceModel addShip(ShipServiceModel shipServiceModel) {

        Ship ship = this.modelMapper.map(shipServiceModel, Ship.class);

        Category category = this.categoryService.findByCategoryNameEnum(shipServiceModel.getCategory());
        User user = this.userService.findById(this.currentUser.getId());

        ship.setCategory(category);
        ship.setUser(user);

        this.shipRepository.save(ship);

        return this.modelMapper.map(ship, ShipServiceModel.class);
    }

    @Override
    public List<ShipViewModel> getAllShips() {

        List<Ship> ships = this.shipRepository.findAll();

        return ships.stream()
                .map(s -> this.modelMapper.map(s, ShipViewModel.class))
                .toList();
    }
}
