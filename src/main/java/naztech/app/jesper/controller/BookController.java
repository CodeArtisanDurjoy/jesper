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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import naztech.app.jesper.dto.BookDTO;
import naztech.app.jesper.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book", description = "Book Management APIs")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    @Operation(summary = "Create a new book", description = "Creates a new book in the system")
    public ResponseEntity<BookDTO> createBook(
            @Valid @RequestBody BookDTO bookDTO
    ) {
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

    @PutMapping("/{id}")
    @Operation(summary = "Update book", description = "Updates an existing book")
    public ResponseEntity<BookDTO> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookDTO bookDTO
    ) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
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
