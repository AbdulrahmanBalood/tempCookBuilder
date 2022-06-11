
package com.example.cookbuilder.APImodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Step {

    @JsonProperty("number")
    private Integer number;
    @JsonProperty("step")
    private String step;
    @JsonProperty("ingredients")
    private List<Ingredient> ingredients = null;
    @JsonProperty("equipment")
    private List<Equipment> equipment = null;
    @JsonProperty("length")
    private Time length;

}
