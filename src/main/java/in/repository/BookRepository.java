package in.repository;

import java.awt.print.Book;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, String> {
	Optional<Book> findByIsbn(String isbn);
}
