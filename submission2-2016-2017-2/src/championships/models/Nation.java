package championships.models;

import championships.competitions.Validable;

import java.util.Arrays;

public enum Nation implements Validable<String> {
    USA("egyesult allamok", "egyesült államok", "united states", "usa"),
    HUNGARY("magyarorszag", "magyarország", "hungary"),
    FRANCE("franciaorszag", "franciaország", "france"),
    ANY("");

    public static Nation getCountry(String s) {
        return Arrays.stream(values())
                .filter(o -> Arrays.stream(o.getRepresentation()).anyMatch(s.toLowerCase()::equals))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private String[] representation;

    Nation(String... representation) {
        this.representation = representation;
    }

    public String[] getRepresentation() {
        return representation;
    }

    /**
     * Validator, if called on an ANY it iterates through all the others
     * Remove comment to only allow items in the enumeration
     * @param s input
     * @return true if its matches any of the categories
     */
    @Override
    public boolean valid(String s) {
        return equals(ANY) ? Arrays.stream(values()).anyMatch(sw -> !sw.equals(ANY) && sw.valid(s.toLowerCase()))
                : s.chars().allMatch(Character::isLetter) && Arrays.stream(getRepresentation()).anyMatch(s.toLowerCase()::equals);
    }

    @Override
    public String toString() {
        return representation[0];
    }
}