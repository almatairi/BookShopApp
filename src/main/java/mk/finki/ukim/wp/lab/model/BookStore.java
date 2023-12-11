package mk.finki.ukim.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "bookstore")
@AllArgsConstructor
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @Column(name = "bookstore_address")
    private String address;

    public BookStore( String name, String city) {
        this.name = name;
        this.city = city;
    }

    public BookStore() {

    }
}
