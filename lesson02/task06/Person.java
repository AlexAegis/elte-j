import java.util.Calendar;

import Exceptions.EmptyNameException;
import Exceptions.IllegalBirthYearException;

public class Person {

    private Name name;
    private Gender gender;
    private int birthYear;
    private final String DELIMITER = ", ";
    private final int AGETHRESHOLD = 18;

    public Person(Name name, Gender gender, int birthYear) throws IllegalBirthYearException {
        this.name = name;
        this.gender = gender;
        if(birthYear >= 1880 || birthYear <= Calendar.getInstance().get(Calendar.YEAR)) {
            this.birthYear = birthYear;
        } else {
            throw new IllegalBirthYearException();
        }

    }

    public Name getName() {
        return this.name;
    }

    public static Person makePerson(Name name, Gender gender, int birthYear) throws IllegalBirthYearException {
        return new Person(name, gender, birthYear);
    }

    public Person show() {
        System.out.println(this.toString());
        return this;
    }

    public boolean isAdult() {
        return (Calendar.getInstance().get(Calendar.YEAR) - this.birthYear) > AGETHRESHOLD;
    }

    @Override
    public String toString() {
        return this.name.toString() + DELIMITER + this.gender.getValue() + DELIMITER + this.birthYear;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person &&
                obj.toString().equals(this.toString());
    }

}
