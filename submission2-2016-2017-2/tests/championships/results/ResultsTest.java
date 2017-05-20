package championships.results;

import org.junit.Test;

public class ResultsTest {

    Results swimming = Factory.createResults();

    @Test
    public void categoryValidatorTest() throws Exception {
        swimming.readFromFile("resources/input.txt");
    }
}
