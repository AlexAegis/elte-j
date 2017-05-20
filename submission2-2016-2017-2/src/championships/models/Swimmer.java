package championships.models;


import championships.results.Participant;

public class Swimmer implements Participant {

    private String name;
    private Country country;

    public Swimmer(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public static Swimmer createSwimmer(String name, String country) {
        try {
            return createSwimmer(name, Country.getCountry(country));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static Swimmer createSwimmer(String name, Country country) {
        if(Name.ANY.valid(name)) return new Swimmer(name, country);
        else return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNation() {
        return country.toString();
    }

    @Override
    public String toString() {
        return "Swimmer{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Swimmer swimmer = (Swimmer) o;

        if (name != null ? !name.equals(swimmer.name) : swimmer.name != null) return false;
        return country == swimmer.country;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}