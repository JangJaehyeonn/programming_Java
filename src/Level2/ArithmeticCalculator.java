package Level2;


import java.util.List;

public class ArithmeticCalculator extends Calculator {



    public ArithmeticCalculator(List<Double> results) {
        super(results);
    }


    public int calculate(int num1, int num2, char operator) {
        return operatorFactory(operator).operate(num1, num2);
    }

    private Operator operatorFactory(char operator) {
        return switch(operator){
            case '+' -> new AddOperator();
            case '-' -> new SubtractOperator();
            case '*' -> new MultiplyOperator();
            case '/' -> new DivideOperator();
            case '%' -> new ModOperator();
            default -> throw new UnsupportedOperationException("올바른 선택이 아닙니다.");
        };
    }

    @Override
    public void inquiryResults(){
        for(Double result : super.getResults()){
            System.out.println("연산 결과 = " + result);
        }
    }
}
