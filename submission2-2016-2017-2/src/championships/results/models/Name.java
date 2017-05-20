package championships.results.models;

import championships.results.competitions.Validable;

import java.util.Arrays;

public enum Name implements Validable<String> {
    ANY;

    @Override
    public boolean valid(String name) {
        String[] split = name.split(" ");
        return split.length == 2
                && Arrays.stream(split).allMatch(s -> s.chars().allMatch(Character::isLetter))
                && Arrays.stream(split).allMatch(s -> Character.isUpperCase(s.toCharArray()[0]));
    }
}
