package com.meli.calculadoradecalorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoradecalorias.entities.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FoodRepository {
    private static final File FILE = new File("food.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Food> getList(){
        List<Food> foods = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FILE);
            TypeReference<List<Food>> typeReference = new TypeReference<>(){};
            foods = mapper.readValue(fis, typeReference);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return foods;
    }

    public Food getFoodByName(String name) {
        List<Food> foods = this.getList();
        Optional<Food> foodOptional = foods.stream()
                                        .filter(food -> food.getName().equals(name)).findFirst();

        return foodOptional.isEmpty() ? null : foodOptional.get();

    }

    public List<Food> getFoodsByCalorie(Double calories) {
        List<Food> foods = this.getList();

        return foods.stream()
                .filter(food -> food.getCalories().equals(calories))
                .collect(Collectors.toList());
    }

    public void add(Food food) {
        try {
            List<Food> foods = getList();
            foods.add(food);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, foods);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
