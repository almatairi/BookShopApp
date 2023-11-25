package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    Optional<Author> findById(Long id);
}
