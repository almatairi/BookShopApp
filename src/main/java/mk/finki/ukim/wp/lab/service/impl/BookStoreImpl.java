package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.repository.BookStoreRepository;
import mk.finki.ukim.wp.lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreImpl  implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;

    public BookStoreImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<BookStore> findAll() {
        return this.bookStoreRepository.findAll();
    }
}
