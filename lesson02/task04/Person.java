import java.util.Calendar;

import Exceptions.EmptyNameException;
import Exceptions.IllegalBirthYearException;

public class Person {

    private Name name;
    private Gender gender;
    private int birthYear;
    private final String DELIMITER = ", ";

    public Person(Name name, Gender gender, int birthYear) throws IllegalBirthYearException {
        this.name = name;
        this.gender = gender;
        if(birthYear >= 1880 || birthYear <= Calendar.getInstance().get(Calendar.YEAR)) {
            this.birthYear = birthYear;
        } else {
            throw new IllegalBirthYearException();
        }

    }

    public static Person makePerson(Name name, Gender gender, int birthYear) throws IllegalBirthYearException {
        return new Person(name, gender, birthYear);
    }

    public Person show() {
        System.out.println(this.toString());
        return this;
    }

    @Override
    public String toString() {
        return this.name.toString() + DELIMITER + this.gender.getValue() + DELIMITER + this.birthYear;
    }

}
