package naztech.app.jesper.controller;/*
 * ==============================================================
 * @Project: jesper
 * File: UserAdminController
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
import naztech.app.jesper.dto.UserAdminDTO;
import naztech.app.jesper.service.UserAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@Tag(name = "User Admin", description = "User Admin Management APIs")
public class UserAdminController {

    private final UserAdminService userAdminService;

    public UserAdminController(UserAdminService userAdminService) {
        this.userAdminService = userAdminService;
    }

    @PostMapping
    @Operation(summary = "Create a new admin user", description = "Creates a new admin user in the system")
    public ResponseEntity<UserAdminDTO> createAdmin(
            @Valid @RequestBody UserAdminDTO userAdminDTO
    ) {
        UserAdminDTO createdAdmin = userAdminService.createAdmin(userAdminDTO);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get admin user by ID", description = "Retrieves an admin user by their unique identifier")
    public ResponseEntity<UserAdminDTO> getAdminById(
            @PathVariable Long id
    ) {
        UserAdminDTO userAdminDTO = userAdminService.getAdminById(id);
        return ResponseEntity.ok(userAdminDTO);
    }

    @GetMapping
    @Operation(summary = "Get all admin users", description = "Retrieves a list of all admin users")
    public ResponseEntity<List<UserAdminDTO>> getAllAdmins() {
        List<UserAdminDTO> admins = userAdminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update admin user", description = "Updates an existing admin user")
    public ResponseEntity<UserAdminDTO> updateAdmin(
            @PathVariable Long id,
            @Valid @RequestBody UserAdminDTO userAdminDTO
    ) {
        UserAdminDTO updatedAdmin = userAdminService.updateAdmin(id, userAdminDTO);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete admin user", description = "Deletes an admin user by their ID")
    public ResponseEntity<Void> deleteAdmin(
            @PathVariable Long id
    ) {
        userAdminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}