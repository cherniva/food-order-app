package com.cherniva.tacoorderapp.controller;

import com.cherniva.tacoorderapp.dto.TacoDto;
import com.cherniva.tacoorderapp.model.Ingredient;
import com.cherniva.tacoorderapp.model.Taco;
import com.cherniva.tacoorderapp.model.TacoOrder;
import com.cherniva.tacoorderapp.repository.TacoRepository;
import com.cherniva.tacoorderapp.service.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class DesignController {

    private final IngredientService ingredientService;
    private final TacoRepository tacoRepository;

    @GetMapping
    public String design(Model model) {
        List<Ingredient> ingredientList = ingredientService.getAllIngredientsSortedByType();
        model.addAttribute("taco", new TacoDto());
        model.addAttribute("ingredientList", ingredientList);
        return "design";
    }

    @PostMapping
    public String getTaco(@ModelAttribute TacoOrder tacoOrder, @Valid TacoDto tacoDto, Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "design";
        }

        Taco taco = Taco.builder()
                .name(tacoDto.getName())
                .ingredients(tacoDto.getIngredients())
                .build();
        tacoRepository.save(taco);

        tacoOrder.addTaco(taco);

        return "redirect:/order";

    }

    @ModelAttribute
    public TacoOrder tacoOrder() {
        return new TacoOrder();
    }
}
