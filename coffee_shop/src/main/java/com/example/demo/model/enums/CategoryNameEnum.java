package com.example.demo.model.enums;

public enum CategoryNameEnum {
    COFFEE(2),
    CAKE(10),
    DRINK(1),
    OTHER(5);

    private int neededTime;

    CategoryNameEnum(int neededTime) {
        this.neededTime = neededTime;
    }

    public int getNeededTime() {
        return neededTime;
    }
}
