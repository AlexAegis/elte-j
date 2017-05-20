package championships.results.competitions;

public enum Length implements Validable<String> {
    FIFTY("50 m"),
    ONEHUNDRED("100 m"),
    TWOHUNDRED("200 m"),
    FOURHUNDRED("400 m"),
    FIVEHUNDRED("500 m");

    private String representation;

    Length(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public boolean valid(String length) {
        return  length.split(" ").length == 2
                && length.split(" ")[0].chars().allMatch(Character::isDigit)
                && length.split(" ")[1].equals("m")
                && getRepresentation().equals(length);
    }
}