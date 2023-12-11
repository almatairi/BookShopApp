package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.impl.InMemoryAuthorRepository;
import mk.finki.ukim.wp.lab.repository.impl.InMemoryBookRepository;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final InMemoryBookRepository bookRepository;
    private final InMemoryAuthorRepository authorRepository;

    public BookServiceImpl(InMemoryBookRepository bookRepository, InMemoryAuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
       return bookRepository.findByIsbn(isbn).orElse(null);
    }

    @Override
    public Book addAuthorToBook(String isbn, Long authorId) {
        Book book = findBookByIsbn(isbn);
        authorRepository.findById(authorId).ifPresent(author -> bookRepository.addAuthorToBook(author, book));
        return book;
    }

    @Override
    public List<Book> searchBooks(String searchQuery) {
        return listBooks().stream().filter(a-> a.getTitle().equalsIgnoreCase(searchQuery)).toList();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    @Override
    public void save(Book book) {
        if (book.getId() != null) {
            book.setId(generateNewId());
            bookRepository.add(book);
        } else {
            bookRepository.update(book);
        }
    }
    @Override
    public List<Book> findBooksByBookStoreId(Long bookStoreId) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getBookStore() != null && book.getBookStore().getId().equals(bookStoreId))
                .collect(Collectors.toList());
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    private Long generateNewId() {
        long id = (long) (Math.random()*1000);
        return id;
    }
}