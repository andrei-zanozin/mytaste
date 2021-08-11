package com.zanozin.mytaste.repostory;

import com.zanozin.mytaste.model.entity.Recipe;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    @Override
    public Recipe getAnyRecipe() {
        Recipe caprese = Recipe.builder()
                .id(0L)
                .header("Caprese")
                .description("The simple Caprese.")
                .build();

        return caprese;
    }
}
