package tests;

import rail.RailMap;
import utest.*;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

import java.io.IOException;

public class Part3 extends Testable {
    public void assertion() throws IOException {
        RailMap r = new RailMap("Magyarorszag", "railmap.txt");
        List<String> expectedCities = new LinkedList<>();
        expectedCities.add("Szigliget");
        expectedCities.add("Salakszentmotoros");
        expectedCities.add("Bubanatvolgy");
        expectedCities.add("Budapest");
        expectedCities.add("Siofok");
        expectedCities.add("Keszthely");

        List<String> actualCities = r.getCities();
        Collections.sort(expectedCities);

        check("RailMap.getCities(): null az eredmeny.", actualCities != null);
        Collections.sort(actualCities);

        check("RailMap.getCities(): nem adja vissza az osszes varost.", expectedCities.equals(actualCities));
    }

    public String description() { return "3. resz"; }
    public String className() { return RailMapApi.className; }

    public Object[] expectedMethods() throws Exception {
        return RailMapApi.expectedMethods();
    }

    public Object[] expectedFields() throws Exception {
        return RailMapApi.expectedFields();
    }

    public static void main(String... args) {
        Test.main(new Part2());
    }
}
