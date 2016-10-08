package tests;

import java.util.Scanner;
import csv.CSV;
import utest.*;

public class CSVTest extends Testable {
    public void assertion() {
        String sample =
          "One, Two , Three, Four,Five\n" +
          " 1, 2 ,  3 , 4\n" +
          "This is something longer., lulz, Yet another long string...  \n";
        Scanner sc = new Scanner(sample);
        CSV csv = CSV.read(sc);
        String[][] contents = csv.getContents();
        check("read(): Nem jo mennyisegu sort olvas be.", contents.length == 3);
        check("read(): A mezok szelerol nincsenek leszedve a szokozok.", contents[1][2].equals("3"));
        check("read(): Nem jol dolgozza fel az egyes sorokat.",
          contents[0].length == 5 && contents[1].length == 4 && contents[2].length == 3);
        contents[0][0] = "Yikes!";
        check("getContents(): Nem masolja le a belso allapotot.",
          !csv.getContents()[0][0].equals("Yikes!"));
    }

    public String description() { return "csv.CSV"; }
    public String className() { return "csv.CSV"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { staticMethod(className() + ".read", Scanner.class)
        , method(className() + ".getContents")
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new CSVTest());
    }
}
