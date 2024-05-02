package Level2;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        ArithmeticCalculator<Integer> arithmeticCalculator = new ArithmeticCalculator<>(new ArrayList<>(), Integer.class);
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>(new ArrayList<>(), Double.class);
        CircleCalculator circleCalculator = new CircleCalculator(new ArrayList<>());

        do {

            System.out.println("어떤 계산을 하시겠습니가? (1: 사칙연산, 2: 원의 넚이)");
            int choice = sc.nextInt();

            if(choice == 1) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();

                System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
                /* charAt(idx) : charAt 메서드는 매개변수로 char 타입으로 반환 하고자하는 문자열의 위치(index)를 받는다. */
                char operator = sc.next().charAt(0);

                double result = arithmeticCalculator.calculate(num1, num2, operator);
                arithmeticCalculator.getResults().add(result);

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if (Objects.equals(sc.next(), "remove")) {
                    arithmeticCalculator.removeResult(0);
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                if (Objects.equals(sc.next(), "inquiry")) {
                    arithmeticCalculator.inquiryResults();
                }

                System.out.println("저장된 연산결과 중 입력한 값보다 큰 값들을 조회하시겠습니까? (lambda 입력시 조회)");
                if (Objects.equals(sc.next(), "lambda")) {
                    System.out.println("기준 값을 입력하세요: ");
                    double num = sc.nextDouble();
                    arithmeticCalculator.printResultGreaterThan(num);
                }

            } else {
                System.out.println("원의 반지름을 입력하세요: ");
                int radius = sc.nextInt();

                double area = circleCalculator.calculate(radius);
                circleCalculator.getResults().add(area);
                System.out.println("반지름이 " + radius + "인 원의 넓이는 : " + area);

                System.out.println("저장된 원의 넓이 전체 조회: ");
                circleCalculator.inquiryResults();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        } while (!sc.next().equals("exit"));

    }
}