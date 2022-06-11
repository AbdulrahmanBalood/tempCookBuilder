
package com.example.cookbuilder.APImodels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
public class UsedIngredient {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("name")
    private String name;
    @JsonProperty("original")
    private String original;
    @JsonProperty("meta")
    private List<String> meta = null;
    @JsonProperty("image")
    private String image;


}
