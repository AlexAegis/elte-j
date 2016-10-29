package tests;

import company.Company;
import utest.*;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Part3 extends Testable {
    public void assertion() {
        String abigail = "Abigail";
        String bob = "Bob";
        String chris = "Chris";
        String jackie = "Jackie";
        String james = "James";
        String sophia = "Sophia";
        
        try {
            Company c = new Company("Aperture Science", "company.txt");
            List<String> actualEmployees;

            List<String> employeesOfSophia = new LinkedList<>();
            employeesOfSophia.add(jackie);
            employeesOfSophia.add(james);
            
            actualEmployees = c.employeesOf(sophia);
            Collections.sort(actualEmployees);
            check("Company.employeesOf: null az eredmeny.", actualEmployees != null);
            check("Company.employeesOf: nem adja vissza Sophia kozvetlen beosztottjait.", employeesOfSophia.equals(actualEmployees));

            List<String> employeesOfJackie = new LinkedList<>();
            employeesOfJackie.add(abigail);
            employeesOfJackie.add(bob);
            employeesOfJackie.add(chris);

            actualEmployees = c.employeesOf(jackie);
            check("Company.employeesOf: null az eredmeny.", actualEmployees != null);
            Collections.sort(actualEmployees);
            check("Company.employeesOf: nem adja vissza Jackie kozvetlen beosztottjait.", employeesOfJackie.equals(actualEmployees));

            actualEmployees = c.employeesOf("Micimacko");
            check("Company.employeesOf: null az eredmeny.", actualEmployees != null);
            check("Company.employeesOf: nem letezo fonoknek nem kellene lennie kozvetlen beosztottjainak.", actualEmployees.isEmpty());
        } catch (Throwable e) {
            e.printStackTrace();
            check("Company konstruktora kivetelt dobott. Talan nem jo helyre lett masolva a company.txt?", false);
        }
    }

    public String description() { return "3. resz"; }
    public String className() { return "company.Company"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {String.class, String.class})
            , optionalMethod(className() + ".toString")
            , method(className() + ".employeesOf", String.class)
            , optionalMethod(className() + ".employees")
            , optionalMethod(className() + ".bosses")
            , optionalMethod(className() + ".bestBoss")
            };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[] {};
    }

    public static void main(String... args) {
        Test.main(new Part3());
    }
}
