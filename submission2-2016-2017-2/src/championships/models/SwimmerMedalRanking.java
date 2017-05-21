package championships.models;

import championships.competitions.Swimming;
import championships.results.ranking.Medals;

public class SwimmerMedalRanking extends SwimmerRanking<Medals> {

    public SwimmerMedalRanking(Swimming results) {
        super(results);
    }

    @Override
    public Medals getPointsOf(String nation) {
        return new SwimmingMedals(results, nation);
    }

}