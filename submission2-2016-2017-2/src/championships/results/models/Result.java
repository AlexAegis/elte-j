package championships.results.models;

public class Result implements Comparable<Result> {

    private Category category;
    private String name;
    private Country country;
    private int score;

    public Result(Category category, String name, Country country, int score) {
        this.category = category;
        this.name = name;
        this.country = country;
        this.score = score;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Result{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Result o) {
        return score - o.getScore();
    }
}