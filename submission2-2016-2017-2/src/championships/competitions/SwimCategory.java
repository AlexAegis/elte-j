package championships.competitions;

import java.util.Arrays;

public enum SwimCategory implements Validable<String> {
    FREESTYLE("gyors", "freestyle"),
    BUTTERFLYSTROKE("pillango", "butterfly stroke"),
    MEDLEY("vegyes", "medley"),
    BACK("hat", "back"),
    ANY("");

    private String[] representation;

    SwimCategory(String... representation) {
        this.representation = representation;
    }

    public static SwimCategory getSwimCategory(String s) {
        return Arrays.stream(values())
                .filter(o -> Arrays.stream(o.getRepresentation()).anyMatch(s::equals))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
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