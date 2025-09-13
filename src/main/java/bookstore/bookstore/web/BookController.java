package bookstore.bookstore.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@Controller
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

      @RequestMapping("books")
    public String showBooks( Book book, Model model) {
        model.addAttribute("repo", repository.findAll());
        return "/booklist";
    }  

    @RequestMapping("add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "/addbook";
    }

    @PostMapping("save")
    public String save(Book book){
        repository.save(book);
       return "redirect:/books";
    }

    @GetMapping("/delete/{id}") 
    public String deleteBook(@PathVariable("id") Long bookid, Model model) {
        repository.deleteById(bookid);
        return "redirect:../books";
    }

    @GetMapping("/edit/{id}") 
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("edit", repository.findById(id));
        return "/editbook";
    }

        @PostMapping("saveEdit")
    public String saveEdit(@ModelAttribute("edit") Book book, Model model){
        repository.save(book);
       return "redirect:/books";
    }


}
