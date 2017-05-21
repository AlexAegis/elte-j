package championships.models;


import championships.results.Participant;

public class Swimmer implements Participant {

    private String name;
    private Nation nation;

    public Swimmer(String name, Nation nation) {
        this.name = name;
        this.nation = nation;
    }

    public static Swimmer createSwimmer(String name, String country) throws IllegalArgumentException {
        return createSwimmer(name, Nation.getCountry(country));
    }

    public static Swimmer createSwimmer(String name, Nation nation) {
        if(Name.ANY.valid(name)) return new Swimmer(name, nation);
        else return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNation() {
        return nation.toString();
    }

    @Override
    public String toString() {
        return "Swimmer{" +
                "name='" + name + '\'' +
                ", nation=" + nation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Swimmer swimmer = (Swimmer) o;

        if (name != null ? !name.equals(swimmer.name) : swimmer.name != null) return false;
        return nation == swimmer.nation;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        return result;
    }
}