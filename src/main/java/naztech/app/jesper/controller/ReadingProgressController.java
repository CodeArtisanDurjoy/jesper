package naztech.app.jesper.controller;/*
 * ==============================================================
 * @Project: jesper
 * File: ReadingProgressController
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
import naztech.app.jesper.dto.ReadingProgressDTO;
import naztech.app.jesper.service.ReadingProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading-progress")
@Tag(name = "Reading Progress", description = "Reading Progress Management APIs")
public class ReadingProgressController {
    @Autowired
    private ReadingProgressService readingProgressService;

    @PostMapping
    @Operation(summary = "Create a new reading progress record", description = "Creates a new reading progress record in the system")
    public ResponseEntity<ReadingProgressDTO> createProgress(
            @Valid @RequestBody ReadingProgressDTO readingProgressDTO
    ) {
        ReadingProgressDTO createdProgress = readingProgressService.createProgress(readingProgressDTO);
        return new ResponseEntity<>(createdProgress, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get reading progress by ID", description = "Retrieves reading progress by its unique identifier")
    public ResponseEntity<ReadingProgressDTO> getProgressById(
            @PathVariable Long id
    ) {
        ReadingProgressDTO readingProgressDTO = readingProgressService.getProgressById(id);
        return ResponseEntity.ok(readingProgressDTO);
    }

    @GetMapping
    @Operation(summary = "Get all reading progress records", description = "Retrieves a list of all reading progress records")
    public ResponseEntity<List<ReadingProgressDTO>> getAllProgress() {
        List<ReadingProgressDTO> progressList = readingProgressService.getAllProgress();
        return ResponseEntity.ok(progressList);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update reading progress", description = "Updates an existing reading progress record")
    public ResponseEntity<ReadingProgressDTO> updateProgress(
            @PathVariable Long id,
            @Valid @RequestBody ReadingProgressDTO readingProgressDTO
    ) {
        ReadingProgressDTO updatedProgress = readingProgressService.updateProgress(id, readingProgressDTO);
        return ResponseEntity.ok(updatedProgress);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete reading progress", description = "Deletes a reading progress record by its ID")
    public ResponseEntity<Void> deleteProgress(
            @PathVariable Long id
    ) {
        readingProgressService.deleteProgress(id);
        return ResponseEntity.noContent().build();
    }
}
