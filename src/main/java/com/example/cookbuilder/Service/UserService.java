package com.example.cookbuilder.Service;

import com.example.cookbuilder.DTO.UpdateUserDTO;
import com.example.cookbuilder.Exception.UserNotFoundException;
import com.example.cookbuilder.Model.Allergies;
import com.example.cookbuilder.Model.FavoriteCuisine;
import com.example.cookbuilder.Model.FavoriteRecipe;
import com.example.cookbuilder.Model.MyUser;
import com.example.cookbuilder.Repository.AllergiesRepository;
import com.example.cookbuilder.Repository.FavoriteCuisineRepository;
import com.example.cookbuilder.Repository.FavoriteRecipeRepository;
import com.example.cookbuilder.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FavoriteRecipeRepository favoriteRecipeRepository;
    private final AllergiesRepository allergiesRepository;
    private final FavoriteCuisineRepository favoriteCuisineRepository;

    public List<MyUser> getUsers(){
        return userRepository.findAll();
    }
    public void addUser(MyUser user){
        String hashPass = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPass);
        userRepository.save(user);

    }
    public MyUser getUserByEmail(String email){
        MyUser user = userRepository.getMyUserByEmail(email);
        return user;
    }
    public void updateUser(UpdateUserDTO updateUserDTO){
        MyUser user = getUserByEmail(updateUserDTO.getCurrentEmail());
        user.setUsername(updateUserDTO.getUsername());
        user.setEmail(updateUserDTO.getEmail());
        String hashPass = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPass);
        userRepository.save(user);
    }
    public void deleteUser(Integer userID){
        MyUser user = getUserByID(userID);
        userRepository.delete(user);
    }
    public MyUser getUserByID(Integer id){
        return userRepository.findById(id).orElseThrow(()->{
            throw new UserNotFoundException("User doesn't exist");
        });
    }
    public void addFavRecipe(Integer userID,Integer recipeID){
        MyUser user = getUserByID(userID);
        FavoriteRecipe favoriteRecipe = new FavoriteRecipe(null,recipeID,user);
        List<FavoriteRecipe> favoriteRecipeSet = user.getFavoriteRecipes();
        if(favoriteRecipeSet == null){
            favoriteRecipeSet = new ArrayList<>();
        }
        favoriteRecipeSet.add(favoriteRecipe);
        user.setFavoriteRecipes(favoriteRecipeSet);
        userRepository.save(user);
        favoriteRecipeRepository.save(favoriteRecipe);

    }
    public void removeRecipe(Integer userID,int recipeID){
        MyUser user = getUserByID(userID);
        List<FavoriteRecipe> favoriteRecipeList = user.getFavoriteRecipes();
        for (int i = 0; i < favoriteRecipeList.size();i++){
            FavoriteRecipe favoriteRecipe = favoriteRecipeList.get(i);
            if(recipeID == favoriteRecipe.getRecipeID()){
                favoriteRecipeList.remove(favoriteRecipe);
                favoriteRecipeRepository.delete(favoriteRecipe);
                user.setFavoriteRecipes(favoriteRecipeList);
                userRepository.save(user);

            }
        }

    }
    public void setUserAdmin(Integer userID){//
        MyUser user = getUserByID(userID);
        user.setRole("ADMIN");
        userRepository.save(user);
    }
    public void removeAdminRole(Integer userID){
        MyUser user = getUserByID(userID);
        user.setRole("USER");
        userRepository.save(user);
    }
    public void addAllergies(Integer uerID,String allergy){
        MyUser user = getUserByID(uerID);
        Allergies allergies = new Allergies(null,allergy,user);
        List<Allergies> allergiesSet= user.getAllergies();
        if(allergiesSet == null){
            allergiesSet = new ArrayList<>();
        }
        allergiesSet.add(allergies);
        user.setAllergies(allergiesSet);
        userRepository.save(user);
        allergiesRepository.save(allergies);

    }
    public void removeAllergies(Integer userID,String allergy){
        MyUser user = getUserByID(userID);
        List<Allergies> allergiesList = user.getAllergies();
        for (int i = 0; i < allergiesList.size();i++){
            Allergies allergies = allergiesList.get(i);
            if(allergy.equals(allergies.getAllergies())){
                allergiesList.remove(allergies);
                allergiesRepository.delete(allergies);
                user.setAllergies(allergiesList);
                userRepository.save(user);

            }
        }

    }
    public List<Allergies> getUserAllergies(Integer userID){
        MyUser user = getUserByID(userID);
        List<Allergies> allergies = user.getAllergies();

        return allergies;
    }
    public void addFavCuisine(Integer userID,String cuisine){
        MyUser user = getUserByID(userID);
        FavoriteCuisine favoriteCuisine = new FavoriteCuisine(null,cuisine,user);
        List<FavoriteCuisine> favoriteCuisines = user.getFavoriteCuisines();
        if(favoriteCuisines == null){
            favoriteCuisines = new ArrayList<>();
        }
        favoriteCuisines.add(favoriteCuisine);
        user.setFavoriteCuisines(favoriteCuisines);
        userRepository.save(user);
        favoriteCuisineRepository.save(favoriteCuisine);
    }
    public void deleteFavCuisine(Integer userID,String cuisine){
        MyUser user = getUserByID(userID);
        List<FavoriteCuisine> favoriteCuisines = user.getFavoriteCuisines();
        for (int i = 0; i < favoriteCuisines.size();i++){
            FavoriteCuisine favoriteCuisine = favoriteCuisines.get(i);
            if(cuisine.equals(favoriteCuisine.getCuisines())){
                favoriteCuisines.remove(favoriteCuisine);
                favoriteCuisineRepository.delete(favoriteCuisine);
                user.setFavoriteCuisines(favoriteCuisines);
                userRepository.save(user);
            }
        }
    }


}
