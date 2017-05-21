package championships.competitions;

import championships.competitions.swimming.Swimming;
import championships.competitions.swimming.SwimmingMedals;
import championships.results.ranking.Medals;

public class SwimmerRankingByMedals extends SwimmerRanking<Medals> {

    public SwimmerRankingByMedals(Swimming results) {
        super(results);
    }

    @Override
    public Medals getPointsOf(String nation) {
        return new SwimmingMedals(results, nation);
    }
}