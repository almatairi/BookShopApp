package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Book {
    public   Long id;
    public   String isbn;
    public   String title;
    public    String genre;
    public   int year;
    public   List<Author> authors;
    public BookStore bookStore;

    public Book( String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) {
        this.id = (long) (Math.random() * 1000);
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
    }



}
