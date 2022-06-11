
package com.example.cookbuilder.APImodels;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;


//@JsonPropertyOrder({
//    "id",
//    "title",
//    "image",
//    "imageType",
//    "calories",
//    "protein",
//    "fat",
//    "carbs",
//    "caffeine",
//    "copper",
//    "calcium",
//    "cholesterol",
//    "saturatedFat",
//    "vitaminA",
//    "vitaminC",
//    "vitaminD",
//    "vitaminE",
//    "vitaminK",
//    "vitaminB1",
//    "vitaminB2",
//    "vitaminB3",
//    "vitaminB5",
//    "vitaminB6",
//    "vitaminB12",
//    "fiber",
//    "folate",
//    "iron",
//    "magnesium",
//    "manganese",
//    "phosphorus",
//    "potassium",
//    "selenium",
//    "sodium",
//    "sugar",
//    "zinc"
//})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRecipeByNutrient {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imageType")
    private String imageType;
    @JsonProperty("calories")
    private Integer calories;
    @JsonProperty("protein")
    private String protein;
    @JsonProperty("fat")
    private String fat;
    @JsonProperty("carbs")
    private String carbs;
    @JsonProperty("caffeine")
    private String caffeine;
    @JsonProperty("copper")
    private String copper;
    @JsonProperty("calcium")
    private String calcium;
    @JsonProperty("cholesterol")
    private String cholesterol;
    @JsonProperty("saturatedFat")
    private String saturatedFat;
    @JsonProperty("vitaminA")
    private String vitaminA;
    @JsonProperty("vitaminC")
    private String vitaminC;
    @JsonProperty("vitaminD")
    private String vitaminD;
    @JsonProperty("vitaminE")
    private String vitaminE;
    @JsonProperty("vitaminK")
    private String vitaminK;
    @JsonProperty("vitaminB1")
    private String vitaminB1;
    @JsonProperty("vitaminB2")
    private String vitaminB2;
    @JsonProperty("vitaminB3")
    private String vitaminB3;
    @JsonProperty("vitaminB5")
    private String vitaminB5;
    @JsonProperty("vitaminB6")
    private String vitaminB6;
    @JsonProperty("vitaminB12")
    private String vitaminB12;
    @JsonProperty("fiber")
    private String fiber;
    @JsonProperty("folate")
    private String folate;
    @JsonProperty("iron")
    private String iron;
    @JsonProperty("magnesium")
    private String magnesium;
    @JsonProperty("manganese")
    private String manganese;
    @JsonProperty("phosphorus")
    private String phosphorus;
    @JsonProperty("potassium")
    private String potassium;
    @JsonProperty("selenium")
    private String selenium;
    @JsonProperty("sodium")
    private String sodium;
    @JsonProperty("sugar")
    private String sugar;
    @JsonProperty("zinc")
    private String zinc;


}
