package tests;

import person.Author;
import biblio.Entry;
import biblio.Query;
import utest.*;

public class QueryTest extends Testable {
    public void assertion() {
        Author a = Author.make("John Smith");
        Author b = Author.make("Winston Churchill");
        Query q = Query.byAuthor(a);
        Query r = Query.byPublisher("Prentice Hall");
        Entry e = Entry.make(a, "Title of Book", 2000, "Random House");
        Entry f = Entry.make(b, "Modesty and Majesty", 1952, "Prentice Hall");
        Entry g = Entry.make(b, "Waging War with the World", 1909, "Random House");
        check("accept(): Nem fogadja el a megadott szerzot.", q.accept(e));
        check("accept(): Nem fogadja el a megadott kiadot.", r.accept(f));
        check("accept(): Elfogadja olyan bejegyzest, amelyet nem kellene.", !q.accept(g) && !r.accept(g));
    }

    public String description() { return "biblio.Query"; }
    public String className() { return "biblio.Query"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { staticMethod(className() + ".byAuthor", Author.class)
        , staticMethod(className() + ".byPublisher", String.class)
        , method(className() + ".accept", Entry.class)
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new QueryTest());
    }
}
