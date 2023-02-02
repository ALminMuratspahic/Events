package com.SistemZaPracenjeLokalnihDogadjaja.services;

import com.SistemZaPracenjeLokalnihDogadjaja.model.User;
import com.SistemZaPracenjeLokalnihDogadjaja.repository.UserRepository;
import com.SistemZaPracenjeLokalnihDogadjaja.security.userSecurity.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsServices implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByEmail(email);
        return user
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username with name: " + email + " not found"));


    }
}
