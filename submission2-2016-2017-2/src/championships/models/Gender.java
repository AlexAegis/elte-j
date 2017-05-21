package championships.models;

import java.util.Arrays;

public enum Gender implements Validable<String> {
    MALE("ferfi", "male", "férfi"),
    FEMALE("noi", "female", "női"),
    ANY("");

    public static Gender getGender(String s) {
        return Arrays.stream(values())
                .filter(o -> Arrays.stream(o.getRepresentation()).anyMatch(s.toLowerCase()::equals))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private String[] representation;

    Gender(String... representation) {
        this.representation = representation;
    }

    public String[] getRepresentation() {
        return representation;
    }

    /**
     * Validator, if called on an ANY it iterates through all the others
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