package com.example.cookbuilder.APImodels;

import lombok.Data;

import java.util.List;

@Data
public class GetHomePageRecipes {
    private List<Recipes> Recipes;
}
