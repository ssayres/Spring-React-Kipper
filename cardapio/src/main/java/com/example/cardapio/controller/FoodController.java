package com.example.cardapio.controller;

import food.Food;
import food.FoodRepository;
import food.FoodRequestDTO;
import food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

   @Autowired
    private FoodRepository repository;

   @CrossOrigin(origins = "*", allowedHeaders = "*")
   @PostMapping
   public void saveFood(@RequestBody FoodRequestDTO data){
       Food formData = new Food(data);
       repository.save(formData);
       return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;

    }
}
