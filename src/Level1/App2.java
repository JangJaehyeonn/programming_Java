package Level1;

import java.util.*;

public class App2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> results = new ArrayList<>();

        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);      //input3은 연산자(사칙연산 기호)
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            int result = 0;


            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result =num1 * num2;
                    break;
                case '/':
                    if(num2 != 0) {
                        result = num1 / num2;
                    }else{
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        return;         //continue도 가능함
                    }
                    break;
                default:
                    System.out.println("올바른 선택이 아닙니다.");
                    return;
            }

            System.out.println("결과: " + result);
            results.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(Objects.equals(sc.next(),"remove")){
                results.remove(0);
            }

            System.out.println("가장 먼저 저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if(Objects.equals(sc.next(),"inquiry")){
                for (Integer res : results) {         //iter
                    System.out.print("연산 결과 : " + res);
                }
            }

            System.out.println("결과 저장소 : " + results);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        }while(!sc.next().equals("exit"));
    }
}
