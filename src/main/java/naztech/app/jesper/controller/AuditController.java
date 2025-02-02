package naztech.app.jesper.controller;/*
 * ==============================================================
 * @Project: jesper
 * File: AuditController
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
import naztech.app.jesper.dto.AuditDTO;
import naztech.app.jesper.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audits")
@Tag(name = "Audit", description = "Audit Management APIs")
public class AuditController {
    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

//    @PostMapping
//    @Operation(summary = "Create a new audit record", description = "Creates a new audit record in the system")
//    public ResponseEntity<AuditDTO> createAudit(
//            @Valid @RequestBody AuditDTO auditDTO
//    ) {
//        AuditDTO createdAudit = auditService.createAudit(auditDTO);
//        return new ResponseEntity<>(createdAudit, HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    @Operation(summary = "Get audit record by ID", description = "Retrieves an audit record by its unique identifier")
    public ResponseEntity<AuditDTO> getAuditById(
            @PathVariable Long id
    ) {
        AuditDTO auditDTO = auditService.getAuditById(id);
        return ResponseEntity.ok(auditDTO);
    }

    @GetMapping
    @Operation(summary = "Get all audit records", description = "Retrieves a list of all audit records")
    public ResponseEntity<List<AuditDTO>> getAllAudits() {
        List<AuditDTO> audits = auditService.getAllAudits();
        return ResponseEntity.ok(audits);
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete audit record", description = "Deletes an audit record by its ID")
//    public ResponseEntity<Void> deleteAudit(
//            @PathVariable Long id
//    ) {
//        auditService.deleteAudit(id);
//        return ResponseEntity.noContent().build();
//    }
}
