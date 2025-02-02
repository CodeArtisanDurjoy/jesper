package naztech.app.jesper.service;

import jakarta.transaction.Transactional;
import naztech.app.jesper.model.UserClient;
import naztech.app.jesper.repo.UserClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/*
 * ==============================================================
 * @Project: jesper
 * File: UserService
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
public class UserService {
    private final UserClientRepository userClientRepository;

    public UserService(UserClientRepository userClientRepository) {
        this.userClientRepository = userClientRepository;
    }

    @Transactional
    public void updateMachineIp(String username, String machineIp) {
        UserClient user = userClientRepository.findByUsername(username);
        if (user != null) {
            user.setMachineIp(machineIp);
            user.setUpdatedAt(LocalDateTime.now());
            userClientRepository.save(user);
        }
    }

    public boolean existsByUsername(String username) {
        return userClientRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userClientRepository.existsByEmail(email);
    }

    public UserClient createUser(UserClient userClient) {
        return userClientRepository.save(userClient);
    }

}
