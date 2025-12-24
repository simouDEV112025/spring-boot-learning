package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;

@Service
public class BookService {

	private BookRepo repo;

	public BookService(BookRepo repo) {
		this.repo = repo;
	}

	public List<Book> getBooks() {
		return repo.findAll();
	}

	public Book getBookById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Book addBook(Book book) {
		return repo.save(book);
	}

	public boolean removeBookById(Long id) {
		if (this.repo.existsById(id)) {
			this.repo.deleteById(id);
			return true;
		}
		return false;
	}

	public Book updateBookById(Long id, Book book) {
		Book b = getBookById(id);
		b.setAuthor(book.getAuthor());
		b.setTitle(book.getTitle());
		b.setPrice(book.getPrice());
		return repo.save(b);
	}

	public void removeAll() {
		this.repo.deleteAll();
	}

}
