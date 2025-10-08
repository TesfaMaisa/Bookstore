package bookstore.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@DataJpaTest
public class RepositoryTests {

    @Autowired
    private BookRepository bookRepository;
    private Book book;

    @Test
    public void findByAuthor() throws Exception {
        List<Book> author = bookRepository.findByAuthor("James");
        List<Book> year = bookRepository.findByPublicationYear(2018);
        assertThat(author).hasSize(1);
        assertThat(author.get(0).getAuthor()).isEqualTo("James");
        assertThat(year.get(0).getPublicationYear()).isEqualTo(2018);
    }

}
