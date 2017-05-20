package championships.results;

import championships.competitions.Length;
import championships.competitions.SwimCategory;
import championships.models.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CategoryTest {

    private static Category category;
    private static Method categoryValidator;

    @Parameter    public String input;
    @Parameter(1) public boolean expected;

    @BeforeClass
    public static void setUp() throws Exception {
        Constructor constructor = Category.class.getConstructor(Length.class, SwimCategory.class);
        constructor.setAccessible(true);
        category = (Category) constructor.newInstance(Length.ANY, SwimCategory.ANY);
        categoryValidator = Category.class.getDeclaredMethod("valid", String.class);
        categoryValidator.setAccessible(true);
    }

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

    @Test
    public void test() throws Exception {
        boolean result = (boolean) categoryValidator.invoke(category, input);
        assertEquals("failed assertion on: " + input, expected, result);
    }
}