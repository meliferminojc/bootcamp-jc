package com.meli.calculadoradecalorias.services;

import com.meli.calculadoradecalorias.entities.Food;
import com.meli.calculadoradecalorias.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public  FoodService() {}

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAll() {
        return foodRepository.getList();
    }

    public Food findFoodByName(String name){
        return foodRepository.getFoodByName(name);
    }

    public List<Food> findFoodsByCalories(Double calories) {
        return foodRepository.getFoodsByCalorie(calories);
    }

    public void add(Food food) {
        foodRepository.add(food);
    }
}
