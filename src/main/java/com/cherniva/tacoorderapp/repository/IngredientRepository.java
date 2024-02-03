package com.cherniva.tacoorderapp.repository;

import com.cherniva.tacoorderapp.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
