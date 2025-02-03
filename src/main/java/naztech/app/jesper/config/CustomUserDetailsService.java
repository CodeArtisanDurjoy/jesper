package naztech.app.jesper.config;

import naztech.app.jesper.model.UserAdmin;
import naztech.app.jesper.model.UserClient;
import naztech.app.jesper.repo.UserAdminRepository;
import naztech.app.jesper.repo.UserClientRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * ==============================================================
 * @Project: jesper
 * File: CustomUserDetailsService
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

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserClientRepository userClientRepository;
    private final UserAdminRepository userAdminRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserClientRepository userClientRepository,
                                    UserAdminRepository userAdminRepository,
                                   @Lazy PasswordEncoder passwordEncoder) {
        this.userClientRepository = userClientRepository;
        this.userAdminRepository = userAdminRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // First check admin users
//        UserAdmin admin = userAdminRepository.findByUsername(username);
//        if (admin != null) {
//            return CustomUserDetails.fromUserAdmin(admin);
//        }
//
//        // Then check client users
//        UserClient client = userClientRepository.findByUsername(username);
//        if (client != null) {
//            return CustomUserDetails.fromUserClient(client);
//        }
//        throw new UsernameNotFoundException("User not found with username: " + username);
//    }
    // Add this helper method to encode passwords when creating/updating users

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // First check admin users
        UserAdmin admin = userAdminRepository.findByUsername(username);
        if (admin != null) {
            if (admin.getPasswordHash() == null || !admin.getPasswordHash().startsWith("$2a$")) {
                throw new UsernameNotFoundException("Invalid password hash for user: " + username);
            }
            return CustomUserDetails.fromUserAdmin(admin);
        }

        // Then check client users
        UserClient client = userClientRepository.findByUsername(username);
        if (client != null) {
            if (client.getPasswordHash() == null || !client.getPasswordHash().startsWith("$2a$")) {
                throw new UsernameNotFoundException("Invalid password hash for user: " + username);
            }
            return CustomUserDetails.fromUserClient(client);
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
