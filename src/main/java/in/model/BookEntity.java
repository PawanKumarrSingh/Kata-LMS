package in.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
	@Id
	private String isbn; // Unique identifier
	private String title;
	private String author;
	private int publicationYear;
	private boolean available;
}
