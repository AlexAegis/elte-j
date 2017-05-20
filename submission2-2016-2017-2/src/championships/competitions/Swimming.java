package championships.competitions;

import championships.models.*;
import championships.results.Participant;
import championships.results.Results;
import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Swimming implements Results {

    private List<Result> results = new ArrayList<>();

    @Override
    public void addResult(String event, String name, String nation, int place) throws IllegalArgumentException {

    }

    @Override
    public void addResult(String event, Participant participant, int place) throws IllegalArgumentException {

    }

    @Override
    public List<Participant> getResultsOf(String event) {
        return null;
    }

    @Override
    public Map<String, List<Participant>> getResultsOfAll() {
        return null;
    }

    @Override
    public Ranking<Integer> rankNationsByTotalMedals() {
        return null;
    }

    @Override
    public Ranking<Medals> rankNationsByGoldFirst() {
        return null;
    }

    @Override
    public void readFromFile(String filename) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new File(filename))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                if(!line.startsWith("//") && split.length == 4 && split[3].chars().allMatch(Character::isDigit)) {
                    Category category = Category.createCategory(split[0]);
                    Swimmer swimmer = Swimmer.createSwimmer(split[1], split[2]);
                    if (category != null && swimmer != null) {
                        results.add(new Result(category, swimmer, Integer.parseInt(split[3])));
                    }
                }
            }
        }
    }
}