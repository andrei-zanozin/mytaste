package com.zanozin.mytaste.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Getter
@Builder
public class Recipe {

    @NonNull
    private final Long id;

    @NonNull
    @Setter
    private String header;

    @Setter
    private String description;

    @NonNull
    @Setter
    private Set<Ingredient> ingredients;
}
