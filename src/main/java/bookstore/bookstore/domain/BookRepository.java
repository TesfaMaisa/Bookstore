package bookstore.bookstore.domain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {
   List<Book> findByTitle(String title);
   List<Book> findByPublicationYear(int publicationYear);;
   List<Book> findByAuthor(String author);

   

}
