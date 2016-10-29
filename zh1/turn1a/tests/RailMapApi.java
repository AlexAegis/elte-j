package tests;

import static utest.Testable.method;
import static utest.Testable.constructor;

public class RailMapApi {
    public static String className = "rail.RailMap";

    public static Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className, new Class[] {String.class, String.class})
            , method(className + ".toString")
            , method(className + ".getNeighbours", String.class)
            , method(className + ".getCities")
            , method(className + ".capitalCity")
            };
    }

    public static Object[] expectedFields() throws Exception {
        return new Object[] {};
    }
}
