package com.SistemZaPracenjeLokalnihDogadjaja.security.authority;

import lombok.Getter;

@Getter
public enum Authority {

    SAVE("save"),
    DELETE("delete"),
    READ("read"),
    EDIT("edit");

    public final String permission;

    Authority(String permission){
        this.permission=permission;
    }

}
