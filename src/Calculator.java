import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    // 어떤 데이터를 받을 부분인지를 확인할 enum을 선언합니다.
    // 메인 메서드와 유효성검사 메서드에서 모드 사용해야 하기 때문에 class 선언 아래에 바로 선언합니다.
    public enum Check_Order {
        First_Number, Operator, Second_Number, Calculate, Exit, End
    }

    public static void main(String[] args) {
        //입력값의 유효성 결과를 임시로 받을 InputData를 선언합니다.
        String InputData;
        // 사용자의 입력을 받을 스캐너 sc를 선언합니다.
        Scanner sc = new Scanner(System.in);
        //현재 계산 순서를 저장할 enum Now_Order를 선언합니다.
        Check_Order Now_Order = Check_Order.First_Number;
        // 첫번째 숫자를 저장할 First_Number를 선언합니다.
        String First_Number ="";
        // 두번째 숫자를 저장할 Second_Number를 선언합니다.
        String Second_Number ="";
        // 연산자를 저장할 Operator를 선언합니다.
        String Operator = "";
        //반복문을 실행합니다.
        do {
            //스위치로 enum을 구분합니다.
            switch (Now_Order) {
                //만일 첫번째 숫자를 받을 차례라면?
                case First_Number: {
                    // 계산받을 첫번째 숫자를 입력받습니다.
                    System.out.println("첫번째 숫자를 입력해주세요.");
                    //입력값의 유효성을 검사합니다.
                    InputData = CheckVerification(sc.nextLine(),Now_Order);
                    //만일 결과가 NoData라면 입력값이 잘못 되었음을 사용자에게 알립니다.
                    if(InputData.equals("NoData")){
                        System.out.println("입력값이 잘못되었습니다.");
                    }else{
                        //만일 결과가 정상데이터라면 해당값을 First_Number에 넣고 다음 차례로 넘깁니다.
                        First_Number = InputData;
                        Now_Order=Check_Order.Operator;
                    }
                    break;
                }
                //만일 연산자를 받을 차례라면?
                case Operator: {
                    // 계산할 연산자를 입력받습니다.
                    System.out.println("연산자를 입력해주세요.");
                    //입력값의 유효성을 검사합니다.
                    InputData = CheckVerification(sc.nextLine(),Now_Order);
                    //만일 결과가 NoData라면 입력값이 잘못 되었음을 사용자에게 알립니다.
                    if(InputData.equals("NoData")){
                        System.out.println("입력값이 잘못되었습니다.");
                    }else{
                        //만일 결과가 정상데이터라면 해당값을 Operator에 넣고 다음 차례로 넘깁니다.
                        Operator = InputData;
                        Now_Order=Check_Order.Second_Number;
                    }
                    break;
                }
                //만일 두번째 숫자를 받을 차례라면?
                case Second_Number: {
                    // 계산받을 두번째 숫자를 입력받습니다.
                    System.out.println("두번째 숫자를 입력해주세요.");
                    //입력값의 유효성을 검사합니다.
                    InputData = CheckVerification(sc.nextLine(),Now_Order);
                    //만일 결과가 NoData라면 입력값이 잘못 되었음을 사용자에게 알립니다.
                    if(InputData.equals("NoData")){
                        System.out.println("입력값이 잘못되었습니다.");
                    }else{
                        //만일 결과가 정상데이터라면 해당값을 Second_Number에 넣고 다음 차례로 넘깁니다.
                        Second_Number = InputData;
                        Now_Order=Check_Order.Calculate;
                    }

                    break;
                }
                //계산할 값을 모두 받았다면?
                case Calculate: {
                    //Calculate메소드를 호출해 계산하고 결과를 표시합니다.
                    System.out.println("계산 결과 : "+Calculate(Operator,First_Number,Second_Number));
                    //계산을 마치려면 Exit를 입력해야 함을 사용자에게 알립니다.
                    System.out.println("계산을 종료하려면 Exit를 입력해주세요. 계산을 계속하려면 Exit를 제외한 아무 값이나 입력하세요.");
                    InputData = sc.nextLine();
                    if(InputData.equals("Exit")){
                            Now_Order=Check_Order.End;
                    }else{
                        Now_Order=Check_Order.First_Number;
                    }
                    break;
                }


            }
        }//만일 현재 순서가 End 라면 반복문을 종료합니다.
        while (Now_Order!=Check_Order.End);


    }

    //유효성 검사를 위해 확인할 데이터와 현재 입력받은 데이터의 입력 순서를 알리는 enum을 받습니다.
    public static String CheckVerification(String CheckData, Check_Order Now_Order) {

        //결과를 저장할 Result 변수를 선언하고 데이터가 유효하지 않는다면 리턴할 NoData를 기본값으로 선언합니다.
        String Result = "NoData";
        //자연수를 확인할 정규식 패턴 선언.
        Pattern Number_pattern = Pattern.compile("^[0-9]+$");
        //연산자를 확인할 정규식 패턴 선언.
        Pattern Operator_pattern = Pattern.compile("[-+*/]");
        //현재 순서가 첫번째 값을 받을 차례라면?
        if (Now_Order == Check_Order.First_Number) {
            //이 값이 숫자 정규식 패턴에 맞는지 확인합니다.
            Matcher matcher = Number_pattern.matcher(CheckData);
            //만약 숫자 정규식 패턴에 맞다면?
            if (matcher.matches()) {
                //만약 이 값이 자연수 최대값보다 작거나 같다면?
                if (Long.parseLong(CheckData) <= Integer.MAX_VALUE) {
                    //Result 변수에 현재 데이터 넣기
                    Result = CheckData;
                }
            }
        }
        //현재 순서가 연산자를 받을 차례 라면?
        else if (Now_Order == Check_Order.Operator) {
            //이 값이 연산자 정규식 패턴에 맞는지 확인합니다.
            Matcher matcher = Operator_pattern.matcher(CheckData);
            //이 값이 연산자 전규식 패턴에 맞다면?
            if (matcher.matches()) {
                //Result 변수에 현재 데이터 넣기
                Result = CheckData;
            }
            //현재 순서가 두번째 숫자를 받을 차례 라면?
        } else if (Now_Order == Check_Order.Second_Number) {
                //이 값이 숫자 정규식 패턴에 맞는지 확인합니다.
                Matcher matcher = Number_pattern.matcher(CheckData);
                //만약 숫자 정규식 패턴에 맞다면?
                if (matcher.matches()) {
                    //만약 이 값이 자연수 최대값보다 작거나 같다면?
                    if (Long.parseLong(CheckData) <= Integer.MAX_VALUE) {
                        //Result 변수에 현재 데이터 넣기
                        Result = CheckData;
                    }
                }
            }


        //결과를 반환
        return Result;
    }

    public static String Calculate(String Operator, String First_Number, String Second_Number) {
        //결과값을 반환할 Result 변수를 선언합니다.
        String Result = " ";
        //만일 연산자가 나눗셈이면서 나눌 숫자가 0이라면 0으로 나눌 수 없음을 알립니다.
        if (Operator.equals("/") && Second_Number.equals("0")) {
            Result = "0으로 나눌 수 없습니다.";

        } //그게 아니라면 연산자에 맞게 계산을 실행합니다.
        else {
            //Switch로 연산자를 구분합니다.
            switch (Operator) {
                //입력받은 문자열을 숫자로 변환한 뒤 계산하고 그것을 다시 문자열로 변환하여 Result에 저장합니다.
                case "+": {
                    Result = String.valueOf(Integer.parseInt(First_Number) + Integer.parseInt(Second_Number));
                    break;
                }
                case "-": {
                    Result = String.valueOf(Integer.parseInt(First_Number) - Integer.parseInt(Second_Number));
                    break;
                }
                case "*": {
                    Result = String.valueOf(Integer.parseInt(First_Number) * Integer.parseInt(Second_Number));
                    break;
                }
                case "/": {
                    Result = String.valueOf(Integer.parseInt(First_Number) / Integer.parseInt(Second_Number));
                    break;
                }
            }

        }
        //계산된 Result를 변환합니다.
        return Result;
    }
}
