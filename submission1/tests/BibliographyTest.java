/*package tests;

import csv.CSV;
import biblio.Bibliography;
import biblio.Entry;
import biblio.Query;
import person.Author;
import java.util.Scanner;
import utest.*;

public class BibliographyTest extends Testable {
    public void assertion() {
        String sample =
          "John Smith,Title of Book,Fancy Publishing House,1999\n" +
          "Jack Winston,Pride and Prejudice,, 1910\n" +
          "Bill Murray,That is My Groundhog Day,,lulz\n" +
          "Invalid,Invalid,,0\n" +
          "Will Smith,,Random House,2011\n";
        Scanner sc = new Scanner(sample);
        CSV csv = CSV.read(sc);
        Bibliography bib = new Bibliography(csv);
        check("Nem jol kerulnek beolvasasra a CSV adatok.",
          bib.show(Entry.FORMAT_AUTHOR_YEAR).equals("[Smith1999] Smith, J. Title of Book, Fancy Publishing House, 1999\n[Winston1910] Winston, J. Pride and Prejudice, 1910\n"));
        Query q = Query.byAuthor(Author.make("Jack Winston"));
        bib.filter(q);
        check("Nem mukodik a szures szerzore.",
          bib.show(Entry.FORMAT_AUTHOR_YEAR).equals("[Winston1910] Winston, J. Pride and Prejudice, 1910\n"));
        Query r = Query.byPublisher("Fancy Publishing House");
        bib = new Bibliography(csv);
        bib.filter(r);
        check("Nem mukodik a szures kiadora.",
          bib.show(Entry.FORMAT_AUTHOR_YEAR).equals("[Smith1999] Smith, J. Title of Book, Fancy Publishing House, 1999\n"));
    }

    public String description() { return "biblio.Bibliography"; }
    public String className() { return "biblio.Bibliography"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { constructor(className(), CSV.class)
        , method(className() + ".filter", Query.class)
        , method(className() + ".show", int.class)
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new BibliographyTest());
    }
}
*/