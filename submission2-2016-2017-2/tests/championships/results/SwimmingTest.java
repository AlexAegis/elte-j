package championships.results;

import championships.results.competitions.Swimming;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SwimmingTest {

    private Swimming swimming = new Swimming();

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"200 m noi hat", true},
                {"200 m ferfi pillango", true},
                {"200 m vegyes", true},
                {"400 m vegyes", true},
                {"200 m pillango", true},
                {"200 m noi pillango", true},
                {"50 m vegyes", true},
                {"50 m hat", true},
                {"pillango", false},
                {"50 m lango", false},
                {"50 m", false},
                {"51 m noi pillango", false},
                {"m pillango", false},
                {"m ferfi hat", false},
                {"411 m ferfi hat", false},
                {"", false}});
    }

    @Parameter
    public String input;

    @Parameter(1)
    public boolean expected;

    @Test
    public void test() throws Exception {
        Method categoryValidator = Swimming.class.getDeclaredMethod("validateCategory", String.class);
        categoryValidator.setAccessible(true);
        boolean result = (boolean) categoryValidator.invoke(swimming, input);
        assertEquals("failed assertion on: " + input, expected, result);
    }
}