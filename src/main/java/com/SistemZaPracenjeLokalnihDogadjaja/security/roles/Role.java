package com.SistemZaPracenjeLokalnihDogadjaja.security.roles;

import com.SistemZaPracenjeLokalnihDogadjaja.security.authority.Authority;
import lombok.Getter;

import java.util.List;
@Getter
public enum Role {
    ROLE_ADMIN(List.of(Authority.SAVE,Authority.DELETE,Authority.EDIT,Authority.READ)),
    ROLE_USER(List.of(Authority.READ));

   private final List<Authority> authorities;

   Role(List<Authority>authorities){
       this.authorities=authorities;
   }


}
