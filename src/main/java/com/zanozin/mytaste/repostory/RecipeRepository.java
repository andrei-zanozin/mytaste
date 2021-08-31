package com.zanozin.mytaste.repostory;

import com.zanozin.mytaste.model.entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query(value = "SELECT * FROM Recipe ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Recipe> getOneDayMenu();
}
