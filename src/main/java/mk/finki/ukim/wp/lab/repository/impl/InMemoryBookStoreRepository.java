package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.repository.jpa.BookStoreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBookStoreRepository {
    public List<BookStore> findAll(){
        return DataHolder.bookStores;
    }

    public BookStore findById(Long id){
        return DataHolder.bookStores.stream().filter(bookStore -> bookStore.getId().equals(id)).findFirst().orElse(null);
    }

}
