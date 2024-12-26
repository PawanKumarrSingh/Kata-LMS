package in.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.awt.print.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RestControllerTest {
	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private LibraryService libraryService;

	private Book book;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		book = new Book("1234567890", "Test Book", "Author", 2023);
	}

	@Test
	public void testAddBook() {
		when(bookRepository.save(any(Book.class))).thenReturn(book);
		Book addedBook = libraryService.addBook(book);
		assertEquals(book.getIsbn(), addedBook.getIsbn());
	}
}