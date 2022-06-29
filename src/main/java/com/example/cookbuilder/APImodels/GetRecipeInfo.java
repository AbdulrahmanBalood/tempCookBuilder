
package com.example.cookbuilder.APImodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class GetRecipeInfo {

    @JsonProperty("preparationMinutes")
    private Integer preparationMinutes;
    @JsonProperty("cookingMinutes")
    private Integer cookingMinutes;
    @JsonProperty("healthScore")
    private Integer healthScore;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("readyInMinutes")
    private Integer readyInMinutes;
    @JsonProperty("servings")
    private Integer servings;
    @JsonProperty("image")
    private String image;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("cuisines")
    private List<Object> cuisines = null;
    @JsonProperty("dishTypes")
    private List<String> dishTypes = null;
    @JsonProperty("diets")
    private List<String> diets = null;
    @JsonProperty("occasions")
    private List<Object> occasions = null;
    @JsonProperty("instructions")
    private String instructions;
    @JsonProperty("analyzedInstructions")
    private List<AnalyzedInstruction> analyzedInstructions = null;
    @JsonProperty("originalId")
    private Object originalId;
    private List<ExtendedIngredient> extendedIngredients = null;



}
