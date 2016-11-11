package tests;

import rental.Car;
import rental.CarRental;
import java.io.*;
import utest.*;

public class Part2 extends Testable {
    public void assertion() throws Exception {
        CarRental cr1 = new CarRental("badfilename.txt");
        check("CarRental konstruktora: hibas filenev eseten nem ures listaval inicilaizalta az autokolcsonzot.", cr1.numberOfCars() == 0);
        CarRental cr2 = new CarRental("cars.txt");
        check("CarRental konstruktora: nem megfelelo mennyisegu adatot olvasott be.", cr2.numberOfCars() == 4);
        check("CarRental.toString(): rosszul jeleniti meg az objektumot, ha nincsenek autok.", cr1.toString().equals(""));
        check("CarRental: vagy a konstruktor rogzit hibas adatokat, vagy a toString() metodus jeleniti meg oket rosszul.", cr2.toString().equals("BMW (ABC 123)  50,0 EUR\nAlfa Romeo (DEF 234)   9,0 EUR\nToyota (GHI 456) 500,0 EUR\nVolvo (JSD 856) 500,0 EUR"));
    }
		
    public String description() { return "2. resz"; }
    public String className() { return "rental.CarRental"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class})
            , method(className() + ".numberOfCars")
            , method(className() + ".toString")
            , optionalMethod(className() + ".insertionSort")
            , optionalMethod(className() + ".weightedAverage")
            , optionalMethod(className() + ".rentCheapest")
            , optionalMethod(className() + ".sale")
            , optionalMethod(className() + ".simulate")
            };
    }

    public static void main(String... args) {
        Test.main(new Part2());
    }
}
