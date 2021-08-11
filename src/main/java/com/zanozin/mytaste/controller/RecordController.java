package com.zanozin.mytaste.controller;

import com.zanozin.mytaste.model.entity.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/record")
public class RecordController {

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
    public String recordRecipe(Recipe recipe) {
        return "record";
    }

}
