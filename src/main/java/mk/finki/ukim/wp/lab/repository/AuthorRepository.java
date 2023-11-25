package mk.finki.ukim.wp.lab.repository;
import mk.finki.ukim.wp.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AuthorRepository {
    public List<Author> findAll();
    public Optional<Author> findById(Long id);
}
