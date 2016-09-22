import java.util.*;

public class Calculator {

    private static Scanner scn;
    private static String operator;
    private static List<Integer> operands;
    private static Calc calc;

    private Calculator() {

    }

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        operator = scn.nextLine();
        operands = new ArrayList<Integer>();
        operands.add(scn.nextInt()); scn.nextLine();
        operands.add(scn.nextInt()); scn.nextLine();

        calc = new Calc().setOperator(operator)
                        .addOperand(operands.get(0))
                        .addOperand(operands.get(1));
        try {
            System.out.println(calc.getResult());
        } catch (NotKnownOperatorException e) {
            System.out.println("Only +, -, *, / operators supported.");
            e.printStackTrace();
        } catch (NullDivisorException e) {
            System.out.println("Only non zero divisors supported.");
            e.printStackTrace();
        }
    }
}
