package main;

import biblio.Entry;
import person.Author;

public class Main {


    public static void main(String[] args) {
        Author a = Author.make("John Maker");
        System.out.println(a.show());


        Entry entry1 = Entry.make(a,"",1,"");
        Entry entry2 = Entry.make(a,"",1,"");
        Entry entry3 = Entry.make(a,"",1,"");
        System.out.println(entry1.getId());
        System.out.println(entry2.getId());
        System.out.println(entry3.getId());
    }
}