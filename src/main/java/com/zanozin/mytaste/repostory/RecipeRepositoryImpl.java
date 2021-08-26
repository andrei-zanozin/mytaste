package com.zanozin.mytaste.repostory;

import com.zanozin.mytaste.model.entity.Recipe;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RecipeRepositoryImpl implements RecipeRepository {

    @NonNull
    private final JdbcTemplate jdbc;

    @Override
    public List<Recipe> getOneDayMenu() {
        return jdbc.query("SELECT * FROM recipe ORDER BY RAND() LIMIT 3", this::mapRecipe);
    }

    private Recipe mapRecipe(ResultSet rs, int rowNumber) throws SQLException {
        return Recipe.builder()
                .id(rs.getLong(1))
                .header(rs.getString(2))
                .description(rs.getString(3))
                .build();
    }

    @Override
    public Optional<Long> save(Recipe recipe) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement("INSERT INTO recipe (header, description) VALUES (?, ?)",
                                    Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, recipe.getHeader());
                    ps.setString(2, recipe.getDescription());

                    return ps;
                },
                keyHolder);

        return Optional.ofNullable(keyHolder.getKeyAs(Long.class));
    }
}
