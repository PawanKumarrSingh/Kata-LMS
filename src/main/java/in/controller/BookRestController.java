package in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.model.BookEntity;
import in.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity book) {
		return ResponseEntity.ok(bookService.addBook(book));
	}
	
	@PostMapping("/{isbn}/borrow")
    public ResponseEntity<BookEntity> borrowBook(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.borrowBook(isbn));
    }
}
