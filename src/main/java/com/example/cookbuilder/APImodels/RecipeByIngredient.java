
package com.example.cookbuilder.APImodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecipeByIngredient {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("image")
    private String image;
    @JsonProperty("usedIngredientCount")
    private Integer usedIngredientCount;
    @JsonProperty("missedIngredientCount")
    private Integer missedIngredientCount;
    @JsonProperty("missedIngredients")
    private List<MissedIngredient> missedIngredients = null;
    @JsonProperty("usedIngredients")
    private List<UsedIngredient> usedIngredients = null;
    @JsonProperty("unusedIngredients")
    private List<Object> unusedIngredients = null;
    @JsonProperty("likes")
    private Integer likes;


}
