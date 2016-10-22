package tests;

import java.util.Scanner;

import biblio.Bibliography;
import biblio.Entry;
import biblio.Query;
import csv.CSV;
import person.Author;
import utest.Test;
import utest.Testable;

public class BibliographyTest extends Testable {
    public void assertion() {
    	String str;
    	CSV csv;
    	Bibliography bib;
    	
    	str = "John Smith,Title of Book,Fancy Publishing House,1999\n" + // valid with publisher
    	  "Jack Winston,Pride and Prejudice,, 1910\n"; // valid without publisher
    	csv = CSV.read(new Scanner(str));
        bib = new Bibliography(csv);
        check("Nem jol kerulnek beolvasasra a helyes CSV adatok.",
          bib.show(Entry.FORMAT_AUTHOR_YEAR).equals("[Smith1999] Smith, J. Title of Book, Fancy Publishing House, 1999\n[Winston1910] Winston, J. Pride and Prejudice, 1910\n"));
    	
        bib = new Bibliography(csv);
        check("Nem kerul meghivasra a resetId().",
          bib.show(Entry.FORMAT_RAW).equals("[0] Smith, J. Title of Book, Fancy Publishing House, 1999\n[1] Winston, J. Pride and Prejudice, 1910\n"));

        check("Nem az Entry objektumok elmentese elott, hanem az utan kerul meghivasra a resetId()", Entry.count() == 2);
                
    	str = "John Smith,Title of Book,Fancy Publishing House,1999\n" + // valid with publisher
          "Jack Black,,2005\n" + // not enough fields
    	  "John Smith,Title of Book,Fancy Publishing House,1999,Invalid\n" + // too many fields
    	  "Jack Winston,Pride and Prejudice,, 1910\n"; // valid without publisher
    	csv = CSV.read(new Scanner(str));
        bib = new Bibliography(csv);
        check("Nem jol kerulnek beolvasasra a hibas oszlopszamu CSV adatok.",
          bib.show(Entry.FORMAT_RAW).equals("[0] Smith, J. Title of Book, Fancy Publishing House, 1999\n[1] Winston, J. Pride and Prejudice, 1910\n"));
    	
    	str = "John Smith,Title of Book,Fancy Publishing House,1999\n" + // valid with publisher
          "Smith,Title of Book,Fancy Publishing House,1999\n" + // wrong author name
          "Bill Murray,That is My Groundhog Day,,lulz\n" + // wrong year format
          "Bill Murray,That is My Groundhog Day,,12ax\n" + // wrong year format
          "John Smith,Title of Book,,10\n" + // wrong year value
          "Will Smith,,Random House,2011\n" + // missing title
  	      "Jack Winston,Pride and Prejudice,, 1910\n"; // valid without publisher
    	csv = CSV.read(new Scanner(str));
    	bib = new Bibliography(csv);
    	check("Nem jol kerulnek beolvasasra a hibas erteku CSV adatok.",
    	  bib.show(Entry.FORMAT_RAW).equals("[0] Smith, J. Title of Book, Fancy Publishing House, 1999\n[1] Winston, J. Pride and Prejudice, 1910\n"));


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
