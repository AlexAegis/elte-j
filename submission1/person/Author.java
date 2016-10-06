package person;

public class Author {

    private Author() {

    }

    public static  Author make(String name) {
        return new Author();
    }

    public String getLastName() {
        return null;
    }

    public String getFirstName() {
        return null;
    }

}