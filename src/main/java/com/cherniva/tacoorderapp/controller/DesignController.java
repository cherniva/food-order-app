package com.cherniva.tacoorderapp.controller;

import com.cherniva.tacoorderapp.dto.TacoDto;
import com.cherniva.tacoorderapp.model.Ingredient;
import com.cherniva.tacoorderapp.model.Taco;
import com.cherniva.tacoorderapp.model.TacoOrder;
import com.cherniva.tacoorderapp.repository.TacoRepository;
import com.cherniva.tacoorderapp.service.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
@Slf4j
public class DesignController {

    private final IngredientService ingredientService;
    private final TacoRepository tacoRepository;

    @ModelAttribute(name = "ingredientList")
    public List<Ingredient> ingredientList() {
        return ingredientService.getAllIngredientsSortedByType();
    }

    @GetMapping
    public String design(Model model) {
        model.addAttribute("tacoDto", new TacoDto());
        return "design";
    }

    @PostMapping
    public String getTaco(@ModelAttribute TacoOrder tacoOrder, @Valid TacoDto tacoDto, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("tacoDto", tacoDto);
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
