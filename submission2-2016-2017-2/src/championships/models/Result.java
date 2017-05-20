package championships.models;

public class Result implements Comparable<Result> {

    private Category category;
    private Swimmer swimmer;
    private int score;

    public Result(Category category, Swimmer swimmer, int score) {
        this.category = category;
        this.swimmer = swimmer;
        this.score = score;
    }

    public Category getCategory() {
        return category;
    }

    public Swimmer getSwimmer() {
        return swimmer;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Result{" +
                "category=" + category +
                ", swimmer=" + swimmer +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Result o) {
        return score - o.getScore();
    }
}