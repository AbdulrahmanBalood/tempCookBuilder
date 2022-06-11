package com.example.cookbuilder.Repository;

import com.example.cookbuilder.Model.Allergies;
import com.example.cookbuilder.Model.FavoriteCuisine;
import com.example.cookbuilder.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface FavoriteCuisineRepository extends JpaRepository<FavoriteCuisine,Integer> {
    Set<FavoriteCuisine> findAllByUser(MyUser user);
}
