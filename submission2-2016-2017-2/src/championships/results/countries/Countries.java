package championships.results.countries;

import championships.results.competitions.Validable;

public enum Countries implements Validable<Countries> {
    UNITEDSTATES("Egyesult Allamok"),
    HUNGARY("Magyarorszag"),
    FRANCE("Franciaorszag");

    private String representation;

    Countries(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public boolean valid(Countries object) {
        return representation.equals(object.getRepresentation());
    }
}