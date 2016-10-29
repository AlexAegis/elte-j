package company;

public class Contract {

    private String employee;
    private String employer;
    private int salary;

    public static final Contract VADER = new Contract("Vader", "Emperor", 5000);

    public Contract(String employee, String employer, int salary) {
        this.employee = employee;
        this.employer = employer;
        this.salary = salary;
    }

    public static Contract make(String s) {
        String[] in = s.split(",");
        if(in.length == 3
                && !in[0].isEmpty()
                && !in[1].isEmpty()
                && in[2].chars().allMatch(Character::isDigit)) {
            return new Contract(in[0], in[1], Integer.parseUnsignedInt(in[2]));
        } else {
            return null;
        }
    }

    public boolean hasEmployer(String employer) {
        return this.employer.equals(employer);
    }

    public String getEmployee() {
        return employee;
    }

    public String getEmployer() {
        return employer;
    }

    public int getWage() {
        return salary;
    }

    @Override
    public String toString() {
        return "Contract(" + employee + "," + employer + "," + salary + ")";
    }
}