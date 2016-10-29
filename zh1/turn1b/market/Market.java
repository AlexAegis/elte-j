package market;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Market {

    private List<Fruit> fruits = new LinkedList<>();

    public Market(String fileName) {
        try(Scanner scn = new Scanner(new File(fileName))) {
            while(scn.hasNextLine()) {
                String[] line = scn.next().trim().split(",");
                if(line.length == 2
                        && line[1].chars().allMatch(Character::isDigit)) {
                    Fruit result = Fruit.make(line[0], Integer.parseInt(line[1]));
                    if(result != null) {
                        fruits.add(result);
                    }
                }
            }
        } catch (FileNotFoundException e) {
        }
    }

    public int numberOfFruits() {
        return fruits.size();
    }

    public Fruit buyCheapestFruit() {
        Fruit cheapest = fruits.stream().min((a, b) -> {
            if(a.cheaperThan(b)) return -1;
            else if(b.cheaperThan(a)) return 1;
            else return 0;
        }).orElse(null);
        fruits.remove(cheapest);
        return cheapest;
    }

    public LinkedList<Fruit> sale() {
        LinkedList<Fruit> result = new LinkedList<>();
        while(!fruits.isEmpty()) {
            result.add(buyCheapestFruit());
        }
        return result;
    }

    public LinkedList<Fruit> cheaperThan(Fruit fruit) {
        return new LinkedList<>(fruits.stream().filter(f -> f.cheaperThan(fruit)).collect(Collectors.toList()));
    }

    public double average() {
        return fruits.stream().mapToDouble(Fruit::getPrice).average().orElse(-1);
    }

    public String show() {
        String result = "";
        for(Fruit fruit : fruits) {
            result = result.concat(fruit.show() + "\n");
        }
        return result.toCharArray().length > 2 ? result.substring(0, result.length() - 1) : "";
    }
}