package tests;

import rental.Car;
import rental.CarRental;
import java.io.*;
import utest.*;

public class Part3 extends Testable {
    public void assertion() throws Exception {
        CarRental cr1 = new CarRental("badfilename.txt");
        CarRental cr2 = new CarRental("cars.txt");
        cr1.insertionSort();
        check("CarRental.insertionSort(): nem jol vegzi a rendezest, ha nincsenek autok", cr1.numberOfCars() == 0);
        check("CarRental.insertionSort(): nem jol vegzi a rendezest, ha nincsenek autok", cr1.toString().equals(""));
        cr2.insertionSort();
        check("CarRental.insertionSort(): nem jol vegzi a rendezest, ha vannak autok a listaban", cr2.numberOfCars() == 4);
        check("CarRental.insertionSort(): nem jol vegzi a rendezest, ha vannak autok a listaban", cr2.toString().equals("Alfa Romeo (DEF 234)   9,0 EUR\nBMW (ABC 123)  50,0 EUR\nToyota (GHI 456) 500,0 EUR\nVolvo (JSD 856) 500,0 EUR"));
        check("CarRental.weightedAverage(): nem -1.0-et ad vissza, ha nincsenek autok.", cr1.weightedAverage() == -1.0);
        check("CarRental.weightedAverage(): nem jol szamolja ki a sulyozott atlagot.", cr2.weightedAverage() == 360.9);  
    }
	
    public String description() { return "3. resz"; }
    public String className() { return "rental.CarRental"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class})
            , method(className() + ".numberOfCars")
            , method(className() + ".toString")
            , method(className() + ".insertionSort")
            , method(className() + ".weightedAverage")
            , optionalMethod(className() + ".rentCheapest")
            , optionalMethod(className() + ".sale")
            , optionalMethod(className() + ".simulate")
            };
    }

    public static void main(String... args) {
        Test.main(new Part3());
    }
}
