package bg.softuni.battleship.service;

import bg.softuni.battleship.model.view.ShipViewModel;
import bg.softuni.battleship.service.model.ShipServiceModel;

import java.util.List;

public interface ShipService {
    boolean existsByShipName(String name);

    ShipServiceModel addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> getAllShips();
}
