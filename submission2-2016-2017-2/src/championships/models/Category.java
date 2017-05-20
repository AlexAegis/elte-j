package championships.models;

import championships.competitions.Gender;
import championships.competitions.Length;
import championships.competitions.SwimCategory;
import championships.competitions.Validable;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (length != category.length) return false;
        if (gender != category.gender) return false;
        return swimCategory == category.swimCategory;
    }

    @Override
    public int hashCode() {
        int result = length != null ? length.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (swimCategory != null ? swimCategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return length + " " + gender + (gender != null ? " " : "") + swimCategory;
    }
}