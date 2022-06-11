package com.example.cookbuilder.Repository;

import com.example.cookbuilder.Model.Allergies;
import com.example.cookbuilder.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Integer> {
    MyUser getMyUserByEmail(String email);
    Optional<MyUser> findMyUserByUsername(String username);
}
