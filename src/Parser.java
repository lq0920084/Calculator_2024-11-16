import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    // 반환할 변수 선언.
    private String ReturnData = "NoData";
    //연산자 여부를 구분할 정규식 선언.
    private final String OPERATION_REG = "[-+*/]";
    private Pattern pattern = Pattern.compile(OPERATION_REG);
    //Calculator 객체 생성.
    Calculator calc = new Calculator();
    //계산결과를 저장할 ResultSave 선언.
    ResultSave save = new ResultSave();
    //첫번째 숫자를 넣을 차례인지 확인할 boolean 변수 선언.
    boolean Now_First_Number = true;
    //0으로 나눌 수 없도록 연산자를 저장해둡니다.
    String Temp_Operator = "";
    //두번째 숫자를 넣을때는 첫번째 숫자와 같응ㄴ 자료형을 써야만 합니다.
    //따라서 기존에 저장한 첫번째 자료형이 무엇인지를 넣어둘 변수가 필요합니다.
    String Type = "";

    public String Calculate(String input) {

        //정규식이 맞는지 확인
        Matcher matches = pattern.matcher(input);

        //만약 연산자 정규식이 맞으면?
        if (matches.matches()) {
            //입력받은 값이 연산자 인지 확인하여 연산자로 저장.
            calc.SetOperator(Operator(input));
            //연산자를 임시 변수에 넣습니다.
            Temp_Operator = input;
            //러턴값에 연산자가 정상적으로 저장되었다는 것을 표시합니다.
            ReturnData = "Operator";
        } else {
            try {
                double Check_double = Double.parseDouble(input);
                ReturnData = "Double";
            } catch (Exception e) {
                ReturnData = "NoData";
            }
            try {
                int Check_int = Integer.parseInt(input);
                ReturnData = "Integer";
            } catch (Exception e) {
                if (ReturnData.equals("Double")) {
                    ReturnData = "Double";
                } else {
                    ReturnData = "NoData";
                }
            }
        }
         if (input.equals("calc")) {
            System.out.println("계산결과: " + calc.Calculate());
            save.setResult(Double.parseDouble(String.valueOf(calc.Calculate())));
            System.out.println("새 계산을 시작 하려면 새 숫자와 연산자를 입력해주세요.");
            System.out.println("종료하려면 exit를 입력하세요.");
            System.out.println("All: 전체결과 출력, exit: 종료, remove: 첫번째 저장값 삭제, Greater숫자: 저장 된 값에서 숫자보다 큰 값 출력");
        } else if (input.length() > 7) {
            if (input.substring(0, 7).equals("Greater")) {
                save.getValue_greater(Double.parseDouble(input.substring(7)));
            }else if(input.equals("remove")){
                save.remove();
                System.out.println("첫번째 값이 삭제되었습니다.");
            }else if(input.equals("All")){
                System.out.println("전체 결과 출력");
                save.getAllResult();
            }
        }
        if (ReturnData.equals("Double") || ReturnData.equals("Integer")) {
            if (Now_First_Number == true) {
                //설정된 변수의 타입을 저장해둡니다.
                Type = ReturnData;
                Now_First_Number = false;
                if (ReturnData.equals("Double")) {
                    calc.SetFirst_Number(Double.parseDouble(input));
                } else {
                    calc.SetFirst_Number(Integer.parseInt(input));
                }

            } else {
                if (!(Temp_Operator.equals("/") && input.equals("0"))) {
                    Now_First_Number = true;
                    if (Type.equals("Double")) {
                        calc.SetSecond_Number(Double.parseDouble(input));
                    } else {
                        calc.SetSecond_Number((int) Double.parseDouble(input));
                    }
                } else {
                    ReturnData = "Div_by_zero";
                }
            }
        }
        return ReturnData;
    }

    //입력된 연산자 스트링에 따라 일치하는 연산객체 반환.
    public AbstractOperator Operator(String Operator) {
        if (Operator.equals("+")) {
            return new AddOperator();
        } else if (Operator.equals("-")) {
            return new SubOperator();
        } else if (Operator.equals("*")) {
            return new MulOperator();
        } else {
            return new DivOperator();
        }
    }
}
