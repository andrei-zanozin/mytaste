package com.zanozin.mytaste.controller;

import com.zanozin.mytaste.model.entity.Recipe;
import com.zanozin.mytaste.repostory.RecipeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/one_day")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OneDayMenuController {

    @NonNull
    private final RecipeRepository recipeRepository;

    @GetMapping
    public String getOneDayMenu(Model model) {
        Recipe anyRecipe = recipeRepository.getAnyRecipe();

        model.addAttribute("breakfast", anyRecipe);
        model.addAttribute("lunch", anyRecipe);
        model.addAttribute("dinner", anyRecipe);

        return "one_day";
    }
}
