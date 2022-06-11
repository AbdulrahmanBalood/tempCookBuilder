package com.example.cookbuilder.ApiDTO;

import com.example.cookbuilder.APImodels.GetRecipeByNutrient;
import lombok.Data;

import java.util.List;
@Data
public class GetRecipeByNutrientList {
    private List<GetRecipeByNutrient> getRecipeByNutrients = null;
}
