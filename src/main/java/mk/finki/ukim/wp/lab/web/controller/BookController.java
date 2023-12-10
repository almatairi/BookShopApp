package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.service.BookService;
import mk.finki.ukim.wp.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookStoreService bookStoresService;

    public BookController(BookService bookService, BookStoreService bookStores) {
        this.bookService = bookService;
        this.bookStoresService = bookStores;
    }

    @GetMapping()
    public String getBooksPage(@RequestParam(required = false) String error, Model model){

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Book> books = bookService.listBooks();
        List<BookStore> bookStores = bookStoresService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("bookStores", bookStores);
        return "listBooks";

    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long bookStoreId) {
         this.bookService.saveBook(title, isbn, genre, year, bookStoreId);
         return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
   public String getEditBookForm(@PathVariable String id, Model model){
        Book book = bookService.findBookByIsbn(id).orElse(null);
        List<BookStore> bookStores = bookStoresService.findAll();
        model.addAttribute("book", book);
        model.addAttribute("bookStores", bookStores);
        return "add-book";
    }

    @PostMapping("/books/edit/{id}")
    public String editBook(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long bookStoreId) {
        bookService.editBook(id, title, isbn, genre, year, bookStoreId);

        return "redirect:/books";
    }


    @GetMapping("/add-form")
    public String getAddBookPage(Book book){
       if(book.getAuthors().isEmpty()){
           return "redirect:/add-form";
       }
       else{

       }
        List<Book> books = bookService.listBooks();
        List<BookStore> bookStores = bookStoresService.findAll();

        return "add-form";
    }
    @DeleteMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        this.bookService.deleteById(id);
        return "redirect:/books";
    }
}
