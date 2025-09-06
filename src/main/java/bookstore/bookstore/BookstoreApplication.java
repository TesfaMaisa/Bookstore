package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
		private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		Book book1 = new Book("The Let Them Theory","Mel Robbins",2024,"978‑1401971366",11);
		Book book2 = new Book("Sunrise on the Reaping","Suzanne Collins",2025,"978‑1‑5461‑7146‑1",33);
		Book book3 = new Book("Atomic Habits","James Clear",2018,"978‑0‑735‑21129‑2",44);
		// Your code...add some demo data to db
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
	};
}

}
