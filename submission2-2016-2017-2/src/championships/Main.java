package championships;

import championships.results.Factory;
import championships.results.Results;
import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        Results results = Factory.createResults(); // Swimming
        //results.readFromFile("resources/input.txt");
        Ranking<Medals> ranking = results.rankNationsByGoldFirst();
        results.addResult("50 m gyors", "Asd Asd", "Magyarorszag", 1);
        results.addResult("50 m gyors", "Asd Asd", "Egyesult Allamok", 2);
        results.addResult("50 m gyors", "Asd Asd", "Egyesult Allamok", 3);
        System.out.println(ranking.getPointsOf("Magyarorszag"));    //  <1, 0, 0>
        System.out.println(ranking.getPointsOf("Egyesult Allamok"));             //  <0, 1, 1>
        System.out.println(ranking.getRanking());                          // [Magyarország, USA]
        ranking.getNations().forEach(System.out::println);

    }

}