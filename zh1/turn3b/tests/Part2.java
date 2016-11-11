package tests;

import raffle.Destination;
import raffle.Raffle;
import java.io.*;
import utest.*;

public class Part2 extends Testable {
    public void assertion() throws Exception {
        Raffle r1 = new Raffle("badfilename.txt");
        check("Raffle konstruktora: hibas filenev eseten nem ures listaval inicilaizalta az autokolcsonzot.", r1.numberOfDestinations() == 0);
        Raffle r2 = new Raffle("destinations.txt");
        check("Raffle konstruktora: nem megfelelo mennyisegu adatot olvasott be.", r2.numberOfDestinations() == 6);		
        check("Raffle.toString(): rosszul jeleniti meg az objektumot, ha nincsenek autok.", r1.toString().equals(""));
        check("Raffle: vagy a konstruktor rogzit hibas adatokat, vagy a toString() metodus jeleniti meg oket rosszul.", r2.toString().equals("Barcelona 2017/02/27 (4400 EUR)\nBudapest 2017/07/25 (8 EUR)\nMiami 2017/05/30 (7500 EUR)\nPozsony 2017/06/15 (900 EUR)\nSzkopje 2017/08/13 (97 EUR)\nNew York 2017/12/31 (7500 EUR)"));
    }
		
    public String description() { return "2. resz"; }
    public String className() { return "raffle.Raffle"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class})
            , method(className() + ".numberOfDestinations")
            , method(className() + ".toString")
            , optionalMethod(className() + ".insertionSort")
            , optionalMethod(className() + ".weightedAverage")
            , optionalMethod(className() + ".raffle")
            , optionalMethod(className() + ".simulate")
            };
    }

    public static void main(String... args) {
        Test.main(new Part2());
    }
}
