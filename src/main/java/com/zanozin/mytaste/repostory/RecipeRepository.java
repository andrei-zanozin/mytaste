package com.zanozin.mytaste.repostory;

import com.zanozin.mytaste.model.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {

    List<Recipe> getOneDayMenu();

    Optional<Long> save(Recipe recipe);
}
