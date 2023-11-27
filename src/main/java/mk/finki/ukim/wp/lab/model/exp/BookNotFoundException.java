package mk.finki.ukim.wp.lab.model.exp;


public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super(String.format("Book with id %d was not found", id));
    }
}
