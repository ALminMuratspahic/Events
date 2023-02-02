package com.SistemZaPracenjeLokalnihDogadjaja.services;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Authority;
import com.SistemZaPracenjeLokalnihDogadjaja.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;
    public List<Authority> findAllAuthority() {
        return authorityRepository.findAll();
    }

    public void saveAuthority(Authority authority) {
        authorityRepository.save(authority);
    }
}
