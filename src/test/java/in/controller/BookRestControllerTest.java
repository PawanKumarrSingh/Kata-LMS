package in.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import in.model.BookEntity;
import in.repository.BookRepository;
import in.service.BookService;

@ActiveProfiles("test")
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

	@Test
	public void testReturnBook() {
		book.setAvailable(true);
		when(bookRepository.findByIsbn("1234567890")).thenReturn(Optional.of(book));
		BookEntity returnedBook = bookService.returnBook("1234567890");
		assertTrue(returnedBook.isAvailable());
	}

	@Test
	public void testViewAvailableBooks() {
		book.setAvailable(true);
		when(bookRepository.findAll()).thenReturn(Collections.singletonList(book));
		assertEquals(1, bookService.viewAvailableBooks().size());
	}
}