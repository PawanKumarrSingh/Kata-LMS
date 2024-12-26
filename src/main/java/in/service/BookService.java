package in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.model.BookEntity;
import in.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public BookEntity addBook(BookEntity book) {
		book.setAvailable(true);
		return bookRepository.save(book);
	}

	public BookEntity borrowBook(String isbn) {
		BookEntity book = bookRepository.findByIsbn(isbn).orElseThrow(() -> new RuntimeException("Book not found"));
		if (!book.isAvailable()) {
			throw new RuntimeException("Book is not available for borrowing");
		}
		book.setAvailable(false);
		return bookRepository.save(book);
	}

	public BookEntity returnBook(String isbn) {
		BookEntity book = bookRepository.findByIsbn(isbn).orElseThrow(() -> new RuntimeException("Book not found"));
		book.setAvailable(true);
		return bookRepository.save(book);
	}

	public List<BookEntity> viewAvailableBooks() {
		return bookRepository.findAll();
	}
}
