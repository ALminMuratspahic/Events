package com.SistemZaPracenjeLokalnihDogadjaja.security.authority;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Authority;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@ToString
public class MyAuthority implements GrantedAuthority {
    private Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
