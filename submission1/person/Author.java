package person;

public class Author {

    private Name name;

    private Author(Name name) {
        this.name = name;
    }

    public Author(Author author) {
        new Author(new NameBuilder(author.getFirstName() + author.getLastName()).getName());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Author author = (Author) o;

        return name != null ? name.equals(author.name) : author.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}