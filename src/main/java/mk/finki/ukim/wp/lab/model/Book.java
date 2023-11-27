package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Book {
     Long id;
     String isbn;
     String title;
     String genre;
     int year;
     List<Author> authors;
     private BookStore bookStore;
}
