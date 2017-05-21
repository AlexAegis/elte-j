package championships.competitions.swimming;

import championships.models.Category;
import championships.results.Participant;

public class SwimmingResult implements Comparable<SwimmingResult> {

    private Category category;
    private Participant participant;
    private int score;

    SwimmingResult(Category category, Participant participant, int score) {
        this.category = category;
        this.participant = participant;
        this.score = score;
    }

    Category getCategory() {
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
        return category + ";" + participant + ";" + score;
    }

    @Override
    public int compareTo(SwimmingResult o) {
        return getScore() - o.getScore();
    }
}