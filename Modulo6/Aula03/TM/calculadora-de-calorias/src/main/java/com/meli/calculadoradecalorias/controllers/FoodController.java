package com.meli.calculadoradecalorias.controllers;

import com.meli.calculadoradecalorias.entities.Food;
import com.meli.calculadoradecalorias.services.FoodService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    public FoodController() {}

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<?> getAllFoods() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getFoodByName(@PathVariable String name) {
        Food food = foodService.findFoodByName(name);

        return food != null
                ? ResponseEntity.ok(food)
                : ResponseEntity.badRequest().body("Fruta não encontrada");
    }

    @GetMapping("/calories/{calories}")
    public ResponseEntity<?> getFoodsByCalorie(@PathVariable Double calories) {
        List<Food> foods = foodService.findFoodsByCalories(calories);

        return foods.isEmpty()
                ? ResponseEntity.badRequest().body("Fruta não encontrada")
                : ResponseEntity.ok(foods);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createFood(@RequestBody Food food) {
        if(food.getName() == null){
            return ResponseEntity.badRequest().body("Nome não pode ser null");
        }

        foodService.add(food);

        return ResponseEntity.ok().build();
    }


}
