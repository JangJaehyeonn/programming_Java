package Level2;

import java.util.List;

public class ArithmeticCalculator<T extends Number> extends Calculator {

    public final Class<T> type;

    public ArithmeticCalculator(List<Double> results, Class<T> type) {
        super(results);
        this.type = type;
    }

    public T calculate(T num1, T num2, char operator) {
       return operatorFactory(operator).operate(num1, num2);
    }

    private Operator<T> operatorFactory(char operator) {
        OperatorType operatorType = OperatorType.fromOperator(operator);
        return switch (operatorType) {
            case ADDITION -> new AddOperator(type);
            case SUBTRACTION -> new SubtractOperator(type);
            case MULTIPLICATION -> new MultiplyOperator(type);
            case DIVISION -> new DivideOperator(type);
            case MODULO -> new ModOperator(type);
        };
    }

    @Override
    public void inquiryResults() {
        for (Double result : super.getResults()) {
            System.out.println("연산 결과 = " + result);
        }
    }


    /**
     * 저장된 결과 중 입력값보다 큰 결과값들을 출력/조회 하는 메서드
     */
    public void printResultGreaterThan(double num) {
        super.getResults().stream()
                .filter(result -> result > num)
                .forEach(result -> System.out.println("연산결과 = " + result));
    }
}
