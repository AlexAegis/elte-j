package person;

import java.util.Arrays;
import java.util.List;

public class Author {

    private String firstName;
    private String lastName;

    private Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(Author author) {
        this(author.getFirstName(), author.getLastName());
    }

    public static Author make(String names) {
        List<String> nameAsList = Arrays.asList(names.split(" "));
        if(names.isEmpty() || !names.contains(" ") || nameAsList.size() != 2) {
            return null;
        }
        if(nameAsList.size() == 2 && Character.isLowerCase(nameAsList.get(0).charAt(0))
                                    && Character.isLowerCase(nameAsList.get(1).charAt(0))){
            return null;
        }
        return new Author(nameAsList.get(0), nameAsList.get(1));
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String show() {
        return this.getLastName() + ", " + this.getFirstName().charAt(0);
    }

    public boolean equals(Author author) {
        return author != null
                && author.getLastName().equals(this.getLastName())
                && author.getFirstName().equals(this.getFirstName());
    }

}