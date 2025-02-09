package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book A = new Book("Metamorphoses", "Ovid", 8, "978-3-16-148410-0", 25.50);
			Book B = new Book("The Aeneid", "Virgil", 19, "978-3-16-148410-0", 39.99);
			Book C = new Book("Meditations", "Marcus Aurelius", 180, "978-1-86197-876-9", 19.99);

			repository.save(A);
			repository.save(B);
			repository.save(C);
		};
	}

}
