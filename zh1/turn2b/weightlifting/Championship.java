package weightlifting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Championship {

    private List<WeightLifter> weightLifters = new LinkedList<>();

    public Championship(String fileName) {
        try(Scanner scn = new Scanner(new File(fileName))) {
            while(scn.hasNextLine()) {
                String[] line = scn.nextLine().trim().split(":");
                if(line.length == 2
                        && !line[0].isEmpty()
                        && line[1].chars().allMatch(Character::isDigit)
                        && WeightLifter.make(line[0], Integer.parseUnsignedInt(line[1])) != null) {
                    weightLifters.add(WeightLifter.make(line[0], Integer.parseUnsignedInt(line[1])));
                }
            }
        } catch (FileNotFoundException e) {

        }
    }

    public int numberOfWeightLifters() {
        return weightLifters.size();
    }

    public String show() {
        String result = "";
        for(WeightLifter weightLifter : weightLifters) {
            result = result.concat(weightLifter.show() + "\n");
        }
        return result.toCharArray().length > 2 ? result.substring(0, result.length() - 1) : "";
    }

    public LinkedList<WeightLifter> strongerThan(WeightLifter weightLifter) {
        return new LinkedList<>(weightLifters.stream().filter(f -> f.strongerThan(weightLifter)).collect(Collectors.toList()));
    }

    public double average() {
        return weightLifters.stream().mapToDouble(WeightLifter::getWeight).average().orElse(-1);
    }

    public WeightLifter round() {
        WeightLifter cheapest = weightLifters.stream().min((a, b) -> {
            if(a.strongerThan(b)) return 1;
            else if(b.strongerThan(a)) return -1;
            else return 0;
        }).orElse(null);
        weightLifters.remove(cheapest);
        return cheapest;
    }

    public LinkedList<WeightLifter> championship() {
        LinkedList<WeightLifter> result = new LinkedList<>();
        while(!weightLifters.isEmpty()) {
            result.add(round());
        }
        return result;
    }
}