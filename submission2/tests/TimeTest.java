package tests;

import utest.*;
import interval.time.Time;

public class TimeTest extends Testable {
    public void assertion() {
        check("make(): tul korai idoponthoz (7:42) is letrehozza az objektumot.", Time.make(7,42) == null);
        check("make(): tul kesoi idoponthoz (22:15) is letrehozza az objektumot.", Time.make(22,15) == null);
        check("make(): tul kesoi idoponthoz (18:15) is letrehozza az objektumot.", Time.make(18,15) == null);
        check("make(): ertelmetlen idoponthoz (8:72) is letrehozza az objektumot.", Time.make(8,72) == null);
        check("make(): ertelmetlen idoponthoz (25:12) is letrehozza az objektumot.", Time.make(25,12) == null);
        check("make(): ertelmetlen idoponthoz (38:72) is letrehozza az objektumot.", Time.make(38,72) == null);
        check("make(): megfelelo parameterekkel (9:15) sem hozza az objektumot.", Time.make(9,15) != null);
        check("make(): megfelelo parameterekkel (8:00) sem hozza az objektumot.", Time.make(8,0) != null);
        check("make(): megfelelo parameterekkel (8:45) sem hozza az objektumot.", Time.make(8,45) != null);
        check("make(): megfelelo parameterekkel (18:00) sem hozza az objektumot.", Time.make(18,0) != null);
        
        check("toString(): a metodus nem a megfelelo szoveget adja vissza (9:15).", "9:15".equals(Time.make(9,15).toString()));
        check("toString(): a metodus nem a megfelelo szoveget adja vissza (9:01).", "9:01".equals(Time.make(9,1).toString()));
        check("toString(): a metodus nem a megfelelo szoveget adja vissza (9:00).", "9:00".equals(Time.make(9,0).toString()));
        check("toString(): a metodus nem a megfelelo szoveget adja vissza (10:05).", "10:05".equals(Time.make(10,5).toString()));
        
        check("add(): a metodus negativ parameterre nem null-t ad vissza.", Time.make(10,0).add(-1) == null);
        check("add(): a metodus nem szamol megfeleloen (9:15 + 32).", Time.make(9,15).add(32) != null && Time.make(9,15).add(32).toString().equals("9:47"));
        check("add(): a metodus nem szamol megfeleloen (9:15 + 52).", Time.make(9,15).add(52) != null && Time.make(9,15).add(52).toString().equals("10:07"));
        check("add(): a metodus nem szamol megfeleloen (9:15 + 60).", Time.make(9,15).add(60) != null && Time.make(9,15).add(60).toString().equals("10:15"));
        check("add(): a metodus nem szamol megfeleloen (9:15 + 90).", Time.make(9,15).add(90) != null && Time.make(9,15).add(90).toString().equals("10:45"));
        check("add(): a metodus nem szamol megfeleloen (9:15 + 110).", Time.make(9,15).add(110) != null && Time.make(9,15).add(110).toString().equals("11:05"));
        check("add(): a metodus nem szamol megfeleloen (9:15 + 180).", Time.make(9,15).add(180) != null && Time.make(9,15).add(180).toString().equals("12:15"));
        check("add(): a metodus nem szamol megfeleloen (9:15 + 200).", Time.make(9,15).add(200) != null && Time.make(9,15).add(200).toString().equals("12:35"));
        check("add(): a metodus nem szamol megfeleloen (9:15 + 240).", Time.make(9,15).add(240) != null && Time.make(9,15).add(240).toString().equals("13:15"));
        check("add(): a metodus nem szamol megfeleloen (9:00 + 0).", Time.make(9,0).add(0) != null && Time.make(9,0).add(0).toString().equals("9:00"));
        check("add(): a metodus nem szamol megfeleloen (8:00 + 0).", Time.make(8,0).add(0) != null && Time.make(8,0).add(0).toString().equals("8:00"));
        check("add(): a metodus nem szamol megfeleloen (17:00 + 60).", Time.make(17,0).add(60) != null && Time.make(17,0).add(60).toString().equals("18:00"));
        check("add(): a metodus akkor is letrehozza a Time objektumot, ha az eltolt idopont mar tul keson van (17:01 + 60).", Time.make(17,1).add(60) == null);
        check("add(): a metodus akkor is letrehozza a Time objektumot, ha az eltolt idopont mar tul keson van (17:00 + 123).", Time.make(17,0).add(123) == null);
        check("add(): a metodus akkor is letrehozza a Time objektumot, ha az eltolt idopont masik napra csuszna at (17:00 + 600).", Time.make(17,0).add(600) == null);
        
        Time time = Time.make(9,20);
        Time time2 = time.add(20);
        check("add(): a metodus nem valtoztathatja meg az objektum allapotat.", time.toString().equals("9:20"));
        
        check("hashCode(): a metodusnak egyforma erteku objektumokhoz azonos erteket kell rendelnie.", time.hashCode() == Time.make(9,20).hashCode());
        
        check("equals(): a metodusnak igazat kell visszaadnia, ha a két referencia ugyanarra az objektumra mutat.", time.equals(time));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha egy letezo objektumot null-lal hasonlitunk ossze.", !time.equals(null));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok tipusa nem egyezik meg.", !time.equals(new Integer(42)));
        check("equals(): a metodusnak igazat kell visszaadnia, ha az osszehasonlitando objektumok megegyeznek.", time.equals(Time.make(9,20)));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok nem egyeznek meg (9:20 != 9:30).", !time.equals(Time.make(9,30)));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok nem egyeznek meg (9:20 != 10:20).", !time.equals(Time.make(10,20)));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok nem egyeznek meg (9:20 != 10:30).", !time.equals(Time.make(10,30)));
        
        check("compareTo(): a metodusnak 0-t kell visszaadnia, ha az objektumok egyenloek.", time.compareTo(Time.make(9,20)) == 0);
        
        check("compareTo(): a metodusnak negativ szamot kell visszaadnia, ha az aktualis objektum kisebb, mint a parameterben kapott objektum (9:20 < 9:22).", time.compareTo(Time.make(9,22)) < 0);
        check("compareTo(): a metodusnak negativ szamot kell visszaadnia, ha az aktualis objektum kisebb, mint a parameterben kapott objektum (9:20 < 10:12).", time.compareTo(Time.make(10,12)) < 0);
        check("compareTo(): a metodusnak negativ szamot kell visszaadnia, ha az aktualis objektum kisebb, mint a parameterben kapott objektum (9:20 < 10:22).", time.compareTo(Time.make(10,22)) < 0);
        
        check("compareTo(): a metodusnak pozitiv szamot kell visszaadnia, ha az aktualis objektum nagyobb, mint a parameterben kapott objektum (9:20 > 9:17).", time.compareTo(Time.make(9,17)) > 0);
        check("compareTo(): a metodusnak pozitiv szamot kell visszaadnia, ha az aktualis objektum nagyobb, mint a parameterben kapott objektum (9:20 > 8:50).", time.compareTo(Time.make(8,50)) > 0);
        check("compareTo(): a metodusnak pozitiv szamot kell visszaadnia, ha az aktualis objektum nagyobb, mint a parameterben kapott objektum (9:20 > 8:17).", time.compareTo(Time.make(8,17)) > 0);
    }

    public String description() { return "interval.time.Time"; }
    public String className() { return "interval.time.Time"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { staticMethod(className() + ".make", int.class, int.class)
        , method(className() + ".toString")
        , method(className() + ".add", int.class)
        , method(className() + ".hashCode")
        , method(className() + ".equals", Object.class)
        , method(className() + ".compareTo", Time.class)
        
        /* do not implement this method */
        , optionalMethod(className() + ".compareTo", Object.class)
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new TimeTest());
    }
}
