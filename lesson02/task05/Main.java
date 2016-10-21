import Exceptions.EmptyNameException;
import Exceptions.IllegalBirthYearException;

public class Main {

    public static void main(String[] args) {

        Person a;
        Name n;

        try {

            n = new NameBuilder().addName("Tom").addName("Hanks").getName();

            try {

                a = Person.makePerson(n, Gender.MALE, 1956);
                a.show();
                if(a.isAdult()) {
                    System.out.println(a.getName().toString() + " is an adult.");
                } else {
                    System.out.println(a.getName().toString() + " is not an adult.");
                }

            } catch(IllegalBirthYearException e) {
                e.printStackTrace();
            }

        } catch(EmptyNameException e) {
            e.printStackTrace();
        }
    }
}
