package in.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import in.model.BookEntity;
import in.repository.BookRepository;
import in.service.BookService;

public class BookRestControllerTest {
	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	private BookEntity book;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		book = new BookEntity("1234567890", "Test Book", "Author", 2023, true);
	}

	@Test
	public void testAddBook() {
		when(bookRepository.save(book)).thenReturn(book);
		BookEntity addedBook = bookService.addBook(book);

		assertEquals(book.getIsbn(), addedBook.getIsbn());
	}
	
	@Test
    public void testBorrowBook() {
        when(bookRepository.findByIsbn("1234567890")).thenReturn(Optional.of(book));
        BookEntity borrowedBook = bookService.borrowBook("1234567890");
        assertFalse(borrowedBook.isAvailable());
    }
}