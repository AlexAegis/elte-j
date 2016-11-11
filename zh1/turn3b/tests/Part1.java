package tests;

import raffle.Destination;
import utest.*;

public class Part1 extends Testable {
    public void assertion() {
        Destination d1 = Destination.make("A", "2017/12/31", 7500);
        check("Destination.make(): tul rovid varosnev eseten is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Washington", "2017/02/01", -500);
        check("Destination.make(): negativ arnal is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Velence", "2017/10/18", 0);
        check("Destination.make(): nulla arnal is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Madrid", "2017/03/21", 8500);
        check("Destination.make(): tul nagy arnal is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Barce,lona", "2017/09/30", 7500);
        check("Destination.make(): illegalis karaktert tartalmazo varosnev eseten is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Toledo", "2018/01/30", 3500);
        check("Destination.make(): helytelen ev eseten is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Melbourne", "2017/00/30", 2900);
        check("Destination.make(): helytelen honap eseten is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Sydney", "2017/14/30", 5500);
        check("Destination.make(): helytelen honap eseten is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Firenze", "2017/04/31", 1800);
        check("Destination.make(): helytelen nap eseten is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Verona", "2017/02/29", 2700);
        check("Destination.make(): helytelen nap eseten is letrehozza az objektumot.", d1 == null);
        d1 = Destination.make("Barcelona", "2017/02/27", 4400);
        check("Destination.make(): helyes parameterekkel sem hozza letre az objektumot.", d1 != null);
        check("Destination.getPrice(): a metodus nem a helyes arat adja vissza.", d1.getPrice() == 4400);
        Destination d2 = Destination.make("New York", "2017/12/31", 7500);
        Destination d3 = Destination.make("Miami", "2017/05/30", 7500);
        check("Destination.betterHit(): a metodus nem a helyes adatot adja vissza.", d1.betterHit(d2).equals(d2));
        check("Destination.betterHit(): a metodus nem a helyes adatot adja vissza.", d2.betterHit(d1).equals(d2));
        check("Destination.betterHit(): a metodus nem a helyes adatot adja vissza egyforma ar eseten.", d2.betterHit(d3).equals(d3));
        check("Destination.betterHit(): a metodus nem a helyes adatot adja vissza egyforma ar eseten.", d3.betterHit(d2).equals(d2));
        check("Destination.toString(): a metodus negyjegyu szamnal nem a helyes adatot adja vissza.",d2.toString().equals("New York 2017/12/31 (7500 EUR)"));
        Destination d4 = Destination.make("Pozsony", "2017/06/15", 900);
        check("Destination.toString(): a metodus haromjegyu szamnal nem a helyes adatot adja vissza.",d4.toString().equals("Pozsony 2017/06/15 (900 EUR)"));
        Destination d5 = Destination.make("Szkopje", "2017/08/13", 97);
        check("Destination.toString(): a metodus ketjegyu szamnal nem a helyes adatot adja vissza.",d5.toString().equals("Szkopje 2017/08/13 (97 EUR)"));
        Destination d6 = Destination.make("Budapest", "2017/07/25", 8);
        check("Destination.toString(): a metodus egyjegyu szamnal nem a helyes adatot adja vissza.",d6.toString().equals("Budapest 2017/07/25 (8 EUR)"));
    }

    public String description() { return "1. resz"; }
    public String className() { return "raffle.Destination"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class, String.class,Integer.TYPE})
            , staticMethod(className() + ".make", String.class, String.class,Integer.TYPE)
            , staticMethod(className() + ".validDate", String.class)
            , method(className() + ".getPrice")
            , method(className() + ".betterHit", raffle.Destination.class)
            , method(className() + ".toString")
            };
    }

    
    public Object[] expectedFields() throws Exception {
        return new Object[]
            { staticField(className() + ".MAX_PRICE")
            , staticField(className() + ".DESTINATION_OF_THE_YEAR")
            };
    }
    

    public static void main(String... args) {
        Test.main(new Part1());
    }
}
