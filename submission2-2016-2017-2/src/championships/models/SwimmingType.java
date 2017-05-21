package championships.models;

import java.util.Arrays;

public enum SwimmingType implements Validable<String> {
    FREESTYLE("gyors", "freestyle"),
    BUTTERFLYSTROKE("pillango", "butterfly stroke"),
    MEDLEY("vegyes", "medley"),
    BACK("hat", "back"),
    ANY("");

    private String[] representation;

    SwimmingType(String... representation) {
        this.representation = representation;
    }

    public static SwimmingType getSwimCategory(String s) {
        return Arrays.stream(values())
                .filter(o -> Arrays.stream(o.getRepresentation()).anyMatch(s::equals))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String[] getRepresentation() {
        return representation;
    }

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