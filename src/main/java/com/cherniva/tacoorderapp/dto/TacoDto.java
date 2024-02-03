package com.cherniva.tacoorderapp.dto;


import com.cherniva.tacoorderapp.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TacoDto {
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();
}
