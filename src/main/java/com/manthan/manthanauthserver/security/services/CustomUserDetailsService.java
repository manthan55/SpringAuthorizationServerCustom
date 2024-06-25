package com.manthan.manthanauthserver.security.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.manthan.manthanauthserver.models.User;
import com.manthan.manthanauthserver.security.models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@JsonDeserialize
public class CustomUserDetailsService implements UserDetailsService {

    private Map<String, User> users;

    public CustomUserDetailsService() {
        this.users = new HashMap<>();

        User u1 = new User();
        u1.setId(1L);
        u1.setPhone("9999999999");
        u1.setOtp("{noop}1234");

        this.users.put(u1.getPhone(), u1);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.users.get(username);
        return new CustomUserDetails(u);
    }
}
