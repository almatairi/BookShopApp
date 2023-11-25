package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    public List<Book> findAll();

    public Book findByIsbn(String isbn);
    Author addAuthorToBook(Author author, Book book);
}
