package championships.results.models;

import championships.results.competitions.Gender;
import championships.results.competitions.Length;
import championships.results.competitions.SwimCategory;
import championships.results.competitions.Validable;

public class Category implements Validable<String> {

    private Length length;
    private Gender gender;
    private SwimCategory swimCategory;

    public Category(Length length, Gender gender, SwimCategory swimCategory) {
        this(length, swimCategory);
        this.gender = gender;
    }

    public Category(Length length, SwimCategory swimCategory) {
        this.length = length;
        this.swimCategory = swimCategory;
    }

    private Category() {

    }

    public static Category createCategory(String s) {
        if(!new Category().valid(s)) return null;
        String[] split = s.split(" ");
        if(split.length == 3)
            return new Category(Length.getLength(split[0] + " " + split[1]), SwimCategory.getSwimCategory(split[2]));
        else if(split.length == 4)
            return new Category(Length.getLength(split[0] + " " + split[1]), Gender.getGender(split[2]), SwimCategory.getSwimCategory(split[3]));
        else return null;
    }

    @Override
    public boolean valid(String string) {
        String[] split = string.split(" ");
        return split.length >= 3 && Length.ANY.valid(split[0] + " " + split[1])
                && ((split.length == 3 && SwimCategory.ANY.valid(split[2]))
                || (split.length == 4 && Gender.ANY.valid(split[2]) && SwimCategory.ANY.valid(split[3])));
    }

    @Override
    public String toString() {
        return "Category{" +
                "length=" + length +
                ", gender=" + gender +
                ", swimCategory=" + swimCategory +
                '}';
    }
}