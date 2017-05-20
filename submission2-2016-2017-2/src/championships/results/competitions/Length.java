package championships.results.competitions;

import java.util.Arrays;

public enum Length implements Validable<String> {
    FIFTY("50 m"),
    ONEHUNDRED("100 m"),
    TWOHUNDRED("200 m"),
    FOURHUNDRED("400 m"),
    FIVEHUNDRED("500 m"),
    ANY("");

    public static Length getLength(String s) {
        return Arrays.stream(values())
                .filter(gender -> gender.getRepresentation().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private final String M = "m";
    private final String SPACE = " ";

    private String representation;

    Length(String representation) {
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
        String[] split = s.split(SPACE);
        return equals(ANY) ? Arrays.stream(values()).anyMatch(l -> !l.equals(ANY) && l.valid(split[0] + SPACE + split[1]))
                : split.length == 2
                    && split[0].chars().allMatch(Character::isDigit)
                    && split[1].equals(M)
                    && getRepresentation().equals(s);
    }
}