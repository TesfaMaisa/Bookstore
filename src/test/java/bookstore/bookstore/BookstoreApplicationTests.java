package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.web.BookController;
import bookstore.bookstore.web.BookRestController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	private BookRestController restController;

	@Test
	void contextLoads() {
	}

	@Test
	public void bookControllerTest() throws Exception{	
	assertThat(bookController).isNotNull();
	} 

	@Test
	public void restControllerTest() throws Exception{
		assertThat(restController).isNotNull();
	}

}
