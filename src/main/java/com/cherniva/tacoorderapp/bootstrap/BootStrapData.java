package com.cherniva.tacoorderapp.bootstrap;

import com.cherniva.tacoorderapp.model.Ingredient;
import com.cherniva.tacoorderapp.model.IngredientType;
import com.cherniva.tacoorderapp.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootStrapData implements CommandLineRunner {

    private final IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Ingredient> ingredientList = List.of(
                new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
                new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
                new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
                new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
                new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
                new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
        );

        ingredientRepository.saveAll(ingredientList);
        log.info("Save ingredients to database");
    }
}
