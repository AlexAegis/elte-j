package biblio;

import person.Author;

public class Entry {

    private static int entryCount = 0;

    private Author author;
    private String title;
    private int releaseYear;
    private String releaser;
    private int id = Entry.entryCount;

    private Entry(Author author, String title, int releaseYear, String releaser) {
        this.author = author;
        this.title = title;
        this.releaseYear = releaseYear;
        this.releaser = releaser;
    }

    public static Entry make(Author author, String title, int releaseYear, String releaser) {
        if(releaseYear < 1500 || releaseYear > 2016) {
            return null;
        }
        if(title.isEmpty() || releaser.isEmpty()) {
            return null;
        }
        Entry.entryCount++;
        return new Entry(author, title, releaseYear, releaser);
    }

    public int getId() {
        return id;
    }
}