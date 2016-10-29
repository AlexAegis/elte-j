package tests;

import company.Contract;
import utest.*;

public class Part1 extends Testable {
    public void assertion() {
        Contract c = new Contract("Gomboc Artur", "Picur", 10);
        check("Contract.getWage(): nem jol mukodik.", c.getWage() == 10);
        check("Contract.getEmployee(): nem jol mukodik.", "Gomboc Artur".equals(c.getEmployee()));
        check("Contract.getEmployer(): nem jol mukodik.", "Picur".equals(c.getEmployer()));
    }

    public String description() { return "1. resz"; }
    public String className() { return "company.Contract"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[] {
            constructor(className(), new Class[] {String.class, String.class, Integer.TYPE})
            , optionalStaticMethod(className() + ".make", String.class)
            , optionalMethod(className() + ".toString")
            , optionalMethod(className() + ".hasEmployer", String.class)
            , method(className() + ".getWage")
            , method(className() + ".getEmployee")
            , method(className() + ".getEmployer")
        };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[]
            { optionalStaticField(className() + ".VADER")
            };
    }

    public static void main(String... args) {
        Test.main(new Part1());
    }
}
