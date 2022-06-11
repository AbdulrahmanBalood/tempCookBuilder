
package com.example.cookbuilder.APImodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnalyzedInstruction {

    @JsonProperty("name")
    private String name;
    @JsonProperty("steps")
    private List<Step> steps = null;


}
