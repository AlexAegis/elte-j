package championships.models;

import championships.competitions.Swimming;

public class SwimmerScoreRanking extends SwimmerRanking<Integer> {

    public SwimmerScoreRanking(Swimming results) {
        super(results);
    }

    @Override
    public Integer getPointsOf(String nation) {
        return results.getResults().stream()
                .filter(result -> result.getParticipant().getNation().equals(nation))
                .mapToInt(Result::getScore).sum();
    }
}