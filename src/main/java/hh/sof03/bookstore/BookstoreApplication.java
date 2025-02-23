package hh.sof03.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			//Insert Categories
            Category philosophy = new Category("Philosophy");
			Category poetry = new Category("Poetry");

            categoryRepository.save(philosophy);
            categoryRepository.save(poetry);

			
			// Inster books
			Book A = new Book("Metamorphoses", "Ovid", 8, "978-3-16-148410-0", 25.50, poetry);
			Book B = new Book("The Aeneid", "Virgil", 19, "978-3-16-148410-0", 39.99, poetry);
			Book C = new Book("Meditations", "Marcus Aurelius", 180, "978-1-86197-876-9", 19.99, philosophy);

			bookRepository.save(A);
			bookRepository.save(B);
			bookRepository.save(C);

			//Loggers
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("Categories saved:");
            for (Category category : categoryRepository.findAll()) {
                log.info(category.toString());
            }

		};
	}

}
