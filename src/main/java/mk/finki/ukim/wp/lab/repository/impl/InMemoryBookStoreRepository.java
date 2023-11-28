package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.repository.BookStoreRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class InMemoryBookStoreRepository implements BookStoreRepository {
    @Override
    public List<BookStore> findAll() {
        return DataHolder.bookStores;
    }
}
