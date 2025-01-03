package in.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, String> {
	Optional<BookEntity> findByIsbn(String isbn);
}
