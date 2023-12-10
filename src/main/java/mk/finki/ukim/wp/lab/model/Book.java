package mk.finki.ukim.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;
    private   String isbn;
    private   String title;
    private    String genre;
    private   int year;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author")
    private  List<Author> authors;

    @ManyToOne(fetch = FetchType.EAGER)
    private BookStore bookStore;

    public Book( String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
    }

    public Book() {
    }
}
