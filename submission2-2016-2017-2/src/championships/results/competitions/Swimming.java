package championships.results.competitions;

import championships.results.Participant;
import championships.results.Results;
import championships.results.models.Name;
import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
                String[] splittedLine = line.split(";");
                if(!line.startsWith("//")
                        && splittedLine.length == 4
                        && validateCategory(splittedLine[0])
                        && Name.ANY.valid(splittedLine[1])
                        && splittedLine[2].chars().allMatch(Character::isLetter)
                        && splittedLine[3].chars().allMatch(Character::isDigit)) {
                    System.out.println(splittedLine[0]);
                    System.out.println(splittedLine[1]);
                    System.out.println(splittedLine[2]);
                    System.out.println(splittedLine[3]);
                }
            }
        }
    }

    /**
     *
     * @param string the input
     * @return
     */
    private boolean validateCategory(String string) {
        String[] split = string.split(" ");
        return split.length >= 3 && Length.ANY.valid(split[0] + " " + split[1])
                    && ((split.length == 3 && SwimCategory.ANY.valid(split[2]))
                        || (split.length == 4 && Gender.ANY.valid(split[2]) && SwimCategory.ANY.valid(split[3])));
    }
}
