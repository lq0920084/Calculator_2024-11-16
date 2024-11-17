import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //결과값을 받을 변수 Result에 Start를 넣어서 선언합니다.
        String Result = "Start";
        //입력을 받을 스캐너를 선언합니다.
        Scanner sc = new Scanner(System.in);
        //계산을 처리할 CalculatorApp객체를 생성합니다.
        CalculatorApp calc = new CalculatorApp();

        //반복문을 실행합니다.
        do{
            //스위치로 Result의 값을 확인합니다.
            switch(Result){
                case "Start": {
                    //첫번째 숫자를 입력해야 함을 콘솔에 표시합니다.
                    System.out.println("첫번째 숫자를 입력해주세요.");
                    break;
                }
                case "First_Number_OK": {
                    //연산자를 입력해야 함을 콘솔에 표시합니다.
                    System.out.println("연산자를 입력해주세요.");
                    break;
                }
                case "Operator_OK": {
                    //두번째 숫자를 입력해야 함을 콘솔에 표시합니다.
                    System.out.println("두번째 숫자를 입력해주세요.");
                    break;
                }
                case "Second_Number_Set_Calculate_OK": {
                    //계산이 끝났음을 콘솔에 표시합니다.
                    System.out.println("계산이 완료되었습니다.");
                    //계산 결과를 호출하여 콘솔에 표시합니다.
                    System.out.println("계산결과 : "+ calc.getResult());
                    //계산을 끝내려면 Exit, 새로시작하려면 Start,저장된 값을 지우려면 Remove, 모든데이터를 반환하려면 GetAllData를 입력해야 함을 표시합니다.
                    System.out.println("계산을 마치려면 Exit, 계산을 계속하려면 Start, 저장된 값을 지우려면 Remove, 모든 데이터를 반환하려면 GetAllResult 입력합니다.");
                        break;
                }
                case "GetAllResult" : {
                    //젼체값을 출력이 완료되었음을 콘솔에 표시합니다.
                    System.out.println("출력완료");
                    break;
                }
                case "Remove" : {
                    // 첫번째 값이 삭제되었음을 콘솔에 표시합니다.
                    System.out.println("첫번째 값이 삭제되었습니다.");
                    break;
                }
                case "NoData" : {
                    System.out.println("입력된 값은 유효하지 않습니다.");
                    break;
                }


            }
            Result = calc.calculate(sc.nextLine());
        }// Result의 값이 Exit가 될때까지 반복합니다.
        while(!Result.equals("Exit"));


    }

}
