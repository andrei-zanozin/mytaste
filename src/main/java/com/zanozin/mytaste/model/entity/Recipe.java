package com.zanozin.mytaste.model.entity;

import lombok.*;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Setter
    private Long id;

    @Setter
    private String header;

    @Setter
    private String description;

    @Setter
    private Set<Ingredient> ingredients;
}
