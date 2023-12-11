package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.service.BookService;
import mk.finki.ukim.wp.lab.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;

    @Autowired
    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("books", bookService.findAll());
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "listBooks";
    }
    @PostMapping("/add")
    public String saveBook(@RequestParam String title, @RequestParam String isbn,
                           @RequestParam String genre, @RequestParam int year,
                           @RequestParam Long bookStoreId, RedirectAttributes redirectAttributes) {

        Optional<Book> bookStore = bookStoreService.findById(bookStoreId);
        if (bookStore != null) {
            Book book = new Book();
            bookService.save(book);
            return "redirect:/books";


        } else {
            redirectAttributes.addAttribute("error", "Invalid bookstore ID.");

            return "redirect:/books/add-form";
        }

    }
    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId, @RequestParam String title,
                           @RequestParam String isbn, @RequestParam String genre,
                           @RequestParam int year, @RequestParam Long bookStoreId,
                           RedirectAttributes redirectAttributes) {

        Optional<Book> bookStore = bookStoreService.findById(bookStoreId);
        Book book = bookService.findById(bookId);
        if (book != null && bookStore != null) {
            book.setTitle(title);
            book.setIsbn(isbn);
            book.setGenre(genre);
            book.setYear(year);
           // book.setBookStore(bookStore);
            bookService.save(book);
            return "redirect:/books";
        } else {
            redirectAttributes.addAttribute("error", "Invalid book or bookstore ID.");
            return "redirect:/books/edit-form/" + bookId;
        }

    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        bookService.delete(id);
        return "redirect:/books";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        if (book == null) {
            redirectAttributes.addFlashAttribute("error", "The book with ID " + id + " does not exist.");
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        model.addAttribute("bookStores", bookStoreService.findAll());
        model.addAttribute("actionUrl", "/books/edit/" + id);
        return "add-book";
    }

    @GetMapping("/add-form")
    public String getAddBookPage(Model model) {
        Optional<Book> defaultBookStore = bookStoreService.findById(1L);
        model.addAttribute("book");
        model.addAttribute("bookStores", bookStoreService.findAll());
        model.addAttribute("actionUrl", "/books/add");
        return "add-book";
    }
}
