package naztech.app.jesper.config;

import lombok.Getter;
import naztech.app.jesper.model.UserAdmin;
import naztech.app.jesper.model.UserClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/*
 * ==============================================================
 * @Project: jesper
 * File: CustomUserDetails
 * Created: 2/2/25
 * Author: DURJOY ACHARJYA
 * Email: da-durjoy@outlook.com
 * ==============================================================
 *
 * Copyright (c) 2025, system error.inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * system error.inc. You shall not disclose such confidential information
 * and shall use it only in accordance with the terms of the license
 * agreement you entered into with naztech.inc.
 *
 * ==============================================================
 */

public class CustomUserDetails  implements UserDetails {
    private String username;
    private String password;
    @Getter
    private String publicId;
    private Boolean isActive;
    private Collection<? extends GrantedAuthority> authorities;

    public static CustomUserDetails fromUserClient(UserClient userClient) {
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.username = userClient.getUsername();
        // Make sure passwordHash is BCrypt encoded
        userDetails.password = userClient.getPasswordHash();
        userDetails.publicId = userClient.getPublicId();
        userDetails.isActive = userClient.getIsActive();
        userDetails.authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
        return userDetails;
    }

    public static CustomUserDetails fromUserAdmin(UserAdmin userAdmin) {
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.username = userAdmin.getUsername();
        // Make sure passwordHash is BCrypt encoded
        userDetails.password = userAdmin.getPasswordHash();
        userDetails.publicId = userAdmin.getPublicId();
        userDetails.isActive = userAdmin.getIsActive();
        userDetails.authorities = List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return isActive;
    }
}
