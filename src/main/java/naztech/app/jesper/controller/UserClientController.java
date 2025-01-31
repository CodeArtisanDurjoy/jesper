package naztech.app.jesper.controller;/*
 * ==============================================================
 * @Project: jesper
 * File: UserClientController
 * Created: 1/16/2025
 * Author: DURJOY ACHARJYA
 * Email: da-durjoy@outlook.com
 * ==============================================================
 *
 * Copyright (c) 2025, naztech.inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * naztech.inc. You shall not disclose such confidential information
 * and shall use it only in accordance with the terms of the license
 * agreement you entered into with naztech.inc.
 *
 * ==============================================================
 */

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import naztech.app.jesper.dto.UserClientDTO;
import naztech.app.jesper.service.UserClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Client", description = "User Client Management APIs")
public class UserClientController {

    private final UserClientService userClientService;

    public UserClientController(UserClientService userClientService) {
        this.userClientService = userClientService;
    }

    @PostMapping
    @Operation(summary = "Create a new user client", description = "Creates a new user client in the system")
    public ResponseEntity<UserClientDTO> createUser(
            @Valid @RequestBody UserClientDTO userClientDTO
    ) {
        UserClientDTO createdUser = userClientService.createUser(userClientDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user client by ID", description = "Retrieves a user client by their unique identifier")
    public ResponseEntity<UserClientDTO> getUserById(
            @PathVariable Long id
    ) {
        UserClientDTO userClientDTO = userClientService.getUserById(id);
        return ResponseEntity.ok(userClientDTO);
    }

    @GetMapping
    @Operation(summary = "Get all user clients", description = "Retrieves a list of all user clients")
    public ResponseEntity<List<UserClientDTO>> getAllUsers() {
        List<UserClientDTO> users = userClientService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user client", description = "Updates an existing user client")
    public ResponseEntity<UserClientDTO> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserClientDTO userClientDTO
    ) {
        UserClientDTO updatedUser = userClientService.updateUser(id, userClientDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user client", description = "Deletes a user client by their ID")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id
    ) {
        userClientService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
