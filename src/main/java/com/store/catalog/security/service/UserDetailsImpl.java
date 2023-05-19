package com.store.catalog.security.service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.store.catalog.entity.Pengguna;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import  org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
public class UserDetailsImpl implements UserDetails{
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String roles;

    public UserDetailsImpl(
                           String username,
                           String email,
                           String password,
                           String roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public static UserDetailsImpl build(Pengguna pengguna) {
        return new UserDetailsImpl(
                pengguna.getEmail(),
                pengguna.getUsername(),
                pengguna.getPassword(),
                pengguna.getRoles());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (StringUtils.hasText(roles)) {
            String[] splits = roles.replaceAll(" ", "").split(",");
            for (String string : splits) {
                authorities.add(new SimpleGrantedAuthority(string));
            }
        }
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
