package championships.results.competitions;

public enum Gender implements Validable<String>{
    MALE("ferfi"),
    FEMALE("noi");

    private String representation;

    Gender(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public boolean valid(String gender) {
        return gender.chars().allMatch(Character::isLetter)
                && getRepresentation().equals(gender);
    }
}