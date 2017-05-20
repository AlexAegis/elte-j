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
        return createSwimmer(name, Country.getCountry(country));
    }

    public static Swimmer createSwimmer(String name, Country country) {
        if(Name.ANY.valid(name)) return new Swimmer(name, country);
        else return null;
    }

    @Override
    public String getName() {
        return country.getRepresentation();
    }

    @Override
    public String getNation() {
        return name;
    }
}