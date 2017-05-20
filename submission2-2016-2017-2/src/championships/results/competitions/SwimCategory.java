package championships.results.competitions;

import java.util.Arrays;

public enum SwimCategory implements Validable<String> {
    FREESTYLE("gyors"),
    BUTTERFLYSTROKE("pillango"),
    MEDLEY("vegyes"),
    BACK("hat"),
    ANY("");

    public static SwimCategory getSwimCategory(String s) {
        return Arrays.stream(values())
                .filter(gender -> gender.getRepresentation().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
    private String representation;

    SwimCategory(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    /**
     * Validator, if called on an ANY it iterates through all the others
     * @param s input
     * @return true if its matches any of the categories
     */
    @Override
    public boolean valid(String s) {
        return equals(ANY) ? Arrays.stream(values()).anyMatch(sw -> !sw.equals(ANY) && sw.valid(s))
                : s.chars().allMatch(Character::isLetter) && getRepresentation().equals(s);
    }
}