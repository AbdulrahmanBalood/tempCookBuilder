package com.example.cookbuilder.Config;

import com.example.cookbuilder.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/v1/user/register").permitAll()
                .antMatchers("/api/v1/user/admin/**").hasAuthority("ADMIN")
                .antMatchers("/api/v1/user/userrecipe/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/api/v1/recipe/user/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/api/v1/recipe/recipes/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().logout().logoutUrl("/api/v1/user/logout").logoutSuccessUrl("/api/v1/user/logout/loggedout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().httpBasic();


    }
}
