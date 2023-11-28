package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();
    Optional<Book> findBookByIsbn(String  isbn);
    Optional<Book> saveBook(String title, String isbn, String genre, int year, Long bookStoreId);

    void editBook(String title, String isbn, String genre, int year, Long bookId);

    void editBook(Long bookId, String title, String isbn, String genre, int year, Long id);

    void deleteById(Long id);

    Optional<Book> findById(Long id);
    void addAuthorToBook(Long authorId, String isbn);
}
