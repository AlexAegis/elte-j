package tests;

import utest.*;
import interval.time.*;
import interval.*;
import classroom.LectureRoom;


public class LectureRoomTest extends Testable {
    public void assertion() {
        LectureRoom room = new LectureRoom("test", 20);
        check("getName(): a metodus rosszul adja vissza a nevet.", room.getName().equals("test"));
        check("toString(): nem jol jeleniti meg az objektumot, ha nincsenek foglalasok.", room.toString().equals("eloadoterem (test) []"));
        
        check("book(): nem foglalja le az idopontot, amikor elotte nem voltak foglalasok.", room.book(Interval.make(Day.MONDAY,8,15,90), "java"));
        check("toString(): nem jol jeleniti meg az objektumot, ha egy foglalas van.", room.toString().equals("eloadoterem (test) [hetfo 8:15 - 9:45 (java)]"));
        
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,8,15,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,8,0,180), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,8,30,30), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,8,0,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,9,15,90), "java"));
        check("toString(): a foglalasok nyilvantartasa elromlik, ha rossz idopontot probalunk foglalni.", room.toString().equals("eloadoterem (test) [hetfo 8:15 - 9:45 (java)]"));
        
        check("book(): akkor sem foglalja le az idopontot, ha utkozik egy korabbi foglalassal.", room.book(Interval.make(Day.TUESDAY,8,15,90), "ada"));
        check("toString(): nem jol jeleniti meg az objektumot, ha ket foglalas van.", room.toString().equals("eloadoterem (test) [hetfo 8:15 - 9:45 (java), kedd 8:15 - 9:45 (ada)]"));
        
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,8,15,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,8,0,180), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,8,30,30), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,8,0,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,9,15,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.TUESDAY,8,15,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.TUESDAY,8,0,180), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.TUESDAY,8,30,30), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.TUESDAY,8,0,90), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.TUESDAY,9,15,90), "java"));
        check("toString(): a foglalasok nyilvantartasa elromlik, ha rossz idopontot probalunk foglalni.", room.toString().equals("eloadoterem (test) [hetfo 8:15 - 9:45 (java), kedd 8:15 - 9:45 (ada)]"));
        
        check("book(): akkor sem foglalja le az idopontot, ha utkozik egy korabbi foglalassal.", room.book(Interval.make(Day.MONDAY,9,45,30), "java consultation"));
        check("toString(): nem jol jeleniti meg az objektumot, ha tobb foglalas van.", room.toString().equals("eloadoterem (test) [hetfo 8:15 - 9:45 (java), hetfo 9:45 - 10:15 (java consultation), kedd 8:15 - 9:45 (ada)]"));
        
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,9,30,40), "java"));
        check("book(): akkor is lefoglalja az idopontot, ha utkozik egy korabbi foglalassal.", !room.book(Interval.make(Day.MONDAY,10,0,60), "java"));
        check("toString(): a foglalasok nyilvantartasa elromlik, ha rossz idopontot probalunk foglalni.", room.toString().equals("eloadoterem (test) [hetfo 8:15 - 9:45 (java), hetfo 9:45 - 10:15 (java consultation), kedd 8:15 - 9:45 (ada)]"));
        
        check("numberOfSpots(): 200 szek eseten 180-at kell visszaadni.", new LectureRoom("test", 200).numberOfSpots() == 180);
        check("numberOfSpots(): 108 szek eseten 97-et kell visszaadni (lefele kell kerekiteni).", new LectureRoom("test", 108).numberOfSpots() == 97);
        check("numberOfSpots(): 105 szek eseten 94-et kell visszaadni (lefele kell kerekiteni).", new LectureRoom("test", 105).numberOfSpots() == 94);
        check("numberOfSpots(): 102 szek eseten 91-et kell visszaadni (lefele kell kerekiteni).", new LectureRoom("test", 102).numberOfSpots() == 91);
        
        check("hasComputers(): eloadoterem eseten hamisat kell visszaadnia.", !room.hasComputers());
    }

    public String description() { return "classroom.LectureRoom"; }
    public String className() { return "classroom.LectureRoom"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        { constructor(className(), String.class, int.class)
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
        Test.main(new LectureRoomTest());
    }
}
