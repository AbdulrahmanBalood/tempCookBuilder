package com.example.cookbuilder.Repository;

import com.example.cookbuilder.Model.Allergies;
import com.example.cookbuilder.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AllergiesRepository extends JpaRepository<Allergies,Integer> {
    Set<Allergies> findAllByUser(MyUser user);
}
