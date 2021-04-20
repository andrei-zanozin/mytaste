package com.zanozin.mytaste.model.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {

    private final Long id;

    private final String name;
}
