package championships.results;

import org.junit.Test;

public class ResultsTest {

    Results swimming = Factory.createResults();

    @Test
    public void categoryValidatorTest() throws Exception {
        swimming.readFromFile("resources/input.txt");
        swimming.getResultsOf("200 m ferfi pillango").forEach(System.out::println);

        swimming.getResultsOf("200 m noi hat").forEach(System.out::println);

        swimming.getResultsOfAll().forEach((a, b) -> {
            System.out.println(a);
            System.out.println(b.size());
            b.forEach(System.out::print);
        });
    }
}