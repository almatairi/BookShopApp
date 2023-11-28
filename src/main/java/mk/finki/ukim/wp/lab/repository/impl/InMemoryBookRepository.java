package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static mk.finki.ukim.wp.lab.bootstrap.DataHolder.books;

@Repository
public class InMemoryBookRepository {

//
//    @Override
//    public List<Book> findAll() {
//        return books;
//    }
//
//    @Override
//    public Book findByIsbn(String isbn) {
//        return (Book) books.stream().filter(r -> r.getIsbn().equals(isbn)).collect(Collectors.toList());
//    }
//
//    @Override
//    public Author addAuthorToBook(Author author, Book book) {
//        List<Book> updateBooks = books.stream().map(b -> {
//            if (b.getIsbn().equals(book.getIsbn())) {
//                b.getAuthors().add(author);
//            }
//            return b;
//        }).collect(Collectors.toList());
//
//        DataHolder.books=updateBooks;
//        return author;
//    }
//
//    @Override
//    public void edit(String title, String isbn, String genre, int year, Long bookId) {
//
//    }


//    public void delete(Long bookId) {
//        for (int i = 0; i < books.size(); i++) {
//            if (books.get(i).id.equals(bookId)) {
//                books.remove(i);
//            }
//
//
//        }
//    }

    public List<Book> findAll(){
        return books;
    }
    public Optional<Book> findById(Long id){
        return DataHolder.books.stream().filter(i->i.getIsbn().equals(id)).findFirst();
    }
    public Book save(Book book){
        if(book == null || book.getTitle().isEmpty()){
            throw new IllegalArgumentException();
        }

        DataHolder.books.removeIf(b -> b.getTitle().equals(book.getTitle()));
        DataHolder.books.add(book);
        return book;
    }
    public Optional<Book> findByIsbn(String isbn){
        return DataHolder.books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
    }

    public void editBook(Long bookId, String title, String isbn, String genre, int year, Long id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(bookId)) {
                books.get(i).setTitle(title);
                books.get(i).setIsbn(isbn);
                books.get(i).setGenre(genre);
                books.get(i).setYear(year);
            }
        }
    }

    public void delete(Long bookId){
        DataHolder.books.removeIf(b->b.getTitle().equals(bookId));
    }
}