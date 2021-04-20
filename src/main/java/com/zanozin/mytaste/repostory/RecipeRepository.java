package com.zanozin.mytaste.repostory;

import com.zanozin.mytaste.model.entity.Recipe;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository {

    Recipe getAnyRecipe();
}
