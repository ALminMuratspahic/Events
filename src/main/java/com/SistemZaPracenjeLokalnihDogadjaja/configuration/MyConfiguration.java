package com.SistemZaPracenjeLokalnihDogadjaja.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/css/**", "/js/**", "/images/**", "/font-awesome/**","/events/**",
                            "/users/save", "/users/login","/users/register-user").permitAll();
                    auth.requestMatchers("/delete-user/**").hasAuthority("admin");
                    auth.anyRequest().authenticated();
                })
                .formLogin(form -> {
                    form.loginPage("/users/login")
                            .usernameParameter("email")
                            .defaultSuccessUrl("/events", true)
                            .permitAll();
                })
                .httpBasic()
                .and()
                .logout()
                .logoutSuccessUrl("/events")
                .and()
                .csrf().disable()

                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
