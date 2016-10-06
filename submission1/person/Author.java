package person;

import exceptions.IllegalNameException;

import java.util.Objects;

public class Author {

    private Name name;

    private Author(Name name) {
        this.name = name;
    }

    public Author(Author author) {
        try {
            this.name = new NameBuilder().addName(author.getFirstName()).addName(author.getLastName()).getName();
        } catch (IllegalNameException e) {
            e.printStackTrace();
        }
    }

    public static Author make(String name) {
        try {
            NameBuilder n = new NameBuilder(name);
            return new Author(n.getName());
        } catch (IllegalNameException e) {
            return null;
        }
    }

    static Author copy(Author author) {
        return Author.make(author.getFirstName() + " " +  author.getLastName());
    }

    public String getLastName() {
        return this.name.getLastName();
    }

    public String getFirstName() {
        return this.name.getFirstName();
    }

    public String show() {
        return this.getLastName() + ", " + this.getFirstName().charAt(0);
    }

    public boolean equals(Author o) {
        return this == o || o != null && (name != null ? name.equals(o.name) : o.name == null);
    }

}