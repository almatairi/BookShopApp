package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookStoreService {

    List<Book> findAll();
    Optional<Book> findById(Long id);
}
