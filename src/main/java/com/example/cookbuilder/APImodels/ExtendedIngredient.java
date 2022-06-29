package com.example.cookbuilder.APImodels;

import lombok.Data;

import java.util.List;

@Data
public class ExtendedIngredient {
    private Integer id;
    private String aisle;
    private String image;
    private String consistency;
    private String name;
    private String nameClean;
    private String original;
    private String originalName;
    private Double amount;
    private String unit;
    private List<String> meta = null;

    private Measures measures;
}
