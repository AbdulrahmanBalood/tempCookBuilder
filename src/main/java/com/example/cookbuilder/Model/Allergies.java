package com.example.cookbuilder.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Allergies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String allergies;

    @ManyToOne
    @JsonIgnore
    private MyUser user;
}
