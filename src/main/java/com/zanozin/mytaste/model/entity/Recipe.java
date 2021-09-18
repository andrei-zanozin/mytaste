package com.zanozin.mytaste.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {

    @Setter
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @ManyToOne
    private User user;

    @Setter
    @NotNull
    @Size(min = 2, message = "Header must be at least 2 characters long.")
    private String header;

    @Setter
    @NotNull
    @Size(min = 5, message = "Description must be at least 5 characters long.")
    private String description;
}
