package biblio;

import person.Author;

public class Entry {

    private static int entryCount = 0;

    public static final int FORMAT_RAW = 0;
    public static final int FORMAT_AUTHOR_YEAR = 1;
    public static final int FORMAT_AUTHOR_YEAR_COMPACT = 2;

    private Author author;
    private String title;
    private int releaseYear;
    private String publisher;
    private int id = Entry.entryCount - 1;

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
        return Author.make(author.getFirstName() + " " +  author.getLastName());
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
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
        } else if(format == FORMAT_AUTHOR_YEAR) {
            c = this.author.getLastName() + this.releaseYear;
        } else if(format == FORMAT_AUTHOR_YEAR_COMPACT) {
            c = this.author.show().substring(0,2) + Integer.toString(this.releaseYear).substring(2,4);
        }

        c = "[" + c + "] " + this.author.show() + ". " + this.title;
        if(!this.publisher.isEmpty()) {
            c = c.concat(", " + this.publisher);
        }

        c = c.concat(", " + this.releaseYear);

        return c;
    }
}