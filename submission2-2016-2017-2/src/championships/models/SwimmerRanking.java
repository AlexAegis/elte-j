package championships.models;

import championships.competitions.Swimming;
import championships.results.Participant;
import championships.results.ranking.Ranking;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class SwimmerRanking<T extends Comparable<T>> implements Ranking<T> {

    protected Swimming results;

    public SwimmerRanking(Swimming results) {
        this.results = results;
    }

    @Override
    public Set<String> getNations() {
        return results.getParticipants().stream()
                .map(Participant::getNation)
                .distinct()
                .collect(Collectors.toSet());
    }

    @Override
    public List<String> getRanking() {
        return results.getResults().stream()
                .sorted()
                .map(result -> result.getParticipant().getNation())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTop3() {
        return getRanking().stream().limit(3).collect(Collectors.toList());
    }

    @Override
    public void printRankingToFile(String filename) throws FileNotFoundException {
        System.out.println("PRINTFILE"); //TODO FINISHME
    }

    @Override
    public Map<String, T> getPointsOfAll() {
        return getNations().stream().collect(Collectors.toMap(s -> s, this::getPointsOf));
    }
}
