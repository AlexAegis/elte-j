package tests;

import rail.Railway;
import rail.RailMap;
import utest.*;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

import java.io.IOException;

public class Part4 extends Testable {
    public void assertion() throws IOException {
        RailMap r = new RailMap("Magyarorszag", "railmap.txt");
        List<String> budapestNeighbours = new LinkedList<>();
        budapestNeighbours.add("Salakszentmotoros");
        budapestNeighbours.add("Bubanatvolgy");
        budapestNeighbours.add("Keszthely");

        List<String> actualCities = r.getNeighbours(new String("Budapest"));
        Collections.sort(budapestNeighbours);

        check("RailMap.getNeighbours(): null az eredmeny.", actualCities != null);
        Collections.sort(actualCities);

        check("RailMap.getNeighbours(): nem adja vissza Budapest szomszedait.", budapestNeighbours.equals(actualCities));

        List<String> keszthelyNeighbours = new LinkedList<>();
        keszthelyNeighbours.add("Budapest");
            
        actualCities = r.getNeighbours(new String("Keszthely"));
        check("RailMap.getNeighbours(): nem adja vissza Keszthely szomszedait.", keszthelyNeighbours.equals(actualCities));

        check("RailMap.getNeighbours(): Miskolcnak nem szabadna, hogy szomszedai legyenek.", r.getNeighbours(new String("Miskolc")).isEmpty());

        Railway rw = new Railway("Szigliget", "Tapolca", 20);

        check("Railway.toString(): nem kezdodik \"Railway(\"-jel.", rw.toString().startsWith("Railway("));
        check("Railway.toString(): nem tartalmazza az egyik varost.", rw.toString().contains("Szigliget"));
        check("Railway.toString(): nem tartalmazza a masik varost.", rw.toString().contains("Tapolca"));
        check("Railway.toString(): nem tartalmazza a tavolsagot.", rw.toString().contains("20"));

        check("RailMap.toString: nem kezdodik \"RailMap(\"-pal.", r.toString().startsWith("RailMap("));
    }

    public String description() { return "4. resz"; }
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
