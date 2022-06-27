package bg.softuni.battleship.model.view;

import bg.softuni.battleship.service.model.UserServiceModel;

public class ShipViewModel {


    private Long id;
    private String name;
    private Long health;
    private Long power;
    private UserServiceModel user;

    public ShipViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipViewModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipViewModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public ShipViewModel setUser(UserServiceModel user) {
        this.user = user;
        return this;
    }
}
