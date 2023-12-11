package mk.finki.ukim.wp.lab.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorFullName implements Serializable {
    private String name;
    private String surname;

    public AuthorFullName(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public AuthorFullName() {
    }
}
