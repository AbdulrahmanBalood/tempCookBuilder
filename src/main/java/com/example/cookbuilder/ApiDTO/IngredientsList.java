package com.example.cookbuilder.ApiDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class IngredientsList {
    List<String> ingredients;
}
