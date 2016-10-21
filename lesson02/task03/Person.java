import java.util.Calendar;

class Person {

    Name name;
    Gender gender;
    int birthYear;

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

}
