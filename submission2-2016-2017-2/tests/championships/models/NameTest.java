package championships.models;


import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NameTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Takacs Krisztian", true},
                {"Nathan Adrian", true},
                {"Missy Franklin", true},
                {"Hosszu Katinka", true},
                {"Cseh Laszlo", true},
                {"MissyFranklin", false},
                {"missy franklin", false},
                {"Franklin", false},
                {"", false}});
    }


    @Parameter
    public String input;

    @Parameter(1)
    public boolean expected;


    @Test
    public void test() throws Exception {
        Method categoryValidator = Name.class.getDeclaredMethod("valid", String.class);
        categoryValidator.setAccessible(true);
        boolean result = (boolean) categoryValidator.invoke(Name.ANY, input);
        assertEquals("failed assertion on: " + input, expected, result);
    }

}