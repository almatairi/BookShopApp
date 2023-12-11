package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static mk.finki.ukim.wp.lab.bootstrap.DataHolder.books;

@Repository
public class InMemoryBookRepository {
    public List<Book> findAll(){
        return books;
    }

    public Optional<Book> findByIsbn(String isbn){
        return books.stream().filter(book->book.getIsbn().equals(isbn)).findFirst();
    }

    public Optional<Book> findById(Long id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public void addAuthorToBook(Author author, Book book){
        if(author != null && book != null && !book.getAuthors().contains(author)){
            book.getAuthors().add(author);
        }
    }

    public void update(Book book){
        books = books.stream().map(b-> b.getId().equals(book.getId()) ? book : b).collect(Collectors.toList());
    }

    public void delete(Long id){
        books.removeIf(book -> book.getId().equals(id));
    }
    public void add(Book book){
        books.add(book);
    }
}