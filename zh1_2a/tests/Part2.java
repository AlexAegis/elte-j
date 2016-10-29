package tests;

import company.Contract;
import utest.*;

import java.util.Arrays;

public class Part2 extends Testable {
    public void assertion() {
        check("Contract.VADER: a munkavallalo nem Vader.", "Vader".equals(Contract.VADER.getEmployee()));
        check("Contract.VADER: a munkavallaltato nem Emperor.", "Emperor".equals(Contract.VADER.getEmployer()));
        check("Contract.VADER: a fizetes nem 5000.", 5000 == Contract.VADER.getWage());

        check("Contract.make(): ures szoveg eseten nem johet letre objektum.", Contract.make(new String()) == null);
        check("Contract.make(): csak munkavallalo eseten nem johet letre objektum.", Contract.make("Gomboc Artur") == null);
        check("Contract.make(): munkavallalo es munkaltato eseten nem johet letre objektum.", Contract.make("Gomboc Artur,Picur") == null);
        check("Contract.make(): munkavallalo es fizetes eseten nem johet letre objektum.", Contract.make("Radirpok,15") == null);
        check("Contract.make(): nem szam fizetes eseten nem johet letre objektum.", Contract.make("Gomboc Artur,Picur,Radirpok") == null);
        check("Contract.make(): negativ fizetes eseten nem johet letre objektum.", Contract.make("Gomboc Artur,Picur,-5") == null);

        Contract c = Contract.make("Gomboc Artur,Pom Pom,10");
        check("Contract.make(): helyes argumentumokkal nem jott letre objektum.", c != null);
        check("Contract.getWage(): nem jol mukodik.", c.getWage() == 10);
        check("Contract.getEmployee(): nem jol mukodik.", "Gomboc Artur".equals(c.getEmployee()));
        check("Contract.getEmployer(): nem jol mukodik.", "Pom Pom".equals(c.getEmployer()));
        check("Contract.hasEmployer(): hamisat ad az igazi munkaltatora.", c.hasEmployer(new String("Pom Pom")));
        check("Contract.hasEmployer(): igazat ad a nem igazi munkaltatora.", !c.hasEmployer(new String("Picur")));

        check("Contract.toString(): nem Contract(-lel kezdodik.", c.toString().startsWith("Contract("));
        check("Contract.toString(): nem tartalmazza a munkavallalot.", c.toString().contains("Gomboc Artur"));
        check("Contract.toString(): nem tartalmazza a munkaltatot.", c.toString().contains("Pom Pom"));
        check("Contract.toString(): nem tartalmazza a fizetest.", c.toString().contains("10"));
    }

    public String description() { return "2. resz"; }
    public String className() { return "company.Contract"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class, String.class, Integer.TYPE})
            , staticMethod(className() + ".make", String.class)
            , method(className() + ".toString")
            , method(className() + ".hasEmployer", String.class)
            , method(className() + ".getWage")
            , method(className() + ".getEmployee")
            , method(className() + ".getEmployer")
            };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[]
            { staticField(className() + ".VADER")
            };
    }

    public static void main(String... args) {
        Test.main(new Part2());
    }
}
