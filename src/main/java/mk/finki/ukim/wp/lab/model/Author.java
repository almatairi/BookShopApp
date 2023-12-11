package mk.finki.ukim.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4000)
    private String biography;

   @DateTimeFormat(pattern = "dd-MM-yyyy")
   private LocalDate dateofBirth;

    public Author(){

    }

    public Author(Long id, String name, String surname, String biography, LocalDate dateofBirth) {
        this.id = id;

        this.biography = biography;
        this.dateofBirth = dateofBirth;
    }
}
