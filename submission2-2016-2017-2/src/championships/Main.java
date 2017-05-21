package championships;

import championships.results.Factory;
import championships.results.Results;
import championships.results.ranking.Ranking;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Results results = Factory.createResults();
        results.readFromFile("resources/input.txt");
        results.rankNationsByGoldFirst().printRankingToFile("goldFirstOutput.txt");
        results.rankNationsByTotalMedals().printRankingToFile("totalMedalsOutput.txt");


        results.addResult("50 m gyors", "Asd Asd", "Magyarorszag", 1);
        results.addResult("50 m freestyle", "Asd Asd", "USA", 2);
        results.addResult("50 m gyors", "Asd Asd", "Egyesult Allamok", 3);
        //results.addResult("200 m gyors", "Asd Asd", "Egyesult Allamok", 1);
        //results.addResult("100 m gyors", "Asd Asd", "Egyesult Allamok", 1);


        Ranking ranking1 = results.rankNationsByGoldFirst();
        Ranking ranking2 = results.rankNationsByTotalMedals();
        System.out.println(ranking1.getPointsOfAll());
        System.out.println(ranking1.getTop3());
        System.out.println(ranking2.getPointsOfAll());
        System.out.println(ranking2.getTop3());


        System.out.println(ranking1.getPointsOf("magyarország"));     //  <1, 0, 0>
        System.out.println(ranking1.getPointsOf("usa")); //  <0, 1, 1>
        System.out.println(ranking1.getRanking());     // [Magyarorszag, Egyesult Allamok]
        System.out.println(ranking1.getPointsOfAll());
    }
}