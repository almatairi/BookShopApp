package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<BookStore> bookStores;

    @PostConstruct
    public void init() {
        authors.add(new Author(01L, "Ismail", "Kadare", "Ismail Kadare, (born January 28, 1936, Gjirokastër, Albania), Albanian novelist and poet whose work explored his country’s history and culture and gained an international readership."));
        authors.add(new Author(02L, "George", "Orwell", "George Orwell, pseudonym of Eric Arthur Blair, (born June 25, 1903, Motihari, Bengal, India—died January 21, 1950, London, England), English novelist, essayist, and critic famous for his novels Animal Farm (1945) and Nineteen Eighty-four (1949), the latter a profound anti-utopian novel that examines the dangers of totalitarian rule."));
        authors.add(new Author(03L, "Harper", "Lee", "Harper Lee, in full Nelle Harper Lee, (born April 28, 1926, Monroeville, Alabama, U.S.—died February 19, 2016, Monroeville), American writer nationally acclaimed for her novel To Kill a Mockingbird (1960)."));
        authors.add(new Author(04L, "Tracy", "Chevalier", "Tracy Rose Chevalier FRSL (born 19 October 1962)[1] is an American-British novelist. She is best known for her second novel, Girl with a Pearl Earring, which was adapted as a 2003 film starring Scarlett Johansson and Colin Firth."));
        authors.add(new Author(05L, "Ibn Qayyim", "al-Jawziyya", "Sham Al-din Muhammad Ibn Abi Bakr, Ibn al-Qayyim al-Jawziyya, commonly known as Ibn Qayyim al-Jawziyyah was born in a small farming village near Damascus, Syria in 691 A.H./1292 C.E, and he studied under his father who was the local attendant (qayyim) of al-Jawziyya school."));

        BookStore bookstore = new BookStore("Bibloteka Prishtines", "Prishtina");

        books.add(new Book("ISBN1", "Prilli i thyer", "Fiction", 2003, authors.subList(0, 1), bookstore));
        books.add(new Book("ISBN2", "1984", "Novel", 1949, authors.subList(1, 2), bookstore));
        books.add(new Book("ISBN3", "To Kill a Mockingbird", "Novel", 1962, authors.subList(2, 3), bookstore));
        books.add(new Book("ISBN4", "Girl with a pearl earring", "Novel", 1999, authors.subList(3, 4), bookstore));
        books.add(new Book("ISBN5", "Disciplining the soul", "Religion", 2021, authors.subList(4, 5), bookstore));
    }
}
