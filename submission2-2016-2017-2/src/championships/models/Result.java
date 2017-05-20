package championships.models;

import championships.results.Participant;

public class Result implements Comparable<Result> {

    private Category category;
    private Participant participant;
    private int score;

    public Result(Category category, Participant participant, int score) {
        this.category = category;
        this.participant = participant;
        this.score = score;
    }

    public Category getCategory() {
        return category;
    }

    public Participant getParticipant() {
        return participant;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Result{" +
                "category=" + category +
                ", participant=" + participant +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Result o) {
        return o.getScore() - score;
    }
}