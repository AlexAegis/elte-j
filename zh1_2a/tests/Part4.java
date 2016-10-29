package tests;

import company.Company;
import utest.*;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Part4 extends Testable {
    public void assertion() {
        String abigail = "Abigail";
        String bob = "Bob";
        String chris = "Chris";
        String jackie = "Jackie";
        String james = "James";
        String sophia = "Sophia";

        try {
            Company c = new Company("Aperture Science", "company.txt");
            String s = c.toString();

            check("Company.toString: nem Company(-lel kezdodik.", s.startsWith("Company("));
            check("Company.toString: nem tartalmazza a ceg nevet.", s.contains("Aperture Science"));
            check("Company.toString: nem tartalmazza a dolgozokat.", s.contains(sophia));
            check("Company.toString: nem tartalmazza a dolgozokat.", s.contains(abigail));
            
            List<String> employees = new LinkedList<>();
            employees.add(abigail);
            employees.add(bob);
            employees.add(chris);
            employees.add(jackie);
            employees.add(james);
            employees.add(sophia);

            List<String> actualEmployees = c.employees();
            Collections.sort(actualEmployees);
            check("Company.employees: nem adja vissza a dolgozok listajat.", employees.equals(actualEmployees));
        } catch (Throwable e) {
            check("Company konstruktora kivetelt dobott. Talan nem jo helyre lett masolva a company.txt?", false);
        }
    }

    public String description() { return "4. resz"; }
    public String className() { return "company.Company"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class, String.class})
            , method(className() + ".toString")
            , optionalMethod(className() + ".employeesOf", String.class)
            , method(className() + ".employees")
            , optionalMethod(className() + ".bosses")
            , optionalMethod(className() + ".bestBoss")
            };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new Part4());
    }
}
