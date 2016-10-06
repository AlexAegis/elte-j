package biblio;

import person.Author;

public class Entry {

    private static int entryCount = 0;

    private static final int FORMAT_RAW = 0;
    private static final int FORMAT_AUTHOW_YEAR = 1;
    private static final int FORMAT_AUTHOR_YEAR_COMPACT = 2;

    private Author author;
    private String title;
    private int releaseYear;
    private String publisher;
    private int id = Entry.entryCount;

    private Entry(Author author, String title, int releaseYear, String publisher) {
        this.author = author;
        this.title = title;
        this.releaseYear = releaseYear;
        this.publisher = publisher;
    }

    public static Entry make(Author author, String title, int releaseYear, String releaser) {
        if(releaseYear < 1500 || releaseYear > 2016) {
            return null;
        }
        if(title.isEmpty() || author == null) {
            return null;
        }
        Entry.entryCount++;
        return new Entry(author, title, releaseYear, releaser);
    }

    public static void resetId() {
        Entry.entryCount = 0;
    }

    public static int count() {
        return Entry.entryCount;
    }

    public Author getAuthor() {
        return Author.copy(this.author);
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getId() {
        return id;
    }

    public String show(int format) {
        String c = "";

        if(format == FORMAT_RAW) {
            c = Integer.toString(this.id);
        } else if(format == FORMAT_AUTHOW_YEAR) {
            c = this.author.getLastName() + this.releaseYear;
        } else if(format == FORMAT_AUTHOR_YEAR_COMPACT) {
            c = this.author.show().substring(0,1) + Integer.toString(this.releaseYear).substring(2,3);
        }

        c = "[" + c + "] " + this.author.show() + ". " + this.title;
        if(!this.publisher.isEmpty()) {
            c = c.concat(", " + this.publisher);
        }

        c = c.concat(", " + this.releaseYear + ".");

        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Entry entry = (Entry) o;

        if (releaseYear != entry.releaseYear) {
            return false;
        }
        if (author != null ? !author.equals(entry.author) : entry.author != null) {
            return false;
        }
        if (title != null ? !title.equals(entry.title) : entry.title != null) {
            return false;
        }
        return publisher != null ? publisher.equals(entry.publisher) : entry.publisher == null;

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + releaseYear;
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        return result;
    }
}