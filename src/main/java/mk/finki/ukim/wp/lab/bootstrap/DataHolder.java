package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.model.Review;
import mk.finki.ukim.wp.lab.repository.jpa.AuthorRepository;
import mk.finki.ukim.wp.lab.repository.jpa.BookRepository;
import mk.finki.ukim.wp.lab.repository.jpa.BookStoreRepository;
import mk.finki.ukim.wp.lab.repository.jpa.ReviewRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Author> authors = null;
    public static List<Book> books = null;
    public static List<BookStore> bookStores = null;
    public static List<Review> reviews = null;

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
    private final ReviewRepository reviewRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository, BookStoreRepository bookStoreRepository, ReviewRepository reviewRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookStoreRepository = bookStoreRepository;
        this.reviewRepository = reviewRepository;
    }

    @PostConstruct
    public void init(){
        authors = new ArrayList<>();
        books = new ArrayList<>();
        bookStores = new ArrayList<>();
        reviews = new ArrayList<>();

        if(authorRepository.count() == 0){
            authors.add(new Author(01L, "Ismail", "Kadare", "Ismail Kadare, (born January 28, 1936, Gjirokastër, Albania), Albanian novelist and poet whose work explored his country’s history and culture and gained an international readership.", LocalDate.of(1936, 1, 28)));
            authors.add(new Author(01L, "Sterjo", "Spase", "Sterjo Spasse (1914-1989) is a novelist and short story writer of (Slav) Macedonian origin from Lake Prespa. It was while teaching in the little village of Derviçan south of Gjirokastra that the eighteen-year-old Spasse began writing his first novel, and his masterpiece, Nga jeta në jetë – Pse!?, Korça 1935",LocalDate.of(1936, 1, 28)));
            authors.add(new Author(01L, "Lasgush", "Poradeci", "Lasgush Poradeci (1899-1987) had lived the final years of his life in his beloved town of Pogradec on Lake Ohrid, not far from the Macedonian border, tending his garden and studying the ever-changing moods of the lake. The rhythmic and gentle lapping of the waves had always been among the best", LocalDate.of(1936, 1, 28)));
            authors.add(new Author(01L, "Rexhep", "Qosja", "Fan Noli (1882-1965), also known as Theophan Stylian Noli, was not only an outstanding leader of the Albanian-American community, but also a pre-eminent and multi-talented figure of Albanian literature, culture, religious life and politics. Noli was born in the village of Ibrik Tepe, south of Edirne (Adrianopole) in European Turkey",LocalDate.of(1936, 1, 28)));
            authors.add(new Author(01L, "Fan", "Noli", "Rexhep Qosja (born 1936) is an Albanian writer, literary critic and Professor at University of Prishtina. He has been considered the first postmodern Albanian novelist and one of the greatest Balkans literary critics.",LocalDate.of(1936, 1, 28)));

            authorRepository.saveAll(authors);
        }

        if(bookRepository.count() == 0){
            List<BookStore> bookStoreList = bookStoreRepository.findAll();
            List<Author> authorList = authorRepository.findAll();
            books.add(new Book("01", "Prilli thyer", "Fiction", 1999, (List<Author>) authorList.get(0), bookStoreList.get(0)));
            books.add(new Book("02", "Nga jeta ne  jete, PSE?", "Fiction", 1999, (List<Author>) authorList.get(0), bookStoreList.get(0)));
            books.add(new Book("03", "Vepra poetike", "Poem", 1999, (List<Author>) authorList.get(0), bookStoreList.get(0)));
            books.add(new Book("04", "Te fshehtat e treguara", "Fiction", 1999, (List<Author>) authorList.get(0), bookStoreList.get(0)));
            books.add(new Book("05", "The adriatic review", "Fiction", 1999, (List<Author>) authorList.get(0), bookStoreList.get(0)));

            bookRepository.saveAll(books);
        }


    }


}
