package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {
	private BookService service;

	public BookController(BookService service) {
		this.service = service;
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		return ResponseEntity.ok(this.service.getBooks());
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		Book b = this.service.getBookById(id);
		if (b == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(b);
	}

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
		return ResponseEntity.status(201).body(this.service.addBook(book));
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
		Book b = this.service.getBookById(id);
		if (b == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.service.updateBookById(id, book));
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		if (!this.service.removeBookById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

}
