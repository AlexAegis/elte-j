package tests;

import raffle.Destination;
import raffle.Raffle;
import java.io.*;
import utest.*;

public class Part3 extends Testable {
    public void assertion() throws Exception {
        Raffle r1 = new Raffle("badfilename.txt");
        check("Raffle konstruktora: hibas filenev eseten nem ures listaval inicilaizalta az autokolcsonzot.", r1.numberOfDestinations() == 0);
        Raffle r2 = new Raffle("destinations.txt");
        r1.insertionSort();
        check("Raffle.insertionSort(): nem jol vegzi a rendezest, ha nincsenek varosok", r1.numberOfDestinations() == 0);
        check("Raffle.insertionSort(): nem jol vegzi a rendezest, ha nincsenek autok", r1.toString().equals(""));
        r2.insertionSort();
        check("Raffle.insertionSort(): nem jol vegzi a rendezest, ha vannak varosok a listaban", r2.numberOfDestinations() == 6);
        check("Raffle.insertionSort(): nem jol vegzi a rendezest, ha vannak varosok a listaban", r2.toString().equals("Miami 2017/05/30 (7500 EUR)\nNew York 2017/12/31 (7500 EUR)\nBarcelona 2017/02/27 (4400 EUR)\nPozsony 2017/06/15 (900 EUR)\nSzkopje 2017/08/13 (97 EUR)\nBudapest 2017/07/25 (8 EUR)"));
        check("Raffle.weightedAverage(): nem -1.0-et ad vissza, ha nincsenek varosok.", r1.weightedAverage() == -1.0);
        check("Raffle.weightedAverage(): nem jol szamolja ki a sulyozott atlagot.", r2.weightedAverage() < 3400.834 && r2.weightedAverage() > 3400.832);  
    }
	
    public String description() { return "3. resz"; }
    public String className() { return "raffle.Raffle"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class})
            , method(className() + ".numberOfDestinations")
            , method(className() + ".toString")
            , method(className() + ".insertionSort")
            , method(className() + ".weightedAverage")
            , optionalMethod(className() + ".raffle")
            , optionalMethod(className() + ".simulate")
            };
    }

    public static void main(String... args) {
        Test.main(new Part3());
    }
}
