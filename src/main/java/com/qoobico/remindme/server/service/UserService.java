package com.qoobico.remindme.server.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class UserService implements UserDetailsService {

    public final User loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthority() {
            public String getAuthority() {
                return "APIClient";
            }
        });

        User user = new User("joequimby", "$2a$10$Ii6gash59T15dOIpACY3EuUsazCVvIW7PXm0XhhHljFY.zWRvGpe2", authorities);

        return user;
    }
}
