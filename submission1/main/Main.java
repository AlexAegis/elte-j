package main;

import biblio.Bibliography;
import biblio.Entry;
import biblio.Query;
import csv.CSV;
import person.Author;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Entry.resetId();
        List<String> params = Arrays.asList(args);
        Bibliography bibliography = new Bibliography(CSV.read(new Scanner(System.in)));

        int format = 0;

        if (params.contains("publisher=") && (params.size() > (params.lastIndexOf("publisher=") + 1))) {
            bibliography.filter(Query.byPublisher(params.get(params.lastIndexOf("publisher=") + 1)));
        }

        if (params.contains("author=") && params.size() > params.lastIndexOf("author=") + 1) {
            bibliography.filter(Query.byAuthor(Author.make(params.get(params.lastIndexOf("author=") + 1))));
        }

        if (params.contains("format=") && params.size() > params.lastIndexOf("format=") + 1) {
            switch (params.get(params.lastIndexOf("format=") + 1)) {
                case "authorYear" : format = 1;
                    break;
                case "authorYearCompact" : format = 2;
                    break;
                default: break;
            }
        }
        System.out.print(bibliography.show(format));
    }
}