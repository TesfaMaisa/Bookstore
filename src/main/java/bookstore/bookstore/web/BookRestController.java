package bookstore.bookstore.web;

import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class BookRestController {

     private final BookRepository bookRepository;

     public BookRestController(BookRepository bookRepository){
     this.bookRepository = bookRepository;
     }


    @GetMapping("/books")
    public List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

       @GetMapping("/books/{id}")
    public Optional<Book> findStudentRest(@PathVariable("id") long id) {
        return  bookRepository.findById(id);
    }
    
    @PostMapping("/books")
    public Book saveNewBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("books/{id}")
    public Book editBook (@RequestBody Book editedBook, @PathVariable Long id){
    editedBook.setId(id);
    return bookRepository.save(editedBook);
    }

    @DeleteMapping("books/{id}")
    public List<Book> deleteBook (@PathVariable Long id){
         bookRepository.deleteById(id);
         return (List<Book>)  bookRepository.findAll();
    }
}
  
    


