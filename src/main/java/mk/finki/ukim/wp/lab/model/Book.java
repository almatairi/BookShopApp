package mk.finki.ukim.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public    Long id;
    public    String isbn;
    public    String title;
    public     String genre;
    public    int year;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author")
    public   List<Author> authors;

    @ManyToOne(fetch = FetchType.EAGER)
    public BookStore bookStore;

    public Book( String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
    }
public Book(){

}

}
