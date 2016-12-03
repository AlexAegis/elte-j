package tests;

import utest.*;
import interval.time.Day;

public class DayTest extends Testable {
    public void assertion() {
        check("toString(): a metodus a MONDAY ertekhez nem a \"hetfo\" szoveget rendeli.", Day.MONDAY.toString().equals("hetfo"));
        check("toString(): a metodus a TUESDAY ertekhez nem a \"kedd\" szoveget rendeli.", Day.TUESDAY.toString().equals("kedd"));
        check("toString(): a metodus a WEDNESDAY ertekhez nem a \"szerda\" szoveget rendeli.", Day.WEDNESDAY.toString().equals("szerda"));
        check("toString(): a metodus a THURSDAY ertekhez nem a \"csutortok\" szoveget rendeli.", Day.THURSDAY.toString().equals("csutortok"));
        check("toString(): a metodus a FRIDAY ertekhez nem a \"pentek\" szoveget rendeli.", Day.FRIDAY.toString().equals("pentek"));
    }

    public String description() { return "interval.time.Day"; }
    public String className() { return "interval.time.Day"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
        /* do not implement this methods */
        { optionalStaticMethod(className() + ".values")
        , optionalStaticMethod(className() + ".valueOf", String.class)
        , optionalMethod("java.lang.Enum.name")
        , optionalMethod("java.lang.Enum.equals", Object.class)
        , optionalMethod("java.lang.Enum.hashCode")
        , optionalMethod("java.lang.Enum.compareTo", Object.class)
        , optionalMethod("java.lang.Enum.compareTo", Enum.class)
        , optionalStaticMethod("java.lang.Enum.valueOf", Class.class, String.class)
        , optionalMethod("java.lang.Enum.getDeclaringClass")
        , optionalMethod("java.lang.Enum.ordinal")
        
        /* implement this method */
        , method(className() + ".toString")
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[]
        { staticField(className() + ".MONDAY")
        , staticField(className() + ".TUESDAY")
        , staticField(className() + ".WEDNESDAY")
        , staticField(className() + ".THURSDAY")
        , staticField(className() + ".FRIDAY")
        };
    }

    public static void main(String... args) {
        Test.main(new DayTest());
    }
}
