package naztech.app.jesper.controller;/*
 * ==============================================================
 * @Project: jesper
 * File: BookController
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import naztech.app.jesper.dto.BookDTO;
import naztech.app.jesper.service.BookService;
import naztech.app.jesper.service.impl.FileStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book", description = "Book Management APIs")
public class BookController {

    private final BookService bookService;
    private final FileStorageService fileStorageService;


    public BookController(BookService bookService, FileStorageService fileStorageService) {
        this.bookService = bookService;
        this.fileStorageService = fileStorageService;
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Create a new book", description = "Creates a new book in the system")
    public ResponseEntity<BookDTO> createBook(
            @RequestPart("bookData") String bookDataJson,
            @RequestPart(value = "coverImage", required = false) MultipartFile coverImage
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BookDTO bookDTO = mapper.readValue(bookDataJson, BookDTO.class);

        if (coverImage != null && !coverImage.isEmpty()) {
            String fileName = fileStorageService.storeFile(coverImage);
            bookDTO.setCoverImage(fileName);
        }

        BookDTO createdBook = bookService.createBook(bookDTO);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID", description = "Retrieves a book by its unique identifier")
    public ResponseEntity<BookDTO> getBookById(
            @PathVariable Long id
    ) {
        BookDTO bookDTO = bookService.getBookById( id);
        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping
    @Operation(summary = "Get all books", description = "Retrieves a list of all books")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }



    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Update book", description = "Updates an existing book")
    public ResponseEntity<BookDTO> updateBook(
            @PathVariable Long id,
            @RequestPart("book") @Valid String bookDataJson,
            @RequestPart(value = "coverImage", required = false) MultipartFile coverImage
    ) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BookDTO bookDTO = mapper.readValue(bookDataJson, BookDTO.class);

            if (coverImage != null && !coverImage.isEmpty()) {
                String fileName = fileStorageService.storeFile(coverImage);
                bookDTO.setCoverImage(fileName);
            }

            BookDTO updatedBook = bookService.updateBook(id, bookDTO);
            return ResponseEntity.ok(updatedBook);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to update book", e);
        }
    }



    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book", description = "Deletes a book by its ID")
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long id
    ) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
