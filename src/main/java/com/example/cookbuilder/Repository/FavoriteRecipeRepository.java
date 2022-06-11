package com.example.cookbuilder.Repository;

import com.example.cookbuilder.Model.FavoriteRecipe;
import com.example.cookbuilder.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRecipeRepository extends JpaRepository<FavoriteRecipe,Integer> {
    List<FavoriteRecipe> findFavoriteRecipeByUser(MyUser user);
}
