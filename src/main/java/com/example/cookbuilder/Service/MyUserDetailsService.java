package com.example.cookbuilder.Service;

import com.example.cookbuilder.Model.MyUser;
import com.example.cookbuilder.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<MyUser> user= userRepository.findMyUserByUsername(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("Username not found");
        }

        return user.get();
    }
}
