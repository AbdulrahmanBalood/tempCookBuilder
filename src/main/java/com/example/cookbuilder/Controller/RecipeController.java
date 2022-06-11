package com.example.cookbuilder.Controller;

import com.example.cookbuilder.APImodels.*;
import com.example.cookbuilder.ApiDTO.IngredientsList;
import com.example.cookbuilder.ApiDTO.NutrientsList;
import com.example.cookbuilder.DTO.ResponseAPI;
import com.example.cookbuilder.Service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipe")
@RequiredArgsConstructor
public class RecipeController {
    Logger logger = LoggerFactory.getLogger(RecipeController.class);
    private final RecipeService recipeService;
    @GetMapping("/recipes/findbyingredients")
    public ResponseEntity<List<RecipeByIngredient>> getByIngredient(@RequestBody IngredientsList ingredients){
        logger.info("method getByIngredient in RecipeController used");
        List<RecipeByIngredient> response = recipeService.getByIngredient(ingredients);
        return ResponseEntity.status(200).body(response);
    }
    @GetMapping("/recipes/findbycuisine/{cuisine}")
    public ResponseEntity<GetRecipeByCuisine> getRecipeByCuisine(@PathVariable String cuisine){
        logger.info("method getRecipeByCuisine in RecipeController used");
        return ResponseEntity.status(200).body(recipeService.getRecipeByCuisine(cuisine));
    }
    @GetMapping("/recipes/findbydiet/{diet}")
    public ResponseEntity<GetRecipeByCuisine> getRecipeByDiet(@PathVariable String diet){
        logger.info("method getRecipeByDiet in RecipeController used");
        return ResponseEntity.status(200).body(recipeService.getRecipeByDiet(diet));
    }
    @GetMapping("/recipes/findbytitle/{title}")
    public ResponseEntity<GetRecipeByCuisine> getRecipeByTitle(@PathVariable String title){
        logger.info("method getRecipeByTitle in RecipeController used");
        return ResponseEntity.status(200).body(recipeService.getRecipeByTitle(title));
    }
    @GetMapping("/user/getrecipeinfo/{id}")
    public ResponseEntity<GetRecipeInfo> getRecipeInfo(@PathVariable Integer id){
        logger.info("method getRecipeInfo in RecipeController used");
        return ResponseEntity.status(200).body(recipeService.getRecipeInfo(id));
    }
    @GetMapping("/recipes/findbynutrients")
    public ResponseEntity<List<GetRecipeByNutrient>> getByNutrients(@RequestBody NutrientsList nutrientsList) {
        logger.info("method getByNutrients in RecipeController used");
        return ResponseEntity.status(200).body(recipeService.getRecipeByNutrient(nutrientsList));
    }
//     @GetMapping("/user/excludeallergies/{userID}")
//     public ResponseEntity<GetRecipeByCuisine> excludeAllergies(@PathVariable Integer userID){
//         logger.info("method excludeAllergies in RecipeController used");
//         return ResponseEntity.status(200).body(recipeService.excludeAllergies(userID));
//     }
//     @GetMapping("/user/getfavcuisine/{userID}")
//     public ResponseEntity<GetRecipeByCuisine> getRecipesByCuisines(@PathVariable Integer userID){
//         logger.info("method excludeAllergies in RecipeController used");
//         return ResponseEntity.status(200).body(recipeService.getRecipesByCuisines(userID));
//     }





}
