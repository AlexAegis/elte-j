package tests;

import raffle.Destination;
import raffle.Raffle;
import java.io.*;
import java.util.*;
import utest.*;

public class Part4 extends Testable {
    private static boolean cmp(ArrayList<Destination> firstList, ArrayList<Destination> secondList) {
        ArrayList<Destination> cp = new ArrayList<Destination>(firstList);
        int i=0;
        while (i<secondList.size()){
            int k=0;
            while (k<cp.size()) {
                if (cp.get(k).toString().equals(secondList.get(i).toString())) {
                    cp.remove(cp.get(k));
                    k = cp.size();
                }
                k++;
            }
            i++;
        }
        return cp.isEmpty();	
    }
	
    public void assertion() throws Exception {
        Raffle r1 = new Raffle("badfilename.txt");
        Raffle r2 = new Raffle("destinations.txt");
        Destination d = r1.raffle();
        check("Raffle.raffle(): a metodus nem a jo eredmenyt ad vissza, ha nincsenek varosok.", d==null);
        ArrayList<Destination> dstList = new ArrayList<Destination>();
        int n = r2.numberOfDestinations();
        int k = n;
        for (int i=0; i < n; i++){
            d = r2.raffle();
            dstList.add(d);
            k--; 
            check("Raffle.raffle(): a metodus nem csokkenti a lista meretet, ha vannak varosok a listaban", r2.numberOfDestinations() == k);
        }
        ArrayList<Destination> simList = new ArrayList<Destination>();
        simList = r1.simulate();
        check("Raffle.simulate(): a metodus nem jol vegzi a szimulaciot, ha nincsenek varosok a listaban.", simList.size()==0);
        Raffle r3 = new Raffle("destinations.txt");		
        simList = r3.simulate();
        check("Raffle.simulate(): a metodus nem jol vegzi a szimulaciot, ha vannak varosok a listaban.", simList.size()==6);
        check("Raffle.simulate(): a metodus nem jol vegzi a szimulaciot, ha vannak varosok a listaban.", cmp(simList,dstList));		
    }
	
    public String description() { return "4. resz"; }
    public String className() { return "raffle.Raffle"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class})
            , method(className() + ".numberOfDestinations")
            , optionalMethod(className() + ".toString")
            , optionalMethod(className() + ".insertionSort")
            , optionalMethod(className() + ".weightedAverage")
            , method(className() + ".raffle")
            , method(className() + ".simulate")
            };
    }

    public static void main(String... args) {
        Test.main(new Part4());
    }
}
