package com.example.cookbuilder.Service;

import com.example.cookbuilder.APImodels.*;
import com.example.cookbuilder.ApiDTO.IngredientsList;
import com.example.cookbuilder.ApiDTO.NutrientsList;
import com.example.cookbuilder.Exception.DietTypeException;
import com.example.cookbuilder.Exception.NoAllergiesFound;
import com.example.cookbuilder.Exception.NoCuisineFound;
import com.example.cookbuilder.Model.Allergies;
import com.example.cookbuilder.Model.FavoriteCuisine;
import com.example.cookbuilder.Model.MyUser;
import com.example.cookbuilder.Repository.AllergiesRepository;
import com.example.cookbuilder.Repository.FavoriteCuisineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final UserService userService;
    private final RestTemplate restTemplate;
    private final AllergiesRepository allergiesRepository;
    private final FavoriteCuisineRepository favoriteCuisineRepository;
    public GetHomePageRecipes loadHomePageRecipe(){
        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random/?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89&number=20";
        ResponseEntity<GetHomePageRecipes> response = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<GetHomePageRecipes>() {
                });
        return response.getBody();
    }
    public List<RecipeByIngredient> getByIngredient(List<String> ing){
        String params = "";
        String base_url="https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89";

        params+=ing.get(0);

        for (int i = 1; i < ing.size();i++){
            params+="%2C"+ing.get(i);
        }

        String findByIngredient = "&ingredients="+params+"&number=10&limitLicense=false&ignorePantry=false&ranking=1";
        System.out.println(findByIngredient);
        ResponseEntity<List<RecipeByIngredient>> recipe =
                restTemplate.exchange(base_url+findByIngredient,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<RecipeByIngredient>>() {
                        });
        return recipe.getBody();
    }
    public GetRecipeByCuisine getRecipeByCuisine(String cuisine){
        String getByCuisineURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89&cuisine="+
                cuisine;
        ResponseEntity<GetRecipeByCuisine> response =
                restTemplate.exchange(getByCuisineURL,HttpMethod.GET,null,new ParameterizedTypeReference<GetRecipeByCuisine>(){});
        return response.getBody();
    }


    public GetRecipeByCuisine getRecipeByDiet(String diet) {
        String getByDietURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89&diet="+
                diet;
        System.out.println(diet);
        if(!(diet.toLowerCase().equals("pescetarian")||diet.toLowerCase().equals("lacto ovo vegetarian")||diet.toLowerCase().equals("vegan")||diet.toLowerCase().equals("paleo")
                ||diet.toLowerCase().equals("primal")||diet.toLowerCase().equals("vegetarian")||diet.toLowerCase().equals("whole30")
                ||diet.toLowerCase().equals("ketogenic")||diet.toLowerCase().equals("gluten free")||diet.toLowerCase().equals("fodmap friendly")||diet.toLowerCase().equals("dairy free"))){
            throw new DietTypeException("Diet type must be :pescetarian, lacto vegetarian, ovo vegetarian, vegan, paleo, primal, or vegetarian");
        }
        ResponseEntity<GetRecipeByCuisine> response =
                restTemplate.exchange(getByDietURL,HttpMethod.GET,null,new ParameterizedTypeReference<GetRecipeByCuisine>(){});
        return response.getBody();

    }

    public GetRecipeByCuisine getRecipeByTitle(String title) {
        String getByDietURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89&titleMatch="+
                title;

        ResponseEntity<GetRecipeByCuisine> response =
                restTemplate.exchange(getByDietURL,HttpMethod.GET,null,new ParameterizedTypeReference<GetRecipeByCuisine>(){});
        return response.getBody();
    }
    public GetRecipeInfo getRecipeInfo(Integer id){
        String getRecipeInfoURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"+id+"/information?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89";
        ResponseEntity<GetRecipeInfo> response = restTemplate.exchange(getRecipeInfoURL,HttpMethod.GET,null,new ParameterizedTypeReference<GetRecipeInfo>(){});
        return response.getBody();


    }
    public List<GetRecipeByNutrient> getRecipeByNutrient(NutrientsList nutrientsList)   {
        String baseURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByNutrients?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89";
        String paramsURL = "";
        Field[] fields = NutrientsList.class.getDeclaredFields();
        for (Field f : fields){
            Object value = new Object();
            f.setAccessible(true);
            try {
                 value = f.get(nutrientsList);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (value != null) {
                paramsURL+="&"+f.getName()+"="+value;
            }

    }
        String getRecipeByNutrientURL = baseURL+paramsURL;



        ResponseEntity<List<GetRecipeByNutrient>> response =
                restTemplate.exchange(getRecipeByNutrientURL,HttpMethod.GET,null,new ParameterizedTypeReference<List<GetRecipeByNutrient>>(){});
        return response.getBody();
    }
//     public GetRecipeByCuisine excludeAllergies(Integer userID){
//         MyUser user = userService.getUserByID(userID);
//         Set<Allergies> allergies = allergiesRepository.findAllByUser(user);//throw exception if user didn't add allergies
//         if (allergies.isEmpty()){
//             throw new NoAllergiesFound("No allergies found for this user");
//         }
//         String allergiesURL= "";
//         for(Allergies s : allergies){
//             allergiesURL += "%20"+s.getAllergies();
//         }


//         String excludeAllergiesURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89&excludeIngredients=";
//         ResponseEntity<GetRecipeByCuisine> response =
//                 restTemplate.exchange(excludeAllergiesURL+allergiesURL,HttpMethod.GET,null,new ParameterizedTypeReference<GetRecipeByCuisine>(){});
//         return response.getBody();
//     }
//     public GetRecipeByCuisine getRecipesByCuisines(Integer userID){
//         MyUser user = userService.getUserByID(userID);
//         Set<FavoriteCuisine> favoriteCuisines = favoriteCuisineRepository.findAllByUser(user);
//         if(favoriteCuisines.isEmpty()){
//             throw new NoCuisineFound("No Favorite Cuisines found for this user");
//         }
//         String cuisineURL = "";
//         for (FavoriteCuisine favoriteCuisine: favoriteCuisines){
//             cuisineURL += "%20"+favoriteCuisine.getCuisines();
//         }
//         String baseURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89&cuisine=";
//         ResponseEntity<GetRecipeByCuisine> response =
//                 restTemplate.exchange(baseURL+cuisineURL,HttpMethod.GET,null,new ParameterizedTypeReference<GetRecipeByCuisine>(){});
//         return response.getBody();
//     }
    }



