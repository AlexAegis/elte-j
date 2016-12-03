package tests;

import utest.*;
import interval.Interval;
import interval.time.*;

public class IntervalTest extends Testable {
    public void assertion() {
        check("make(): akkor is letrehozza az objektumot, ha a kezdo idopont nem megfelelo (7:42).", Interval.make(Day.MONDAY,7,42,60) == null);
        check("make(): akkor is letrehozza az objektumot, ha a kezdo idopont nem megfelelo (22:15).", Interval.make(Day.TUESDAY,22,15,60) == null);
        check("make(): akkor is letrehozza az objektumot, ha a kezdo idopont nem megfelelo (18:15).", Interval.make(Day.WEDNESDAY,18,15,60) == null);
        check("make(): akkor is letrehozza az objektumot, ha a kezdo idopont nem megfelelo (38:72).", Interval.make(Day.THURSDAY,38,72,60) == null);
        check("make(): akkor is letrehozza az objektumot, ha a befejezo idopont nem megfelelo (19:30).", Interval.make(Day.FRIDAY,17,30,120) == null);
        check("make(): akkor is letrehozza az objektumot, ha a befejezo idopont nem megfelelo (18:15).", Interval.make(Day.MONDAY,17,15,60) == null);
        check("make(): akkor is letrehozza az objektumot, ha az ora hossza nem megfelelo (20 perc).", Interval.make(Day.TUESDAY,10,0,20) == null);
        check("make(): akkor is letrehozza az objektumot, ha az ora hossza nem megfelelo (200 perc).", Interval.make(Day.WEDNESDAY,10,0,200) == null);
        check("make(): megfelelo parameterekkel (csutortok, 9:15, 60 perc) sem hozza az objektumot.", Interval.make(Day.THURSDAY,9,15,60) != null);
        check("make(): megfelelo parameterekkel (pentek, 8:00, 60 perc) sem hozza az objektumot.", Interval.make(Day.FRIDAY,8,0,60) != null);
        check("make(): megfelelo parameterekkel (hetfo, 8:45, 60 perc) sem hozza az objektumot.", Interval.make(Day.MONDAY,8,45,60) != null);
        check("make(): megfelelo parameterekkel (kedd, 17:00, 60 perc) sem hozza az objektumot.", Interval.make(Day.TUESDAY,17,0,60) != null);
        check("make(): megfelelo parameterekkel (szerda, 12:15, 30 perc) sem hozza az objektumot.", Interval.make(Day.WEDNESDAY,12,15,30) != null);
        check("make(): megfelelo parameterekkel (csutortok, 12:15, 180 perc) sem hozza az objektumot.", Interval.make(Day.WEDNESDAY,12,15,180) != null);
        
        check("getDay(): nem a megfelelo napot adja vissza.", Interval.make(Day.MONDAY,8,45,60).getDay().equals(Day.MONDAY));
        check("getStartTime(): nem a megfelelo kezdo idopontot adja vissza.", Interval.make(Day.MONDAY,8,45,60).getStartTime().equals(Time.make(8,45)));
        check("getEndTime: nem a megfelelo befejezo idopontot adja vissza (9:47).", Interval.make(Day.MONDAY,9,15,32).getEndTime().equals(Time.make(9,47)));
        check("getEndTime: nem a megfelelo befejezo idopontot adja vissza (10:07).", Interval.make(Day.MONDAY,9,15,52).getEndTime().equals(Time.make(10,7)));
        check("getEndTime: nem a megfelelo befejezo idopontot adja vissza (10:15).", Interval.make(Day.MONDAY,9,15,60).getEndTime().equals(Time.make(10,15)));
        check("getEndTime: nem a megfelelo befejezo idopontot adja vissza (10:45).", Interval.make(Day.MONDAY,9,15,90).getEndTime().equals(Time.make(10,45)));
        check("getEndTime: nem a megfelelo befejezo idopontot adja vissza (11:05).", Interval.make(Day.MONDAY,9,15,110).getEndTime().equals(Time.make(11,5)));
        check("getEndTime: nem a megfelelo befejezo idopontot adja vissza (12:15).", Interval.make(Day.MONDAY,9,15,180).getEndTime().equals(Time.make(12,15)));
        check("getEndTime: nem a megfelelo befejezo idopontot adja vissza (18:00).", Interval.make(Day.MONDAY,17,0,60).getEndTime().equals(Time.make(18,0)));
        check("getLength(): nem a megfelelo hosszt adja vissza (100).", Interval.make(Day.MONDAY,8,45,100).getLength() == 100);
        
        check("toString(): a metodus nem a megfelelo szoveget adja vissza (hetfo 9:00 - 10:15).", "hetfo 9:00 - 10:15".equals(Interval.make(Day.MONDAY,9,0,75).toString()));
        check("toString(): a metodus nem a megfelelo szoveget adja vissza (kedd 10:15 - 11:05).", "kedd 10:15 - 11:05".equals(Interval.make(Day.TUESDAY,10,15,50).toString()));
        
        Interval interval = Interval.make(Day.FRIDAY,9,20,60);
        check("hashCode(): a metodusnak egyforma erteku objektumokhoz azonos erteket kell rendelnie.", interval.hashCode() == Interval.make(Day.FRIDAY,9,20,60).hashCode());
        
        check("equals(): a metodusnak igazat kell visszaadnia, ha a két referencia ugyanarra az objektumra mutat.", interval.equals(interval));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha egy letezo objektumot null-lal hasonlitunk ossze.", !interval.equals(null));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok tipusa nem egyezik meg.", !interval.equals(new Integer(42)));
        check("equals(): a metodusnak igazat kell visszaadnia, ha az osszehasonlitando objektumok megegyeznek.", interval.equals(Interval.make(Day.FRIDAY,9,20,60)));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok nem egyeznek meg (pentek 9:20, 60 perc != hetfo 9:20, 60 perc).", !interval.equals(Interval.make(Day.MONDAY,9,20,60)));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok nem egyeznek meg (pentek 9:20, 60 perc != pentek 8:20, 60 perc).", !interval.equals(Interval.make(Day.FRIDAY,8,20,60)));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok nem egyeznek meg (pentek 9:20, 60 perc != pentek 9:40, 60 perc).", !interval.equals(Interval.make(Day.FRIDAY,9,40,60)));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok nem egyeznek meg (pentek 9:20, 60 perc != pentek 9:20, 90 perc).", !interval.equals(Interval.make(Day.FRIDAY,9,20,90)));
        check("equals(): a metodusnak hamisat kell visszaadnia, ha az osszehasonlitando objektumok nem egyeznek meg (pentek 9:20, 60 perc != kedd 10:15, 120 perc).", !interval.equals(Interval.make(Day.TUESDAY,10,15,120)));
        
        check("compareTo(): a metodusnak 0-t kell visszaadnia, ha az objektumok egyenloek.", interval.compareTo(Interval.make(Day.FRIDAY,9,20,60)) == 0);
        
        check("compareTo(): a metodusnak negativ szamot kell visszaadnia, ha az aktualis objektum kisebb, mint a parameterben kapott objektum (kedd 8:10, 30 perc < pentek 9:20, 60 perc).", Interval.make(Day.TUESDAY,8,10,30).compareTo(interval) < 0);
        check("compareTo(): a metodusnak negativ szamot kell visszaadnia, ha az aktualis objektum kisebb, mint a parameterben kapott objektum (kedd 10:50, 100 perc < pentek 9:20, 60 perc).", Interval.make(Day.TUESDAY,10,50,100).compareTo(interval) < 0);
        check("compareTo(): a metodusnak negativ szamot kell visszaadnia, ha az aktualis objektum kisebb, mint a parameterben kapott objektum (pentek 8:50, 130 perc < pentek 9:20, 60 perc).", Interval.make(Day.FRIDAY,8,50,130).compareTo(interval) < 0);
        check("compareTo(): a metodusnak negativ szamot kell visszaadnia, ha az aktualis objektum kisebb, mint a parameterben kapott objektum (pentek 9:10, 130 perc < pentek 9:20, 60 perc).", Interval.make(Day.FRIDAY,9,10,130).compareTo(interval) < 0);
        check("compareTo(): a metodusnak negativ szamot kell visszaadnia, ha az aktualis objektum kisebb, mint a parameterben kapott objektum (pentek 9:20, 30 perc < pentek 9:20, 60 perc).", Interval.make(Day.FRIDAY,9,20,30).compareTo(interval) < 0);
        
        check("compareTo(): a metodusnak pozitiv szamot kell visszaadnia, ha az aktualis objektum nagyobb, mint a parameterben kapott objektum (pentek 9:20, 60 perc > kedd 8:10, 30 perc).", interval.compareTo(Interval.make(Day.TUESDAY,8,10,30)) > 0);
        check("compareTo(): a metodusnak pozitiv szamot kell visszaadnia, ha az aktualis objektum nagyobb, mint a parameterben kapott objektum (pentek 9:20, 60 perc > kedd 10:50, 100 perc).", interval.compareTo(Interval.make(Day.TUESDAY,10,50,100)) > 0);
        check("compareTo(): a metodusnak pozitiv szamot kell visszaadnia, ha az aktualis objektum nagyobb, mint a parameterben kapott objektum (pentek 9:20, 60 perc > pentek 8:50, 130 perc).", interval.compareTo(Interval.make(Day.FRIDAY,8,50,130)) > 0);
        check("compareTo(): a metodusnak pozitiv szamot kell visszaadnia, ha az aktualis objektum nagyobb, mint a parameterben kapott objektum (pentek 9:20, 60 perc > pentek 9:10, 130 perc).", interval.compareTo(Interval.make(Day.FRIDAY,9,10,130)) > 0);
        check("compareTo(): a metodusnak pozitiv szamot kell visszaadnia, ha az aktualis objektum nagyobb, mint a parameterben kapott objektum (pentek 9:20, 60 perc > pentek 9:20, 30 perc).", interval.compareTo(Interval.make(Day.FRIDAY,9,20,30)) > 0);
        
        check("endsBefore(): a metodusnak igazat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig befejezodik (hetfo 8:20, 30 perc befejezodik pentek 9:20-ig).", Interval.make(Day.MONDAY,8,20,30).endsBefore(interval));
        check("endsBefore(): a metodusnak igazat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig befejezodik (hetfo 8:20, 90 perc befejezodik pentek 9:20-ig).", Interval.make(Day.MONDAY,8,20,90).endsBefore(interval));
        check("endsBefore(): a metodusnak igazat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig befejezodik (hetfo 10:20, 30 perc befejezodik pentek 9:20-ig).", Interval.make(Day.MONDAY,10,20,30).endsBefore(interval));
        check("endsBefore(): a metodusnak igazat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig befejezodik (pentek 8:20, 30 perc befejezodik pentek 9:20-ig).", Interval.make(Day.FRIDAY,8,20,30).endsBefore(interval));
        check("endsBefore(): a metodusnak igazat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig befejezodik (pentek 8:20, 60 perc befejezodik pentek 9:20-ig).", Interval.make(Day.FRIDAY,8,20,60).endsBefore(interval));
        
        check("endsBefore(): a metodusnak hamisat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig nem fejezodik be (pentek 9:20, 60 perc nem fejezodik be hetfo 9:10-ig).", !interval.endsBefore(Interval.make(Day.MONDAY,9,10,130)));
        check("endsBefore(): a metodusnak hamisat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig nem fejezodik be (pentek 9:20, 60 perc nem fejezodik be hetfo 12:00-ig).", !interval.endsBefore(Interval.make(Day.MONDAY,12,0,130)));
        check("endsBefore(): a metodusnak hamisat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig nem fejezodik be (pentek 10:20, 30 perc nem fejezodik be pentek 9:20-ig).", !Interval.make(Day.FRIDAY,10,20,30).endsBefore(interval));
        check("endsBefore(): a metodusnak hamisat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig nem fejezodik be (pentek 9:10, 180 perc nem fejezodik be pentek 9:20-ig).", !Interval.make(Day.FRIDAY,9,10,180).endsBefore(interval));
        check("endsBefore(): a metodusnak hamisat kell visszaadnia, ha az aktualis objektum legkesobb a parameterben kapott objektum kezdo idopontjaig nem fejezodik be (pentek 8:20, 90 perc nem fejezodik be pentek 9:20-ig).", !Interval.make(Day.FRIDAY,8,20,90).endsBefore(interval));
        
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.MONDAY,9,0,30).overlapsWith(Interval.make(Day.FRIDAY,12,30,120)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.MONDAY,12,30,30).overlapsWith(Interval.make(Day.FRIDAY,9,0,120)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.MONDAY,12,30,120).overlapsWith(Interval.make(Day.FRIDAY,9,0,30)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.MONDAY,12,30,60).overlapsWith(Interval.make(Day.FRIDAY,13,0,60)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.TUESDAY,9,0,60).overlapsWith(Interval.make(Day.TUESDAY,12,0,60)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.TUESDAY,9,0,60).overlapsWith(Interval.make(Day.TUESDAY,10,0,60)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.TUESDAY,10,0,60).overlapsWith(Interval.make(Day.TUESDAY,9,0,60)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.TUESDAY,12,0,60).overlapsWith(Interval.make(Day.TUESDAY,9,0,60)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.FRIDAY,12,30,120).overlapsWith(Interval.make(Day.MONDAY,9,0,30)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.FRIDAY,9,0,120).overlapsWith(Interval.make(Day.MONDAY,12,30,30)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.FRIDAY,9,0,30).overlapsWith(Interval.make(Day.MONDAY,12,30,120)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", !Interval.make(Day.FRIDAY,13,0,60).overlapsWith(Interval.make(Day.MONDAY,12,30,60)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", Interval.make(Day.WEDNESDAY,9,0,60).overlapsWith(Interval.make(Day.WEDNESDAY,9,30,60)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", Interval.make(Day.WEDNESDAY,9,0,120).overlapsWith(Interval.make(Day.WEDNESDAY,9,30,30)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", Interval.make(Day.WEDNESDAY,9,30,30).overlapsWith(Interval.make(Day.WEDNESDAY,9,0,120)));
        check("overlapsWith(): a metodus nem ad jo eredmenyt.", Interval.make(Day.WEDNESDAY,9,30,60).overlapsWith(Interval.make(Day.WEDNESDAY,9,0,60)));
    }

    public String description() { return "interval.Interval"; }
    public String className() { return "interval.Interval"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { staticMethod(className() + ".make", Day.class, int.class, int.class, int.class)
        , method(className() + ".getDay")
        , method(className() + ".getStartTime")
        , method(className() + ".getEndTime")
        , method(className() + ".getLength")
        , method(className() + ".toString")
        , method(className() + ".hashCode")
        , method(className() + ".equals", Object.class)
        , method(className() + ".compareTo", Interval.class)
        , method(className() + ".endsBefore", Interval.class)
        , method(className() + ".overlapsWith", Interval.class)
        
        /* do not implement this method */
        , optionalMethod(className() + ".compareTo", Object.class)
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new IntervalTest());
    }
}
