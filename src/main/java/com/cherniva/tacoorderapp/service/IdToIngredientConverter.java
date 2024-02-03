package com.cherniva.tacoorderapp.service;

import com.cherniva.tacoorderapp.model.Ingredient;
import com.cherniva.tacoorderapp.model.IngredientType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class IdToIngredientConverter {
    private final HashMap<String, Ingredient> idIngredientMap;

    public IdToIngredientConverter() {
        idIngredientMap = new HashMap<>();
        idIngredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
        idIngredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP));
        idIngredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN));
        idIngredientMap.put("CARN", new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN));
        idIngredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES));
        idIngredientMap.put("LETC", new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES));
        idIngredientMap.put("CHED", new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
        idIngredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE));
        idIngredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
        idIngredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));

    }

    public Ingredient convert(String id) {
        return idIngredientMap.get(id);
    }
}
