
package com.example.cookbuilder.APImodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Measures {

    @JsonProperty("metric")
    private Metric metric;

}
