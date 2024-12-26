package in.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/returnbook/{bookTitle}")
	public ResponseEntity<?> returnBook(@PathVariable String bookTitle) {
	    Optional<BookEntity> book = Optional.of(bookService.returnBook(bookTitle));
	    if (book.isEmpty()) {
	        new ResponseEntity<String>("Please Enter correct book ID.",HttpStatus.BAD_REQUEST);
	    }

	    BookEntity bookEntity = book.get();
	    bookEntity.setAvailable(true); // Mark as returned
	    bookService.addBook(bookEntity);
	    return new ResponseEntity<BookEntity>(bookEntity, HttpStatus.OK);
	}

}
