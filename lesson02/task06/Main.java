import Exceptions.EmptyNameException;
import Exceptions.IllegalBirthYearException;

public class Main {

    public static void main(String[] args) {

        Person a;
        Person b;
        Person c;

        try {
            a = Person.makePerson(new NameBuilder().addName("Tom").addName("Hanks").getName()
                                    , Gender.MALE
                                    , 1956);
            b = Person.makePerson(new NameBuilder().addName("Tom").addName("Hanks").getName()
                                    , Gender.MALE
                                    , 1956);
            c = Person.makePerson(new NameBuilder().addPrefix("Captain").addName("Johnny").addName("Depp").getName()
                                    , Gender.MALE
                                    , 1963);
            a.show();
            b.show();
            c.show();

            if(a.isAdult()) {
                System.out.println(a.getName().toString() + " is an adult.");
            } else {
                System.out.println(a.getName().toString() + " is not an adult.");
            }

            if(a.equals(b)) {
                System.out.println(a.getName().toString() + " is the same as " + b.getName().toString());
            } else {
                System.out.println(a.getName().toString() + " is not the same as " + b.getName().toString());
            }


        } catch(EmptyNameException e) {
            e.printStackTrace();
        } catch(IllegalBirthYearException e) {
            e.printStackTrace();
        }
    }
}
