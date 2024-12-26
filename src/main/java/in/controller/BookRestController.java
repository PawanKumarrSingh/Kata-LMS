package in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.model.BookEntity;
import in.service.BookService;

public class BookRestController {
	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity book) {
		return ResponseEntity.ok(bookService.addBook(book));
	}
	
}
