package in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.model.BookEntity;
import in.repository.BookRepository;

@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;

    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }
}
