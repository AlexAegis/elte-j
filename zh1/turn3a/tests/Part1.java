package tests;

import rental.Car;
import utest.*;

public class Part1 extends Testable {
    public void assertion() {
        Car c1 = Car.make("A", "ABC 123", 500.0);
        check("Car.make(): tul rovid markahoz is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BMW", "ABC 123", -500.0);
        check("Car.make(): negativ arnal is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BMW", "ABC 123", 0.0);
        check("Car.make(): nulla arnal is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BMW", "ABC 123", 503.0);
        check("Car.make(): tul nagy arnal is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BM,W", "ABC 123", 50.0);
        check("Car.make(): illegalis karaktert tartalmazo markanal is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BMW", "ABC 12", 50.0);
        check("Car.make(): tul rovid rendszamtablahoz is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BMW", "ABC 1234", 50.0);
        check("Car.make(): tul hosszu rendszamtablahoz is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BMW", "AbC 123", 50.0);
        check("Car.make(): (az elso harom helyen) kisbetut tartalmazo rendszamtablahoz is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BMW", "ABC D23", 50.0);
        check("Car.make(): (az utolso harom helyen) nem szamjegyet tartalmazo rendszamtablahoz is letrehozza az objektumot.", c1 == null);
        c1 = Car.make("BMW", "ABC 123", 50.0);
        check("Car.make(): helyes parameterekkel sem hozza letre az objektumot.", c1 != null);
        check("Car.getPrice(): a metodus nem a helyes arat adja vissza.", c1.getPrice() == 50.0);
        c1.decreasePrice();
        check("Car.decreasePrice(): a metodus nem jol csokkenti az arat.", c1.getPrice() == 40.0);
        Car c2 = Car.make("Alfa Romeo", "DEF 234", 9.0);
        c2.decreasePrice();
        check("Car.decreasePrice(): a metodus nem jol csokkenti az arat.", c2.getPrice() == 9.0);
        Car c3 = Car.make("Toyota", "GHI 456", 500.0);
        c3.decreasePrice();
        check("Car.decreasePrice(): a metodus nem jol csokkenti az arat.", c3.getPrice() == 500.0);
        check("Car.cheaperThan(): a metodus nem a helyes adatot adja vissza.", c2.cheaperThan(c3));
        check("Car.cheaperThan(): a metodus nem a helyes adatot adja vissza.", !c3.cheaperThan(c2));
        Car c4 = Car.make("Volvo", "JSD 856", 500.0);
        check("Car.cheaperThan(): a metodus nem a helyes adatot adja vissza egyforma aru kocsik eseten.", !c3.cheaperThan(c4));
        check("Car.cheaperThan(): a metodus nem a helyes adatot adja vissza egyforma aru kocsik eseten.", !c4.cheaperThan(c3));
        check("Car.toString(): a metodus haromjegyu szamnal nem a helyes adatot adja vissza.", c4.toString().equals("Volvo (JSD 856) 500,0 EUR"));
        check("Car.toString(): a metodus nem egy tizedesjegyet ad vissza.", c4.toString().equals("Volvo (JSD 856) 500,0 EUR"));
        check("Car.toString(): a metodus ketjegyu szamnal nem a helyes adatot adja vissza.", c1.toString().equals("BMW (ABC 123)  40,0 EUR"));
        check("Car.toString(): a metodus egyjegyu szamnal nem a helyes adatot adja vissza.", c2.toString().equals("Alfa Romeo (DEF 234)   9,0 EUR"));
    }

    public String description() { return "1. resz"; }
    public String className() { return "rental.Car"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class, String.class, Double.TYPE})
            , staticMethod(className() + ".make", String.class, String.class, Double.TYPE)
            , staticMethod(className() + ".validLicensePlate", String.class)
            , method(className() + ".getPrice")
            , method(className() + ".decreasePrice")
            , method(className() + ".cheaperThan", rental.Car.class)
            , method(className() + ".toString")
            };
    }

    
    public Object[] expectedFields() throws Exception {
        return new Object[]
            { staticField(className() + ".MAX_PRICE")
            , staticField(className() + ".CAR_OF_THE_YEAR")
            };
    }
    

    public static void main(String... args) {
        Test.main(new Part1());
    }
}
