package company;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Company {

    private String name;
    private LinkedList<Contract> contracts = new LinkedList<>();

    public Company(String name, String fileName) throws IOException {
        this.name = name;
        try(Scanner scn = new Scanner(new File(fileName))) {
            while(scn.hasNextLine()) {
                Contract contract = Contract.make(scn.nextLine());
                if(contract != null) {
                    contracts.add(contract);
                }
            }
        }
    }

    public LinkedList<String> employeesOf(String employer) {
        return new LinkedList<String>(contracts.stream()
                .filter(e -> e.hasEmployer(employer)).map(Contract::getEmployee)
                .collect(Collectors.toList()));
    }

    public LinkedList<String> employees() {
        return new LinkedList<>(contracts.stream()
                .flatMap(contract -> Stream.of(contract.getEmployee(), contract.getEmployer()))
                .distinct().collect(Collectors.toList()));
    }

    public LinkedList<String> bosses() {
        return new LinkedList<>(contracts.stream()
                .map(Contract::getEmployer)
                .distinct().collect(Collectors.toList()));
    }

    public String bestBoss() {
        return bosses().stream().max((a, b) -> {
            int aSize = employeesOf(a).size();
            int bSize = employeesOf(a).size();
            if(aSize > bSize) return -1;
            else if(aSize < bSize) return 1;
            else return 0;
        }).orElse("");
    }

    @Override
    public String toString() {
        String result = "Company(" + name + ",[";
        for(Contract contract : contracts) {
            result = result.concat(contract.toString());
        }
        return result + "])";
    }
}