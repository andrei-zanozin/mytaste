package com.zanozin.mytaste.controller;

import com.zanozin.mytaste.model.entity.Recipe;
import com.zanozin.mytaste.model.entity.User;
import com.zanozin.mytaste.repostory.RecipeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/record")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RecordController {

    @NonNull
    private final RecipeRepository recipeRepository;

    @GetMapping
    public String getRecordPage(Model model) {
        Recipe emptyRecipe = Recipe.builder()
                // Id is always 0 until ORM handle it.
                .id(0L)
                .build();
        model.addAttribute("recipe", emptyRecipe);

        return "record";
    }

    @PostMapping
    public String recordRecipe(@Valid Recipe recipe, Errors errors, @AuthenticationPrincipal User loggedUser) {
        if (errors.hasErrors()) {
            return "record";
        } else {
            recipe.setUser(loggedUser);
            recipeRepository.save(recipe);
            return "redirect:/record";
        }
    }

}
