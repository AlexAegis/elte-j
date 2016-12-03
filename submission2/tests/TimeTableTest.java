package tests;

import java.lang.reflect.*;
import utest.*;
import interval.time.Day;
import interval.*;
import classroom.*;
import timetable.*;

public class TimeTableTest extends Testable {
    public void assertion() {
        TimeTable tt = new TimeTable();
        check("toString(): nem jol jelennek meg az adatok, ha ures az orarend.", tt.toString().equals(""));
        
        try{
            Method m = TimeTable.class.getDeclaredMethod("accept", ClassRoom.class, int.class, boolean.class);
            m.setAccessible(true);
            
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", (boolean)m.invoke(tt, new ComputerLab("test",20,20), 18, true));  
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new ComputerLab("test",20,20), 18, false));
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new ComputerLab("test",20,20), 24, true));
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new ComputerLab("test",20,20), 24, false));
            
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new LectureRoom("test",80), 40, true));
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", (boolean)m.invoke(tt, new LectureRoom("test",80), 40, false));
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new LectureRoom("test",80), 100, true));
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new LectureRoom("test",80), 100, false));
            
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new SeminarRoom("test",20), 15, true));
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", (boolean)m.invoke(tt, new SeminarRoom("test",20), 15, false));
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new SeminarRoom("test",20), 25, true));
            check("accept(): nem jol donti el, hogy megfelelo-e a terem.", !(boolean)m.invoke(tt, new SeminarRoom("test",20), 25, false));
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        try {
            tt.book("ada gyak", Interval.make(Day.MONDAY,8,15,90), 10, true);
            check("book(): akkor sem dob kivetelt, amikor nem sikerult a foglalalas.", false);
        } catch( BookingException e ) {
            check("book(): nem jo a hibauzenet, amikor azert nem sikerult a foglalas, mert nem volt megfelelo terem.", e.getMessage().equals("No room available in the given interval."));
        }
        
        tt.add(new ComputerLab("pc1", 20, 20));
        check("toString(): nem jol jelennek meg az adatok, ha csak egy terem van.", tt.toString().equals("gepterem (pc1) []\n"));
        try {
            tt.add(new ComputerLab("pc1", 21, 21));
            check("add(): akkor is hozzaadja a termet, ha van mar ilyen nevu terem.", false);
        } catch (IllegalArgumentException e) {
            check("add(): a hibauzenet szovege nem megfelelo.", e.getMessage().equals("multiple names: pc1"));
        }
        
        tt.add(new ComputerLab("pc9", 25, 20));
        check("toString(): nem jol jelennek meg az adatok, ha ket terem van.", tt.toString().equals("gepterem (pc1) []\ngepterem (pc9) []\n"));
        try {
            tt.add(new ComputerLab("pc9", 5, 5));
            check("add(): akkor is hozzaadja a termet, ha van mar ilyen nevu terem.", false);
        } catch (IllegalArgumentException e) { }
        check("toString(): nem jol jelennek meg az adatok, ha ket terem van.", tt.toString().equals("gepterem (pc1) []\ngepterem (pc9) []\n"));
        
        try {
            tt.book("ada ea", Interval.make(Day.WEDNESDAY,8,15,90), 100, false);
            check("book(): akkor sem dob kivetelt, amikor nem sikerult a foglalalas.", false);
        } catch( BookingException e ) {
            check("book(): nem jo a hibauzenet, amikor azert nem sikerult a foglalas, mert nem volt megfelelo terem.", e.getMessage().equals("No room available in the given interval."));
        }
        
        tt.add(new LectureRoom("Bolyai", 200));
        tt.add(new LectureRoom("Mogyorodi", 80));
        tt.add(new SeminarRoom("00-113", 20));
        tt.add(new SeminarRoom("00-114", 22));
        tt.add(new SeminarRoom("00-115", 18));
        check("toString(): nem jol jelennek meg az adatok, ha tobb terem van.", tt.toString().equals("gepterem (pc1) []\ngepterem (pc9) []\neloadoterem (Bolyai) []\neloadoterem (Mogyorodi) []\ngyakorlati terem (00-113) []\ngyakorlati terem (00-114) []\ngyakorlati terem (00-115) []\n"));
        try {
            tt.add(new ComputerLab("Bolyai", 5, 5));
            check("add(): akkor is hozzaadja a termet, ha van mar ilyen nevu terem.", false);
        } catch (IllegalArgumentException e) { }
        
        try {
            tt.book("java gyak", Interval.make(Day.MONDAY,8,15,90), 15, true);
            check("book(): nem jo terembe osztotta be a foglalast.", tt.toString().equals("gepterem (pc1) [hetfo 8:15 - 9:45 (java gyak)]\ngepterem (pc9) []\neloadoterem (Bolyai) []\neloadoterem (Mogyorodi) []\ngyakorlati terem (00-113) []\ngyakorlati terem (00-114) []\ngyakorlati terem (00-115) []\n"));
        } catch( BookingException e ) {
            check("book(): akkor sem sikerult a foglalas, amikor volt megfelelo fajtaju szabad terem.", false);
        }
        
        try {
            tt.book("forditoprogramok gyak", Interval.make(Day.MONDAY,8,15,90), 22, true);
            check("book(): nem jo terembe osztotta be a foglalast.", tt.toString().equals("gepterem (pc1) [hetfo 8:15 - 9:45 (java gyak)]\ngepterem (pc9) [hetfo 8:15 - 9:45 (forditoprogramok gyak)]\neloadoterem (Bolyai) []\neloadoterem (Mogyorodi) []\ngyakorlati terem (00-113) []\ngyakorlati terem (00-114) []\ngyakorlati terem (00-115) []\n"));
        } catch( BookingException e ) {
            check("book(): akkor sem sikerult a foglalas, amikor volt megfelelo fajtaju szabad terem.", false);
        }
        
        try {
            tt.book("ada gyak", Interval.make(Day.MONDAY,8,15,90), 10, true);
            check("book(): akkor sem dob kivetelt, amikor nem sikerult a foglalalas.", false);
        } catch( BookingException e ) {
            check("book(): nem jo a hibauzenet, amikor azert nem sikerult a foglalas, mert egyik megfelelo teremben sem volt szabad idopont.", e.getMessage().equals("There is no room of the specified type available in the given interval."));
        }
        
        try {
            tt.book("ada gyak", Interval.make(Day.WEDNESDAY,8,15,90), 30, true);
            check("book(): akkor sem dob kivetelt, amikor nem sikerult a foglalalas.", false);
        } catch( BookingException e ) {
            check("book(): nem jo a hibauzenet, amikor azert nem sikerult a foglalas, mert nem volt megfelelo terem.", e.getMessage().equals("No room available in the given interval."));
        }
        
        try {
            tt.book("ada gyak", Interval.make(Day.WEDNESDAY,8,15,90), 22, true);
            check("book(): nem jo terembe osztotta be a foglalast.", tt.toString().equals("gepterem (pc1) [hetfo 8:15 - 9:45 (java gyak)]\ngepterem (pc9) [hetfo 8:15 - 9:45 (forditoprogramok gyak), szerda 8:15 - 9:45 (ada gyak)]\neloadoterem (Bolyai) []\neloadoterem (Mogyorodi) []\ngyakorlati terem (00-113) []\ngyakorlati terem (00-114) []\ngyakorlati terem (00-115) []\n"));
        } catch( BookingException e ) {
            check("book(): akkor is kivetelt dobott, amikor volt megfelelo terem.", false);
        }
        
        try {
            tt.book("ada ea", Interval.make(Day.TUESDAY,9,0,60), 50, false);
            check("book(): nem jo terembe osztotta be a foglalast.", tt.toString().equals("gepterem (pc1) [hetfo 8:15 - 9:45 (java gyak)]\ngepterem (pc9) [hetfo 8:15 - 9:45 (forditoprogramok gyak), szerda 8:15 - 9:45 (ada gyak)]\neloadoterem (Bolyai) [kedd 9:00 - 10:00 (ada ea)]\neloadoterem (Mogyorodi) []\ngyakorlati terem (00-113) []\ngyakorlati terem (00-114) []\ngyakorlati terem (00-115) []\n"));
        } catch( BookingException e ) {
            check("book(): akkor is kivetelt dobott, amikor volt megfelelo terem.", false);
        }
        
        try {
            tt.book("java ea", Interval.make(Day.TUESDAY,9,0,60), 50, false);
            check("book(): nem jo terembe osztotta be a foglalast.", tt.toString().equals("gepterem (pc1) [hetfo 8:15 - 9:45 (java gyak)]\ngepterem (pc9) [hetfo 8:15 - 9:45 (forditoprogramok gyak), szerda 8:15 - 9:45 (ada gyak)]\neloadoterem (Bolyai) [kedd 9:00 - 10:00 (ada ea)]\neloadoterem (Mogyorodi) [kedd 9:00 - 10:00 (java ea)]\ngyakorlati terem (00-113) []\ngyakorlati terem (00-114) []\ngyakorlati terem (00-115) []\n"));
        } catch( BookingException e ) {
            check("book(): akkor is kivetelt dobott, amikor volt megfelelo terem.", false);
        }
        
        try {
            tt.book("fp", Interval.make(Day.TUESDAY,8,15,60), 50, false);
            check("book(): akkor sem dob kivetelt, amikor nem sikerult a foglalalas.", false);
        } catch( BookingException e ) {
            check("book(): nem jo a hibauzenet, amikor azert nem sikerult a foglalas, mert egyik megfelelo teremben sem volt szabad idopont.", e.getMessage().equals("There is no room of the specified type available in the given interval."));
        }
        
        try {
            tt.book("fp", Interval.make(Day.TUESDAY,8,0,60), 21, false);
            check("book(): nem jo terembe osztotta be a foglalast.", tt.toString().equals("gepterem (pc1) [hetfo 8:15 - 9:45 (java gyak)]\ngepterem (pc9) [hetfo 8:15 - 9:45 (forditoprogramok gyak), szerda 8:15 - 9:45 (ada gyak)]\neloadoterem (Bolyai) [kedd 8:00 - 9:00 (fp), kedd 9:00 - 10:00 (ada ea)]\neloadoterem (Mogyorodi) [kedd 9:00 - 10:00 (java ea)]\ngyakorlati terem (00-113) []\ngyakorlati terem (00-114) []\ngyakorlati terem (00-115) []\n"));
            tt.book("analizis", Interval.make(Day.TUESDAY,9,0,60), 21, false);
            check("book(): nem jo terembe osztotta be a foglalast.", tt.toString().equals("gepterem (pc1) [hetfo 8:15 - 9:45 (java gyak)]\ngepterem (pc9) [hetfo 8:15 - 9:45 (forditoprogramok gyak), szerda 8:15 - 9:45 (ada gyak)]\neloadoterem (Bolyai) [kedd 8:00 - 9:00 (fp), kedd 9:00 - 10:00 (ada ea)]\neloadoterem (Mogyorodi) [kedd 9:00 - 10:00 (java ea)]\ngyakorlati terem (00-113) []\ngyakorlati terem (00-114) [kedd 9:00 - 10:00 (analizis)]\ngyakorlati terem (00-115) []\n"));
        } catch( BookingException e ) {
            check("book(): akkor is kivetelt dobott, amikor volt megfelelo terem.", false);
        }
    }    

    public String description() { return "timetable.TimeTable"; }
    public String className() { return "timetable.TimeTable"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { constructor(className())
        , method(className() + ".add", ClassRoom.class)
        , method(className() + ".book", String.class, Interval.class, int.class, boolean.class)
        , method(className() + ".toString")
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new TimeTableTest());
    }
}
