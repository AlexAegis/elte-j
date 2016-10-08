package tests;

import person.Author;
import biblio.Entry;
import utest.*;

public class EntryTest extends Testable {
    public void assertion() {
        Author a = Author.make("John Smith");
        Author b = Author.make("Jack Wilson");
        Entry e, f, g;
        e = Entry.make(a, "", 1999, "Fancy Publishing House");
        check("make(): Ures cimmel nem lehet objektumot letrehozni.", e == null);
        e = Entry.make(a, "Title of Book", 0, "");
        check("make(): Ervenytelen evvel nem lehet objektumot letrehozni.", e == null);
        e = Entry.make(a, "Title of Book", 1999, "Fancy Publishing House");
        check("make(): Szabalyos paramterekkel nem jott letre objektum", e != null);
        f = Entry.make(b, "Yet Another Great Title", 2005, "");
        g = Entry.make(b, "Something New", 2001, "Addison-Wesley");
        check("Az objektumok nem jol sorszamozodnak.",
          e.getId() == 0 && f.getId() == 1 && g.getId() == 2);
        check("getAuthor(): Nem jol mukodik.", e.getAuthor().equals(a));
        check("getTitle(): Nem jol mukodik.", e.getTitle().equals("Title of Book"));
        check("getYear(): Nem jol mukodik.", f.getYear() == 2005);
        check("getPublisher(): Nem jol mukodik.", g.getPublisher().equals("Addison-Wesley"));
        check("count(): Nem jol szamolodnak az elemek.", Entry.count() == 3);
        check("show(): Nem jo a raw formazas.",
          e.show(Entry.FORMAT_RAW).equals("[0] Smith, J. Title of Book, Fancy Publishing House, 1999"));
        check("show(): Nem jo az authorYear formazas.",
          e.show(Entry.FORMAT_AUTHOR_YEAR).equals("[Smith1678] Smith, J. Title of Book, Fancy Publishing House, 1999"));
        check("show(): Nem jo az authorYearCompact formazas.",
          e.show(Entry.FORMAT_AUTHOR_YEAR_COMPACT).equals("[Sm78] Smith, J. Title of Book, Fancy Publishing House, 1999"));
        check("show(): Ha nincs kiado, akkor nem kell megjelennie az eredmenyben.",
          f.show(Entry.FORMAT_RAW).equals("[1] Wilson, J. Yet Another Great Title, 2005"));
    }

    public String description() { return "biblio.Entry"; }
    public String className() { return "biblio.Entry"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { method(className() + ".getId")
        , method(className() + ".getAuthor")
        , method(className() + ".getTitle")
        , method(className() + ".getYear")
        , method(className() + ".getPublisher")
        , staticMethod(className() + ".make", Author.class, String.class, int.class, String.class)
        , method(className() + ".count")
        , method(className() + ".show", int.class)
        , staticMethod(className() + ".resetId")
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[]
        { staticField(className() + ".FORMAT_RAW")
        , staticField(className() + ".FORMAT_AUTHOR_YEAR")
        , staticField(className() + ".FORMAT_AUTHOR_YEAR_COMPACT")
        };
    }

    public static void main(String... args) {
        Test.main(new EntryTest());
    }
}
