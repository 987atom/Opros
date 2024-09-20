package com.oprosWeb.web.models;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER, ADMIN, MANAGER;
    @Override
    public String getAuthority() {
        return name();
    }
}

//package com.oprosWeb.web.models;
//
//
//public enum RoleEnum {
//    USER, ADMIN, MANAGER;
////    @Override
//    public String getAuthority() {
//        return name();
//    }
//}
