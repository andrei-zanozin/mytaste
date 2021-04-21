package com.zanozin.mytaste.repostory;

import com.zanozin.mytaste.model.entity.Ingredient;
import com.zanozin.mytaste.model.entity.Product;
import com.zanozin.mytaste.model.entity.Recipe;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    @Override
    public Recipe getAnyRecipe() {
        Ingredient tomatoes = Ingredient.builder()
                .product(Product.builder()
                        .id(0L)
                        .name("Tomatoes")
                        .build())
                .quantity(2.0d)
                .build();

        Ingredient mozzarella = Ingredient.builder()
                .product(Product.builder()
                        .id(1L)
                        .name("Mozzarella")
                        .build())
                .quantity(1.0d)
                .build();

        Ingredient basil = Ingredient.builder()
                .product(Product.builder()
                        .id(3L)
                        .name("Basil")
                        .build())
                .quantity(1.0d)
                .build();

        Ingredient oliveOil = Ingredient.builder()
                .product(Product.builder()
                        .id(4L)
                        .name("Olive oli")
                        .build())
                .quantity(30.0d)
                .build();

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(tomatoes);
        ingredients.add(mozzarella);
        ingredients.add(basil);
        ingredients.add(oliveOil);

        Recipe caprese = Recipe.builder()
                .id(0L)
                .header("Caprese")
                .description("The simple Caprese.")
                .ingredients(ingredients)
                .build();

        return caprese;
    }
}
