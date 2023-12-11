package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
   List<Book> listBooks();
   Optional<Book> findBookIsbn(String isbn);

   Book findBookByIsbn(String isbn);

   Book addAuthorToBook(String isbn, Long authorId);

   List<Book> searchBooks(String search);
   List<Book> findAll();
   void save(Book book);

   Book findById(Long bookId);
   void delete(Long id);
   List<Book> findBooksByBookStoreId(Long bookStoreId);
}
