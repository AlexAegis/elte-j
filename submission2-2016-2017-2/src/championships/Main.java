package championships;

import championships.results.Factory;
import championships.results.Results;
import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Results results = Factory.createResults(); // Swimming
        results.readFromFile("resources/input.txt");
        Ranking<Medals> ranking = results.rankNationsByGoldFirst();
        results.addResult("gyors 50m", "x", "Magyarország", 1);
        results.addResult("gyors 50m", "y", "USA", 2);
        results.addResult("gyors 50m", "z", "USA", 3);
        System.out.println(ranking.getPointsOf("Magyarország"));    //  <1, 0, 0>
        System.out.println(ranking.getPointsOf("USA"));             //  <0, 1, 1>
        System.out.println(ranking.getRanking());                          // [Magyarország, USA]

    }

}