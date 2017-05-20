package championships.results.competitions;

import championships.results.Participant;
import championships.results.models.Category;
import championships.results.models.Result;
import championships.results.Results;
import championships.results.models.Country;
import championships.results.models.Name;
import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Swimming implements Results {

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
                if(!line.startsWith("//")
                        && split.length == 4
                        && Name.ANY.valid(split[1])
                        && Country.ANY.valid(split[2])
                        && split[3].chars().allMatch(Character::isDigit)) {
                    Category category = Category.createCategory(split[0]);
                    if (category != null) {
                        Result result = new Result(category, split[1], Country.getCountry(split[2]), Integer.parseInt(split[3]));
                        System.out.println(result.toString());
                    }

                }
            }
        }
    }

}
