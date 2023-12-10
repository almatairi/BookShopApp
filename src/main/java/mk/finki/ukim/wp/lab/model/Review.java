package mk.finki.ukim.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer score;
    @Column(length = 4000)
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;
    private LocalDateTime timestamp;

    public Review(){

    }
}
