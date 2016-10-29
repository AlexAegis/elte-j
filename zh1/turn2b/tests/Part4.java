package tests;

import weightlifting.WeightLifter;
import weightlifting.Championship;
import java.io.*;
import java.util.*;
import utest.*;

import java.util.Arrays;

public class Part4 extends Testable {
    private boolean checkWeightLifterLists(LinkedList<WeightLifter> list1, LinkedList<WeightLifter> list2) {
        if (list1.size() != list2.size()) return false;
        int i = 0;
        while (i < list1.size() && list1.get(i).show().equals(list2.get(i).show())) ++i;
        return (i >= list1.size());
    }
    public void assertion() {
        try {
            Championship cs = new Championship("weightlifters.txt");
            check("Championship.round: a metodus nem a megfelelo sulyemelot adja vissza.", cs.round().show().equals("Aleksey Petrov -   9 kg"));
            check("Championship.round: a metodus nem csokkenti a listat.", cs.numberOfWeightLifters() == 4);
            check("Championship.round: a metodus nem jo sulyemeloket hagy benne a listaban.", cs.show().equals("Ivan Ivanov - 120 kg\nFoldi Imre - 137 kg\nPablo Lara -  25 kg\nKoji Miki - 137 kg"));
            cs.round(); cs.round();
            check("Championship.round: a metodus nem a megfelelo sulyemelot adja vissza, ha a leggyengebbel azonos erossegu is van.", cs.round().show().equals("Foldi Imre - 137 kg"));
            check("Championship.round: a metodus a megfelelo sulyemelot tavolitja el, ha a leggyengebbel azonos erossegu is van.", cs.show().equals("Koji Miki - 137 kg"));
            check("Championship.round: a metodus nem a megfelelo sulyemelot adja vissza, ha mar csak egy versenyzo volt.", cs.round().show().equals("Koji Miki - 137 kg"));
            check("Championship.round: a metodus uriti ki a listat, ha elfogytak a versenyzok.", cs.show().equals(""));
            check("Championship.round: a metodus nem jol mukodik abban az esetben, ha nincsenek sulyemelok.", cs.round()==null);
            check("Championship.round: a metodus nem jol mukodik abban az esetben, ha nincsenek sulyemelok.", cs.show().equals(""));
            cs = new Championship("weightlifters.txt");
            LinkedList<WeightLifter> expectedWeightLifters = new LinkedList<WeightLifter>();
            expectedWeightLifters.add(WeightLifter.make("Aleksey Petrov", 9));
            expectedWeightLifters.add(WeightLifter.make("Pablo Lara", 25));
            expectedWeightLifters.add(WeightLifter.make("Ivan Ivanov", 120));
            expectedWeightLifters.add(WeightLifter.make("Foldi Imre", 137));
            expectedWeightLifters.add(WeightLifter.make("Koji Miki", 137));
            check("Championship.championship: a metodus nem megfelelo listat ad vissza.", checkWeightLifterLists(cs.championship(),expectedWeightLifters));
            check("Championship.championship: a metodus nem uriti ki a listat.", cs.numberOfWeightLifters() == 0);
            check("Championship.championship: a metodus nem jol mukodik abban az esetben, ha nincsenek sulyemelok.", cs.championship().isEmpty());
        } catch (Exception e) {
            check("A Championship konstruktora nem engedheti ki a kivetelt a metodusbol", false);
        }
    }

    public String description() { return "4. resz"; }
    public String className() { return "weightlifting.Championship"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class})
            , optionalMethod(className() + ".numberOfWeightLifters")
            , optionalMethod(className() + ".show")
            , optionalMethod(className() + ".strongerThan", weightlifting.WeightLifter.class)
            , optionalMethod(className() + ".average")
            , method(className() + ".round")
            , method(className() + ".championship")
            };
    }

    public static void main(String... args) {
        Test.main(new Part4());
    }
}
