package bookstore.bookstore.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;


@Controller
public class BookController {

    private BookRepository repository;
    public BookController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping("books")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("books")
    public String showBooks(@ModelAttribute Book book, Model model){
        model.addAttribute("repo", repository.findAll());
        model.addAttribute("books", book);
        return "booklist";
    }

}
