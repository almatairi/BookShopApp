package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.service.BookService;
import mk.finki.ukim.wp.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookStoreService bookStores;

    public BookController(BookService bookService, BookStoreService bookStores) {
        this.bookService = bookService;
        this.bookStores = bookStores;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "listBooks";
    }

    @PostMapping("/books/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long bookStoreId) {
         this.bookService.saveBook(title, isbn, genre, year, bookStoreId);
         return "redirect:/listBooks";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model){
        // Retrieve the book by id and add it to the model
        Book book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book id"));
        model.addAttribute("book", book);

        // Add the list of bookstores to the model (assuming you have a method to retrieve them)
        model.addAttribute("bookstores", bookStores);

        return "editBook"; // Assuming you have an editBook.html Thymeleaf template
    }

    @PostMapping("/books/edit/{id}")
    public String editBook(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long bookStoreId) {
        // Call the service method to edit the book
        bookService.editBook(id, title, isbn, genre, year, bookStoreId);

        return "redirect:/books"; // Redirect to the page displaying all books
    }


    @DeleteMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        this.bookService.deleteById(id);
        return "redirect:/books";
    }
}
