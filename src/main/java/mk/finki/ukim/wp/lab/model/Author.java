package mk.finki.ukim.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Data
@Entity
@Table(name = "author")
public class Author implements List<Author> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @Column(length = 4000)
    private String biography;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateofBirth;

    public Author(){

    }

    public Author(Long id, String name, String surname, String biography, LocalDate dateofBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.dateofBirth = dateofBirth;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Author> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Author author) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Author> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Author> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Author get(int index) {
        return null;
    }

    @Override
    public Author set(int index, Author element) {
        return null;
    }

    @Override
    public void add(int index, Author element) {

    }

    @Override
    public Author remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Author> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Author> listIterator(int index) {
        return null;
    }

    @Override
    public List<Author> subList(int fromIndex, int toIndex) {
        return null;
    }
}
