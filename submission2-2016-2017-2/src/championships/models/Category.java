package championships.models;

public class Category implements Validable<String> {

    private Length length;
    private Gender gender;
    private SwimmingType swimmingType;

    private Category(Length length, Gender gender, SwimmingType swimmingType) {
        this(length, swimmingType);
        this.gender = gender;
    }

    private Category(Length length, SwimmingType swimmingType) {
        this.length = length;
        this.swimmingType = swimmingType;
    }

    public static Category createCategory(String s) {
        if(!new Category(Length.ANY, SwimmingType.ANY).valid(s)) return null;
        String[] split = s.split(" ");
        if(split.length == 3)
            return new Category(Length.getLength(split[0] + " " + split[1]), SwimmingType.getSwimCategory(split[2]));
        else if(split.length == 4)
            return new Category(Length.getLength(split[0] + " " + split[1]), Gender.getGender(split[2]), SwimmingType.getSwimCategory(split[3]));
        else return null;
    }

    @Override
    public boolean valid(String string) {
        String[] split = string.split(" ");
        return split.length >= 3 && Length.ANY.valid(split[0] + " " + split[1])
                && ((split.length == 3 && SwimmingType.ANY.valid(split[2]))
                || (split.length == 4 && Gender.ANY.valid(split[2]) && SwimmingType.ANY.valid(split[3])));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return length == category.length && gender == category.gender && swimmingType == category.swimmingType;
    }

    @Override
    public int hashCode() {
        int result = length != null ? length.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (swimmingType != null ? swimmingType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return length + " " + gender + (gender != null ? " " : "") + swimmingType;
    }
}