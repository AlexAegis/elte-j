package tests;

import company.Company;
import utest.*;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Part5 extends Testable {
    public void assertion() {
        String abigail = "Abigail";
        String bob = "Bob";
        String chris = "Chris";
        String jackie = "Jackie";
        String james = "James";
        String sophia = "Sophia";

        try {
            Company c = new Company("Aperture Science", "company.txt");

            List<String> bosses = new LinkedList<>();
            bosses.add(jackie);
            bosses.add(sophia);

            List<String> actualBosses = c.bosses();

            check("Company.bosses: null az eredmeny.", actualBosses != null);
            Collections.sort(actualBosses);
            check("Company.bosses: nem adja vissza a fonokok listajat.", bosses.equals(actualBosses));

            check("Company.bestBoss: nem azt a fonokot adja vissza, melynek legtobb kozvetlen beosztottja van.", jackie.equals(c.bestBoss()));
        } catch (Throwable e) {
            check("Company konstruktora kivetelt dobott. Talan nem jo helyre lett masolva a company.txt?", false);
        }
    }

    public String description() { return "5. resz"; }
    public String className() { return "company.Company"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class, String.class})
            , optionalMethod(className() + ".toString")
            , optionalMethod(className() + ".employeesOf", String.class)
            , optionalMethod(className() + ".employees")
            , method(className() + ".bosses")
            , method(className() + ".bestBoss")
            };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new Part5());
    }
}
