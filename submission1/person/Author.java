package person;

public class Author {

    private Name name;

    private Author(Name name) {
        this.name = name;
    }

    private Author(String firstName, String lastName) {
        this(new NameBuilder().addName(firstName).addName(lastName).getName());
    }

    public static Author make(String name) {
        return new Author(new NameBuilder(name).getName());
    }

    public String getLastName() {
        return this.name.getLastName();
    }

    public String getFirstName() {
        return this.name.getFirstName();
    }

}