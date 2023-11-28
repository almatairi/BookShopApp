package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import mk.finki.ukim.wp.lab.repository.impl.InMemoryBookRepository;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final InMemoryBookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(InMemoryBookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        return this.bookRepository.findByIsbn(isbn);
    }

    @Override
    public Optional<Book> saveBook(String title, String isbn, String genre, int year, Long bookStoreId) {
        return Optional.empty();
    }

    @Override
    public void editBook(String title, String isbn, String genre, int year, Long bookId) {

    }

    @Override
    public void editBook(Long bookId, String title, String isbn, String genre, int year, Long id) {
        bookRepository.editBook(bookId , title, isbn, genre, year, id);
    }

    @Override
    public void deleteById(Long bookId) {
        bookRepository.delete(bookId);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void addAuthorToBook(Long authorId, String isbn){
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("Author not found"));
        Book book = bookRepository.findByIsbn(isbn).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        book.getAuthors().add(author);
        bookRepository.save(book);
    }
}