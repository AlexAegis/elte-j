package championships;

import championships.results.Factory;
import championships.results.Results;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Results results = Factory.createResults();
        results.readFromFile("resources/input.txt");
        results.rankNationsByGoldFirst().printRankingToFile("goldFirstOutput.txt");
        results.rankNationsByTotalMedals().printRankingToFile("totalMedalsOutput.txt");
        //results.addResult("50 m gyors", "Asd Asd", "Magyarorszag", 1);
        //results.addResult("50 m gyors", "Asd Asd", "Egyesult Allamok", 2);
        //results.addResult("50 m gyors", "Asd Asd", "Egyesult Allamok", 3);
        //System.out.println(ranking.getPointsOf("Magyarorszag"));    //  <1, 0, 0>
        //System.out.println(ranking.getPointsOf("Egyesult Allamok"));             //  <0, 1, 1>
       // System.out.println(ranking.getRanking());                          // [Magyarország, USA]
    }
}