package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.repository.BookStoreRepository;

import java.util.List;

public interface BookStoreService {

    List<BookStore> findAll();
}
