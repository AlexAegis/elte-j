package tests;

import static utest.Testable.method;
import static utest.Testable.staticMethod;
import static utest.Testable.constructor;
import static utest.Testable.staticField;

public class RailwayApi {
    public static String className = "rail.Railway";

    public static Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className, new Class[] {String.class, String.class, Integer.TYPE})
            , staticMethod(className + ".make", String.class)
            , method(className + ".toString")
            , method(className + ".getCities")
            , method(className + ".getDistance")
            , staticMethod(className + ".make", String.class)
            , method(className + ".hasEnd", String.class)
            , method(className + ".getOtherCity", String.class)
            };
    }

    public static Object[] expectedFields() throws Exception {
        return new Object[] 
            { staticField(className + ".KESZTHELY_BUDAPEST")
            };
    }
}
