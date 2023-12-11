package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.impl.InMemoryBookRepository;
import mk.finki.ukim.wp.lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreImpl  implements BookStoreService {

    private final InMemoryBookRepository bookStoreRepository;


    public BookStoreImpl(InMemoryBookRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }


    @Override
    public List<Book> findAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookStoreRepository.findById(id);
    }

}
