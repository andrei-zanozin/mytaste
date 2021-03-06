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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/one_day")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OneDayMenuController {

    @NonNull
    private final RecipeRepository recipeRepository;

    @GetMapping
    public String getOneDayMenu(Model model, @AuthenticationPrincipal User loggedUser) {
        List<Recipe> oneDayMenu = recipeRepository.getOneDayMenu(loggedUser.getId());

        if (oneDayMenu.size() == 3) {
            model.addAttribute("breakfast", oneDayMenu.get(0));
            model.addAttribute("lunch", oneDayMenu.get(1));
            model.addAttribute("dinner", oneDayMenu.get(2));

            return "one_day";
        } else {
            return "redirect:/";
        }
    }
}
