package championships.competitions;

import championships.competitions.swimming.Swimming;

public class SwimmerRankingByScore extends SwimmerRanking<Integer> {

    public SwimmerRankingByScore(Swimming results) {
        super(results);
    }

    @Override
    public Integer getPointsOf(String nation) {
        return (int) results.getSwimmingResults().stream()
                .filter(result -> result.getParticipant().getNation().equals(nation))
                .filter(result -> result.getScore() <= 3)
                .count();
    }
}