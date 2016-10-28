package tests;

import rail.Railway;
import utest.*;

import java.util.Arrays;

public class Part1 extends Testable {
    public void assertion() {
        final int dist = 50;
        Railway r = new Railway("Salakszentmotoros", "Felsozsebalso", dist);
        String[] cities = r.getCities();
        Arrays.sort(cities);
        check("Railway.getCities(): nem tartalmazza a helyes varosokat.", Arrays.equals(cities, new String[]{"Felsozsebalso", "Salakszentmotoros"}));
        check("Railway.getDistance(): nem adja vissza a helyes tavolsagot.", r.getDistance() == dist);
    }

    public String description() { return "1. resz"; }
    public String className() { return RailwayApi.className; }

    public Object[] expectedMethods() throws Exception {
        return RailwayApi.expectedMethods();
    }

    public Object[] expectedFields() throws Exception {
        return RailwayApi.expectedFields();
    }

    public static void main(String... args) {
        Test.main(new Part1());
    }
}
