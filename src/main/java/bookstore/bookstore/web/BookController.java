package bookstore.bookstore.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstore.bookstore.domain.BookRepository;


@Controller
public class BookController {

    private BookRepository repository;
    public BookController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/books")
    public String showBooks(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

}
