package tests;

import utest.*;
import interval.time.*;
import interval.*;
import classroom.ComputerLab;


public class ComputerLabTest extends Testable {
    public void assertion() {
        ComputerLab lab = new ComputerLab("test", 20, 20);
        check("getName(): a metodus rosszul adja vissza a nevet.", lab.getName().equals("test"));
        check("toString(): nem jol jeleniti meg az objektumot, ha nincsenek foglalasok.", lab.toString().equals("gepterem (test) []"));
        
        check("book(): nem foglalja le az idopontot, amikor elotte nem voltak foglalasok.", lab.book(Interval.make(Day.MONDAY,8,15,90), "java"));
        check("toString(): nem jol jeleniti meg az objektumot, ha egy foglalas van.", lab.toString().equals("gepterem (test) [hetfo 8:15 - 9:45 (java)]"));
        
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,8,15,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,8,0,180), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,8,30,30), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,8,0,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,9,15,90), "java"));
        check("toString(): a foglalasok nyilvantartasa elromlik, ha rossz idopontot probalunk foglalni.", lab.toString().equals("gepterem (test) [hetfo 8:15 - 9:45 (java)]"));
        
        check("book(): akkor sem foglalja le az idopontot, ha utkozik egy korabbi foglalassal.", lab.book(Interval.make(Day.TUESDAY,8,15,90), "ada"));
        check("toString(): nem jol jeleniti meg az objektumot, ha ket foglalas van.", lab.toString().equals("gepterem (test) [hetfo 8:15 - 9:45 (java), kedd 8:15 - 9:45 (ada)]"));
        
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,8,15,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,8,0,180), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,8,30,30), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,8,0,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,9,15,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.TUESDAY,8,15,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.TUESDAY,8,0,180), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.TUESDAY,8,30,30), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.TUESDAY,8,0,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.TUESDAY,9,15,90), "java"));
        check("toString(): a foglalasok nyilvantartasa elromlik, ha rossz idopontot probalunk foglalni.", lab.toString().equals("gepterem (test) [hetfo 8:15 - 9:45 (java), kedd 8:15 - 9:45 (ada)]"));
        
        check("book(): akkor sem foglalja le az idopontot, ha utkozik egy korabbi foglalassal.", lab.book(Interval.make(Day.MONDAY,9,45,30), "java consultation"));
        check("toString(): nem jol jeleniti meg az objektumot, ha tobb foglalas van.", lab.toString().equals("gepterem (test) [hetfo 8:15 - 9:45 (java), hetfo 9:45 - 10:15 (java consultation), kedd 8:15 - 9:45 (ada)]"));
        
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,9,30,40), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !lab.book(Interval.make(Day.MONDAY,10,0,60), "java"));
        check("toString(): a foglalasok nyilvantartasa elromlik, ha rossz idopontot probalunk foglalni.", lab.toString().equals("gepterem (test) [hetfo 8:15 - 9:45 (java), hetfo 9:45 - 10:15 (java consultation), kedd 8:15 - 9:45 (ada)]"));
        
        check("numberOfSpots(): 20 gep es 25 szek eseten 22-t kell visszaadni.", new ComputerLab("test", 25, 20).numberOfSpots() == 22);
        check("numberOfSpots(): 20 gep es 21 szek eseten 21-et kell visszaadni.", new ComputerLab("test", 21, 20).numberOfSpots() == 21);
        
        check("numberOfSpots(): 20 gep es 22 szek eseten 22-t kell visszaadni.", new ComputerLab("test", 22, 20).numberOfSpots() == 22);
        
        check("numberOfSpots(): 21 gep es 22 szek eseten 23-at kell visszaadni (lefele kell kerekiteni).", new ComputerLab("test", 25, 21).numberOfSpots() == 23);
        check("numberOfSpots(): 25 gep es 30 szek eseten 27-et kell visszaadni (lefele kell kerekiteni).", new ComputerLab("test", 30, 25).numberOfSpots() == 27);
        check("numberOfSpots(): 29 gep es 35 szek eseten 31-et kell visszaadni (lefele kell kerekiteni).", new ComputerLab("test", 35, 29).numberOfSpots() == 31);
        
        check("hasComputers(): gepterem eseten igazat kell visszaadnia.", lab.hasComputers());
    }

    public String description() { return "classroom.ComputerLab"; }
    public String className() { return "classroom.ComputerLab"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { constructor(className(), String.class, int.class, int.class)
        , method(className() + ".toString")
        , method(className() + ".hasComputers")
        , method(className() + ".numberOfSpots")
        
        , method("classroom.ClassRoom.getName")
        , method("classroom.ClassRoom.book", Interval.class, String.class)
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new ComputerLabTest());
    }
}
