package tests;

import rental.Car;
import rental.CarRental;
import java.io.*;
import java.util.*;
import utest.*;

public class Part4 extends Testable {
    public void assertion() throws Exception {
        CarRental cr1 = new CarRental("badfilename.txt");
        CarRental cr2 = new CarRental("cars.txt");
        Car c = cr1.rentCheapest();
        check("CarRental.rentCheapest(): a metodus nem a jo eredmenyt ad vissza, ha nincsenek autok.", c==null);
        c = cr2.rentCheapest();
        check("CarRental.rentCheapest(): a metodus nem csokkenti a lista meretet, ha vannak autok a listaban", cr2.numberOfCars() == 3);
        check("CarRental.rentCheapest(): a metodus nem a megfelelo autot adja vissza", c.toString().equals("Alfa Romeo (DEF 234)   9,0 EUR"));
        check("CarRental.rentCheapest(): a metodus nem a megfelelo auto(ka)t hagyja benne a listaban", cr2.toString().equals("BMW (ABC 123)  50,0 EUR\nToyota (GHI 456) 500,0 EUR\nVolvo (JSD 856) 500,0 EUR"));
        c = cr2.rentCheapest();
        check("CarRental.rentCheapest(): a metodus nem csokkenti a lista meretet, ha vannak autok a listaban", cr2.numberOfCars() == 2);
        check("CarRental.rentCheapest(): a metodus nem a megfelelo autot adja vissza", c.toString().equals("BMW (ABC 123)  50,0 EUR"));
        check("CarRental.rentCheapest(): a metodus nem a megfelelo auto(ka)t hagyja benne a listaban", cr2.toString().equals("Toyota (GHI 456) 500,0 EUR\nVolvo (JSD 856) 500,0 EUR"));
        c = cr2.rentCheapest();
        check("CarRental.rentCheapest(): a metodus nem csokkenti a lista meretet, ha vannak autok a listaban", cr2.numberOfCars() == 1);
        check("CarRental.rentCheapest(): a metodus nem a megfelelo autot adja vissza, ha a legolcsobbal azonos aru is van", c.toString().equals("Toyota (GHI 456) 500,0 EUR"));
        check("CarRental.rentCheapest(): a metodus nem a megfelelo auto(ka)t hagyja benne a listaban, ha a legolcsobbal azonos aru is van", cr2.toString().equals("Volvo (JSD 856) 500,0 EUR"));
        c = cr2.rentCheapest();
        check("CarRental.rentCheapest(): a metodus nem csokkenti a lista meretet, ha mar csak egy auto van a listaban", cr2.numberOfCars() == 0);
        check("CarRental.rentCheapest(): a metodus nem a megfelelo autot adja vissza, ha mar csak egy auto van a listaban", c.toString().equals("Volvo (JSD 856) 500,0 EUR"));
        check("CarRental.rentCheapest(): a metodus nem uriti ki a listat, ha mar csak egy auto van a listaban", cr2.toString().equals(""));
        c = cr2.rentCheapest();
        check("CarRental.rentCheapest(): a metodus nem a jo eredmenyt ad vissza, ha nincsenek autok.", c==null);
        CarRental cr3 = new CarRental("cars.txt");
        ArrayList<Car> carList = new ArrayList<Car>();
        carList = cr3.sale();
        check("CarRental.sale(): a metodus nem jol csokkenti az autok arat.",carList.get(0).getPrice()==40.0 || carList.get(0).getPrice() == 50);
        check("CarRental.sale(): a metodus nem jol csokkenti az autok arat.",carList.get(1).getPrice()==9.0);
        check("CarRental.sale(): a metodus nem jol csokkenti az autok arat.",carList.get(2).getPrice()==500.0); 
        check("CarRental.sale(): a metodus nem jol csokkenti az autok arat.",carList.get(3).getPrice()==500.0);
        CarRental cr4 = new CarRental("badfilename.txt");
        carList = cr4.simulate();
        check("CarRental.simulate(): a metodus nem jol vegzi a szimulaciot, ha nincsenek autok.",carList.size()==0);
        CarRental cr5 = new CarRental("cars.txt");
        carList = cr5.simulate();
        check("CarRental.simulate(): a metodus nem jol vegzi a szimulaciot, ha vannak autok a listaban.",carList.size()==4);
        check("CarRental.simulate(): a metodus nem jol vegzi a szimulaciot, ha vannak autok a listaban.",carList.get(0).getPrice()==9.0);
        check("CarRental.simulate(): a metodus nem jol vegzi a szimulaciot, ha vannak autok a listaban.",carList.get(1).getPrice()==40.0 || carList.get(1).getPrice() == 50);
        check("CarRental.simulate(): a metodus nem jol vegzi a szimulaciot, ha vannak autok a listaban.",carList.get(2).getPrice()==500.0); 
        check("CarRental.simulate(): a metodus nem jol vegzi a szimulaciot, ha vannak autok a listaban.",carList.get(3).getPrice()==500.0);
    }
	
    public String description() { return "4. resz"; }
    public String className() { return "rental.CarRental"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class})
            , method(className() + ".numberOfCars")
            , method(className() + ".toString")
            , optionalMethod(className() + ".insertionSort")
            , optionalMethod(className() + ".weightedAverage")
            , method(className() + ".rentCheapest")
            , method(className() + ".sale")
            , method(className() + ".simulate")
            };
    }

    public static void main(String... args) {
        Test.main(new Part4());
    }
}
