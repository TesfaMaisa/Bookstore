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
		Book book1 = new Book("sadad","adadad",1990,1919191,11);
		Book book2 = new Book("sfmksfmk","kamckam",1990,1919191,33);
		Book book3 = new Book("pscpslcp","öldöadö",1990,1919191,44);
		// Your code...add some demo data to db
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
	};
}

}
