package championships.results.competitions;

public enum SwimCategory implements Validable<String> {
    FREESTYLE("gyors"),
    BUTTERFLYSTROKE("pillango"),
    MEDLEY("vegyes"),
    BACK("hat");

    private String representation;

    SwimCategory(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }


    @Override
    public boolean valid(String swimCategory) {
        return swimCategory.chars().allMatch(Character::isLetter)
                && getRepresentation().equals(swimCategory);
    }
}