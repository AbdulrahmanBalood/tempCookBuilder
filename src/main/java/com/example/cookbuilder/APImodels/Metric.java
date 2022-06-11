
package com.example.cookbuilder.APImodels;


import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Generated("jsonschema2pojo")
public class Metric {

    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("unitShort")
    private String unitShort;
    @JsonProperty("unitLong")
    private String unitLong;

}
