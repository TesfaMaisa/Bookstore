package bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.AppUser;
import bookstore.bookstore.domain.AppUserRepository;
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
	public CommandLineRunner demo(BookRepository repository, CategoryRepository Crepository, AppUserRepository userRepository) {
	return (args) -> {

			Category category1 = new Category( "Kauhu");
			Category category2 = new Category("Romantiikka");
			Category category3 = new Category("Komedia");
			Category category4 = new Category(null);
			
			Crepository.save(category4);
			Crepository.save(category1);
			Crepository.save(category2);
			Crepository.save(category3);
			

		Book book1 = new Book("The Let Them Theory","Mel Robbins",2024,"978‑14-019-7136-6",11, category1);
		Book book2 = new Book("Sunrise on the Reaping","Suzanne Collins",2025,"978‑154-61‑7146‑1",33,category2);
		Book book3 = new Book("Atomic Habits","James",2018,"978‑0735‑21-129‑2",44,category3);
		// Your code...add some demo data to db
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);

		AppUser user1 = new AppUser("Abus", "$2a$10$3nJrqaGwEA7wE6ycSUiTMunJ8uVfrpEL58fc52beyOuXHeSePolyC", "ADMIN");
		AppUser user2 = new AppUser("Nugus", "$2a$10$X5uyOh6r5mc3V3BqtDRI7eeEAwyeQtXeanIUAku0gWRP2VmoHFZIq", "USER");

		userRepository.save(user1);
		userRepository.save(user2);

	};
}

}
