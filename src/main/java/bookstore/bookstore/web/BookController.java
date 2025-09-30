package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstore.bookstore.domain.AppUser;
import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.CategoryRepository;
import jakarta.validation.Valid;

@Controller
public class BookController {

    @Autowired
    private CategoryRepository Categoryrepo;

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("booklist")
    public String showBooks(Book book, Model model) {
        model.addAttribute("repo", repository.findAll());
        return "/booklist";
    }

    @RequestMapping("add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", Categoryrepo.findAll());
        return "/addbook";
    }

    @PostMapping("save")
    public String save(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", Categoryrepo.findAll());
            return "/addbook";
        }
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookid, Model model) {
        repository.deleteById(bookid);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("edit", repository.findById(id));
        model.addAttribute("categories", Categoryrepo.findAll());
        return "/editbook";
    }

    @PostMapping("saveEdit")
    public String saveEdit(@Valid @ModelAttribute("edit") Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", Categoryrepo.findAll());
            return "editbook";
        }
        repository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/login";
    }

}
