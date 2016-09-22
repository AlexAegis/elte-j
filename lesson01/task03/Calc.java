import java.util.*;

class Calc {

    private String operator;
    private List<Integer> operands;
    private Integer result;


    public Calc() {
        this.operands = new ArrayList<Integer>();
    }


    public Calc setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public Calc addOperand(int operand) {
        operands.add(operand);
        return this;
    }

    public int getResult() throws NullDivisorException, NotKnownOperatorException {
        result = 0;
        if(this.operator.equals("+")) {
            for (int v : operands) {
                result = result + v;
            }
        } else if(this.operator.equals("-")) {
            result = operands.get(0);
            for (int i = 1; i < operands.size(); i++) {
                result = result - operands.get(i);
            }
        } else if(this.operator.equals("*")) {
            result = 1;
            for (int v : operands) {
                result = result * v;
            }
        } else if(this.operator.equals("/")) {
            result = operands.get(0);
            for (int i = 1; i < operands.size(); i++) {
                if (operands.get(i) != 0) {
                    result = result / operands.get(i);
                } else {
                    throw new NullDivisorException();
                }
            }
        } else {
            throw new NotKnownOperatorException();
        }
        return result.intValue();
    }

}
