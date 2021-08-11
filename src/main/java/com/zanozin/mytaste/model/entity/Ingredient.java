package com.zanozin.mytaste.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Ingredient {

    @Setter
    private Product product;

    @Setter
    private Double quantity;

    // TODO Add measure here
}
