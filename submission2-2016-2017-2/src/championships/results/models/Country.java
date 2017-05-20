package championships.results.models;

import championships.results.competitions.Validable;

public enum Country implements Validable<Country> {
    UNITEDSTATES("Egyesult Allamok"),
    HUNGARY("Magyarorszag"),
    FRANCE("Franciaorszag");

    private String representation;

    Country(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public boolean valid(Country object) {
        return representation.equals(object.getRepresentation());
    }
}