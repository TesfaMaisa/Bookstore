package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository Crepository) {
	return (args) -> {

			Category category1 = new Category( "IT");
			Category category2 = new Category("BT");
			Category category3 = new Category("KP");
			Category category4 = new Category(null);
			
			Crepository.save(category4);
			Crepository.save(category1);
			Crepository.save(category2);
			Crepository.save(category3);
			

		Book book1 = new Book("The Let Them Theory","Mel Robbins",2024,"978‑14-019-7136-6",11, category1);
		Book book2 = new Book("Sunrise on the Reaping","Suzanne Collins",2025,"978‑154-61‑7146‑1",33,category2);
		Book book3 = new Book("Atomic Habits","James Clear",2018,"978‑0735‑21-129‑2",44,category3);
		// Your code...add some demo data to db
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
	};
}

}
