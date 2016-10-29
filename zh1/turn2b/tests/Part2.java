package tests;

import weightlifting.WeightLifter;
import weightlifting.Championship;
import java.io.*;
import utest.*;

import java.util.Arrays;

public class Part2 extends Testable {
    public void assertion() {
        try {
            Championship cs1 = new Championship("badfilename.txt");
            check("Championship konstruktora: hibas filenev eseten nem ures listaval inicilaizalta a versenyzoket.", cs1.numberOfWeightLifters() == 0);
            Championship cs2 = new Championship("weightlifters.txt");
            check("Championship konstruktora: nem megfelelo mennyisegu adatot olvasott be.", cs2.numberOfWeightLifters() == 5);
            check("Chanpionship.show: rosszul jeleniti meg az objektumot, ha nincsenek versenyzok.", cs1.show().equals(""));
            check("Chanpionship: vagy a konstruktor rogzit hibas adatokat, vagy a show metodus jeleniti meg oket rosszul.", cs2.show().equals("Ivan Ivanov - 120 kg\nFoldi Imre - 137 kg\nPablo Lara -  25 kg\nAleksey Petrov -   9 kg\nKoji Miki - 137 kg"));
        } catch (Exception e) {
            e.printStackTrace();
            check("A Championship konstruktora nem engedheti ki a kivetelt a metodusbol", false);
        }
    }

    public String description() { return "2. resz"; }
    public String className() { return "weightlifting.Championship"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class})
            , method(className() + ".numberOfWeightLifters")
            , method(className() + ".show")
            , optionalMethod(className() + ".strongerThan", weightlifting.WeightLifter.class)
            , optionalMethod(className() + ".average")
            , optionalMethod(className() + ".round")
            , optionalMethod(className() + ".championship")
            };
    }

    public static void main(String... args) {
        Test.main(new Part2());
    }
}
