package com.manthan.manthanauthserver.security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.manthan.manthanauthserver.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

//@NoArgsConstructor
@JsonDeserialize
@Getter
@Setter
//This CustomUserDetails class will act like a User class for Spring Security.
public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Long userId;

    public CustomUserDetails() {

    }

    public CustomUserDetails(User user) {
        this.username = user.getPhone();
        this.password = user.getOtp();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.userId = user.getId();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getUserId() {
        return userId;
    }
}
