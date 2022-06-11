package com.example.cookbuilder.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.*;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @Column(unique = true)
    @Email(message = "Email must be in an email format")
    @NotEmpty(message = "email cannot be empty")
    private String email;
    @NotEmpty(message = "password cannot be empty")
    private String password;
    @Pattern(regexp = "(USER|ADMIN)",message = "user has to be ADMIN or USER")
    @NotEmpty(message = "role cannot be empty")
    private String role;

        @OneToMany(mappedBy = "user")
    private List<FavoriteRecipe> favoriteRecipes;
        @OneToMany(mappedBy = "user")
    private List<Allergies> allergies;
        @OneToMany(mappedBy = "user")
    private List<FavoriteCuisine>favoriteCuisines;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
