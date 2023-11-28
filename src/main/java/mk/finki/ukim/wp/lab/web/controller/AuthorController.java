package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final BookService bookService;

    public AuthorController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addAuthorToBook")
    public String addAuthorToBook(@RequestParam Long authorId,
                                  @RequestParam String isbn,
                                  Model model){
        bookService.addAuthorToBook(authorId, isbn);
        model.addAttribute("authorId", "isbn");
        return "redirect:/books";
    }
}
