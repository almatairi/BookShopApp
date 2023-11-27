package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreRepository {
    public List<BookStore> findAll();

}
