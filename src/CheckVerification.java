import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckVerification {


    //자연수를 확인할 정규식 패턴 선언.
    private Pattern Number_pattern = Pattern.compile("^[0-9]+$");
    //연산자를 확인할 정규식 패턴 선언.
    private Pattern Operator_pattern = Pattern.compile("[-+*/]");

    public String CheckVerification(String CheckData, Check_Order Now_Order) {

        //결과를 저장할 Result 변수를 선언하고 데이터가 유효하지 않는다면 리턴할 NoData를 기본값으로 선언합니다.
        String Result = "NoData";
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
}
