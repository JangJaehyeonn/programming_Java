package Level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int index = 0;
        List<Integer> results = new ArrayList<>();

        while(true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int input1 = sc.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("두 번째 숫자를 입력하세요: ");
            int input2 = sc.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char input3 = sc.next().charAt(0);
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            int result = 0;
            switch (input3) {
                case '+':
                    result = input1 + input2;
                    break;
                case '-':
                    result = input1 - input2;
                    break;
                case '*':
                    result = input1 * input2;
                    break;
                case '/':
                    if(input2==0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }
                    result = input1 / input2;
                    break;
                default:
                    System.out.println("다시 입력하세요");
                    continue;
            }

            results.add(result);

            System.out.println("결과: " + result);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String choice = sc.next();
            if (choice.equals("exit")) {
                break;
            } else if (choice.equals("inquiry")) {
                System.out.println("저장된 연산 결과 : ");
                for (int i : results) {
                    System.out.println(i);
                }
            }else if(choice.equals("remove")){
                if(!results.isEmpty()){
                    int removeresult = results.remove(0);
                    System.out.println("삭제된 결과 : " + removeresult);
                }else{
                    System.out.println("삭제할 결과가 없습니다.");
                }
            }
        }
    }
}