package championships.results.competitions;

public class Name implements Validable<String> {

    @Override
    public boolean valid(String name) {
        return name.chars().allMatch(Character::isLetter);
    }
}
