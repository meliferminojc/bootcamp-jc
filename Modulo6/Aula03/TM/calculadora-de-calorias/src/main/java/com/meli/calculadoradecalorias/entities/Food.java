package com.meli.calculadoradecalorias.entities;

public class Food {
    private String name;
    private Double calories;

    public Food(String name, Double calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public Double getCalories() {
        return calories;
    }

}
