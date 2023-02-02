package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Authority;
import com.SistemZaPracenjeLokalnihDogadjaja.services.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorityController {

    @Autowired
    private final AuthorityService authorityService;

    public List<Authority> findAllAuthority() {
        return authorityService.findAllAuthority();
    }
}
