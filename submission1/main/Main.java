package main;

import person.Author;

public class Main {


    public static void main(String[] args) {
        Author a = Author.make("John Maker");
        System.out.println(a.getFirstName());
        System.out.println(a.getLastName());
    }
}