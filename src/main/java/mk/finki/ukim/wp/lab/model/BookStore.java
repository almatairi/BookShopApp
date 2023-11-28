package mk.finki.ukim.wp.lab.model;

public class BookStore {
    private Long id;
    private String name;
    private String city;
    private String address;

    public BookStore( String name, String city) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.city = city;
    }
}
