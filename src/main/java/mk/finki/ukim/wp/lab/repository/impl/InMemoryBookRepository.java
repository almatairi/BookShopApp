package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static mk.finki.ukim.wp.lab.bootstrap.DataHolder.books;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findByIsbn(String isbn) {
        return (Book) books.stream().filter(r -> r.getIsbn().equals(isbn)).collect(Collectors.toList());
    }

    @Override
    public Author addAuthorToBook(Author author, Book book) {
        List<Book> updateBooks = books.stream().map(b -> {
            if (b.getIsbn().equals(book.getIsbn())) {
                b.getAuthors().add(author);
            }
            return b;
        }).collect(Collectors.toList());

        DataHolder.books=updateBooks;
        return author;
    }
}
