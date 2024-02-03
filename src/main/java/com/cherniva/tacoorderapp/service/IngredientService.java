package com.cherniva.tacoorderapp.service;

import com.cherniva.tacoorderapp.model.Ingredient;
import com.cherniva.tacoorderapp.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public List<Ingredient> getAllIngredientsSortedByType() {
        return ingredientRepository.findAll().stream().sorted((i1, i2) -> (i1.getType().toString().compareTo(i2.getType().toString()))).toList();
    }

}
