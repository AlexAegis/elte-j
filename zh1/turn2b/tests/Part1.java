package tests;

import weightlifting.WeightLifter;
import utest.*;

import java.util.Arrays;

public class Part1 extends Testable {
    public void assertion() {
        check("WeightLifter.getStrongestWeightLifter: a metodusnak null-t kell visszaadnia, ha meg nem hoztak letre WeightLifter objektumot.", WeightLifter.getStrongestWeightLifter() == null);
        WeightLifter wl1 = WeightLifter.make("A", 15);
        check("WeightLifter.make: tul rovid nevhez is letrehozza az objektumot.", wl1 == null);
        wl1 = WeightLifter.make("ABC", -5);
        check("WeightLifter.make: negativ sulynal is letrehozza az objektumot.", wl1 == null);
        wl1 = WeightLifter.make("ABC", 0);
        check("WeightLifter.make: nulla erteku sulynal is letrehozza az objektumot.", wl1 == null);
        wl1 = WeightLifter.make("ABC", 301);
        check("WeightLifter.make: tul nagy sulynal is letrehozza az objektumot.", wl1 == null);
        wl1 = WeightLifter.make("AB,C", 200);
        check("WeightLifter.make: illegalis karaktert tartalmazo nevnel is letrehozza az objektumot.", wl1 == null);
        wl1 = WeightLifter.make("Ivan Ivanov", 120);
        check("WeightLifter.make: helyes parameterekkel sem hozza letre az objektumot.", wl1 != null);
        check("WeightLifter.getWeight: a metodus nem ad vissza helyes adatot.", wl1.getWeight() == 120);
        WeightLifter wl2 = WeightLifter.make("Foldi Imre", 137);
        check("WeightLifter.strongerThan: a metodus nem ad vissza helyes adatot.", !wl1.strongerThan(wl2));
        check("WeightLifter.strongerThan: a metodus nem ad vissza helyes adatot.", wl2.strongerThan(wl1));

        check("WeightLifter.show: a metodus nem ad vissza helyes adatot haromszamjegyu sulynal.", wl1.show().equals("Ivan Ivanov - 120 kg"));
        WeightLifter wl3 = WeightLifter.make("Pablo Lara", 25);
        check("WeightLifter.show: a metodus nem ad vissza helyes adatot ketszamjegyu sulynal.", wl3.show().equals("Pablo Lara -  25 kg"));
        WeightLifter wl4 = WeightLifter.make("Aleksey Petrov", 9);
        check("WeightLifter.show: a metodus nem ad vissza helyes adatot egyszamjegyu sulynal.", wl4.show().equals("Aleksey Petrov -   9 kg"));
        check("WeightLifter.getStrongestWeightLifter: a metodus nem a valaha letrehozott legerosebb WeightLifter objektumot adja vissza.", WeightLifter.getStrongestWeightLifter().show().equals(wl2.show()));
        WeightLifter wl5 = WeightLifter.make("Koji Miki", 137);
        check("WeightLifter.strongerThan: a metodus nem ad vissza helyes adatot egyforma erossegu sulyemeloknel.", !wl5.strongerThan(wl2));
        check("WeightLifter.strongerThan: a metodus nem ad vissza helyes adatot egyforma erossegu sulyemeloknel.", !wl2.strongerThan(wl5));
        check("WeightLifter.getStrongestWeightLifter: ha a valaha letrehozott legerosebb sulyemelovel egyforma erossegu is van, akkor a metodusnak ezek kozul a legkorabban letrehozottat kell visszaania.", WeightLifter.getStrongestWeightLifter().show().equals(wl2.show()));
    }

    public String description() { return "1. resz"; }
    public String className() { return "weightlifting.WeightLifter"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class, Integer.TYPE})
            , staticMethod(className() + ".make", String.class, Integer.TYPE)
            , method(className() + ".getWeight")
            , method(className() + ".strongerThan", weightlifting.WeightLifter.class)
            , method(className() + ".show")
            , staticMethod(className() + ".getStrongestWeightLifter")
            };
    }

    public static void main(String... args) {
        Test.main(new Part1());
    }
}
