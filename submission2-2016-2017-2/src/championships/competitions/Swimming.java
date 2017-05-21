package championships.competitions;

import championships.models.*;
import championships.results.Participant;
import championships.results.Results;
import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Swimming implements Results {

    private List<Result> results = new ArrayList<>();

    @Override
    public void addResult(String event, String name, String nation, int place) throws IllegalArgumentException {
        Swimmer swimmer = Swimmer.createSwimmer(name, nation);
        if(swimmer == null) throw new IllegalArgumentException("invalid swimmer");
        else addResult(event, swimmer, place);
    }

    @Override
    public void addResult(String event, Participant participant, int place) throws IllegalArgumentException {
        Category category = Category.createCategory(event);
        if(category == null) throw new IllegalArgumentException();
        if(results.stream()
                .filter(result -> result.getCategory().equals(category))
                .anyMatch(result -> result.getScore() == place)) {
            throw new IllegalArgumentException(place + " already occupied in " + event);
        }
        if(place <= 0) throw new IllegalArgumentException("place cannot be negative");
        else results.add(new Result(Category.createCategory(event), participant, place));
    }

    @Override
    public List<Participant> getResultsOf(String event) {
        return results.stream()
                .filter(result -> result.getCategory().equals(Category.createCategory(event)))
                .sorted()
                .map(Result::getParticipant)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Participant>> getResultsOfAll() {
        return getAllEvents().stream().collect(Collectors.toMap(s -> s, this::getResultsOf));
    }

    @Override
    public Ranking<Integer> rankNationsByTotalMedals() {
        return new SwimmerScoreRanking(this);
    }

    @Override
    public Ranking<Medals> rankNationsByGoldFirst() {
        return new SwimmerMedalRanking(this);
    }

    public List<Result> getResultsByNation(String nation) {
        return results.stream()
                .filter(result -> result.getParticipant().getNation().equals(nation))
                .collect(Collectors.toList());
    }

    public List<String> getAllEvents() {
        return results.stream()
                .map(Result::getCategory)
                .distinct()
                .map(Category::toString)
                .collect(Collectors.toList());
    }

    public List<Participant> getParticipants() {
        return results.stream().map(Result::getParticipant).distinct().collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    public void readFromFile(String filename) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new File(filename))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                if(!line.startsWith("//") && split.length == 4 && split[3].chars().allMatch(Character::isDigit)) {
                    try {
                        addResult(split[0], split[1], split[2], Integer.parseInt(split[3]));
                    } catch (IllegalArgumentException e) {
                        //e.printStackTrace();
                    }

                }
            }
        }
    }
}