
package com.example.cookbuilder.APImodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetRecipeByCuisine {

    @JsonProperty("results")
    private List<Result> results = null;


}
