/*package tests;

import person.Author;
import utest.*;

public class AuthorTest extends Testable {
    public void assertion() {
        check("make(): Ures String eseten nem johet letre objektum.", Author.make("") == null);
        check("make(): Nem johet letre objektum, ha nincs ket resze a nevnek.", Author.make("Smith") == null);
        Author a = Author.make("John Smith");
        check("getLastName(): Nem jol mukodik.", a.getLastName().equals("Smith"));
        check("getFirstName(): Nem jol mukodik.", a.getFirstName().equals("John"));
        Author b = Author.make("John Smith");
        check("equals(): Azonos objektumokra nem ad igazat.", b.equals(a));
        Author c = new Author(b);
        check("equals(): A konstruktorral nem masolodik le jol az objektum.", c.equals(b) && c.equals(a));
        Author d = Author.make("Jack Smith");
        check("equals(): Az eltero keresztneveket nem veszi eszre.", !a.equals(d));
        check("show(): Nem megfelelo eredmenyt ad.", a.show().equals("Smith, J"));
    }

    public String description() { return "person.Author"; }
    public String className() { return "person.Author"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { constructor(className(), Author.class)
        , method(className() + ".getLastName")
        , method(className() + ".getFirstName")
        , staticMethod(className() + ".make", String.class)
        , method(className() + ".equals", Author.class)
        , method(className() + ".show")
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new AuthorTest());
    }
}
*/