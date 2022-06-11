package com.example.cookbuilder.Controller;

import com.example.cookbuilder.DTO.ResponseAPI;
import com.example.cookbuilder.DTO.UpdateUserDTO;
import com.example.cookbuilder.Model.Allergies;
import com.example.cookbuilder.Model.MyUser;
import com.example.cookbuilder.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/admin/getusers")
    public ResponseEntity<List<MyUser>> getUsers(){
        logger.info("method getUsers in UserController used");
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseAPI> addUser(@RequestBody @Valid MyUser user){
        logger.info("method addUser in UserController used");
        userService.addUser(user);
        return ResponseEntity.status(201).body(new ResponseAPI("User added",201));
    }
    @PutMapping("/admin/updateuser")
    public ResponseEntity<ResponseAPI> updateUser(@RequestBody @Valid UpdateUserDTO updateUserDTO){
        logger.info("method updateUser in UserController used");
        userService.updateUser(updateUserDTO);
        return ResponseEntity.status(201).body(new ResponseAPI("User updated",201));
    }
    @DeleteMapping("/admin/deleteuser/{userID}")
    public ResponseEntity<ResponseAPI> deleteUser(@PathVariable Integer userID){
        logger.info("method deleteUser in UserController used");
        userService.deleteUser(userID);
        return ResponseEntity.status(201).body(new ResponseAPI("User deleted",201));
    }
    @PutMapping("/userrecipe/favrecipe/{userID}/{recipeID}")
    public ResponseEntity<ResponseAPI> addFavRecipe(@PathVariable Integer userID,@PathVariable Integer recipeID){
        logger.info("method addFavRecipe in UserController used");
        userService.addFavRecipe(userID,recipeID);
        return ResponseEntity.status(200).body(new ResponseAPI("New Favorite recipe added",200));
    }
    @PutMapping("/userrecipe/removerecipe/{userID}/{recipeID}")
    public ResponseEntity<ResponseAPI> removeRecipe(@PathVariable Integer userID, @PathVariable Integer recipeID){
        logger.info("method removeRecipe in UserController used");
        userService.removeRecipe(userID,recipeID);
        return ResponseEntity.status(200).body(new ResponseAPI("Recipe removed from the list",200));
    }
    @PutMapping("/admin/setadmin/{userID}")
    public ResponseEntity<ResponseAPI> setNewAdmin(@PathVariable Integer userID){
        logger.info("method setNewAdmin in UserController used");
        userService.setUserAdmin(userID);
        return ResponseEntity.status(201).body(new ResponseAPI("User set to Admin",201));
    }
    @PutMapping("/admin/removeadmin/{userID}")
    public ResponseEntity<ResponseAPI> removeAdmin(@PathVariable Integer userID){
        logger.info("method removeAdmin in UserController used");
        userService.removeAdminRole(userID);
        return ResponseEntity.status(201).body(new ResponseAPI("Admin is set to User",201));
    }
    @PutMapping("/userrecipe/addallergies/{userID}/{allergy}")
    public ResponseEntity<ResponseAPI> addAllergy(@PathVariable Integer userID,@PathVariable String allergy){
        logger.info("method addAllergy in UserController used");
        userService.addAllergies(userID,allergy);
        return ResponseEntity.status(201).body(new ResponseAPI("New Allergy added",201));
    }
    @GetMapping("/userrecipe/getuserallergies/{userID}")
    public ResponseEntity<List<Allergies>> getAllAllergies(@PathVariable Integer userID){
        logger.info("method getAllAllergies in UserController used");

        return ResponseEntity.status(200).body(userService.getUserAllergies(userID));
    }
    @PutMapping("/userrecipe/removeallergy/{userID}/{allergy}")
        public ResponseEntity<ResponseAPI> removeAllergies(@PathVariable Integer userID,@PathVariable String allergy){
        logger.info("method removeAllergies in UserController used");
        userService.removeAllergies(userID,allergy);
        return ResponseEntity.status(200).body(new ResponseAPI("Allergy deleted",200));
    }
    @PutMapping("/userrecipe/addcuisine/{userID}/{cuisine}")
    public ResponseEntity<ResponseAPI> addFavCuisine(@PathVariable Integer userID,@PathVariable String cuisine){
        logger.info("method addFavCuisine in UserController used");
        userService.addFavCuisine(userID,cuisine);
        return ResponseEntity.status(200).body(new ResponseAPI("Cuisine was added to favorite list",200));
    }
    @PutMapping("/userrecipe/deletefavcuisine/{userID}/{cuisine}")
    public ResponseEntity<ResponseAPI> deleteFavCuisine(@PathVariable Integer userID,@PathVariable String cuisine){
        logger.info("method deleteFavCuisine in UserController used");
        userService.deleteFavCuisine(userID,cuisine);
        return ResponseEntity.status(200).body(new ResponseAPI("Cuisine deleted from the list",200));
    }

}
