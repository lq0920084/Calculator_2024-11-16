

public class Calculator {
    //연산자를 받을 추상메서드 Operator를 선언합니다.
    private AbstractOperator Operator;
    //계산할 첫번째 숫자를 받을 FIrstNumber를 선언합니다
    private String First_Number;
    //계산할 두번째 숫자를 받을 SecondNumber를 선언합니다.
    private String Second_Number;
    //캡슐화를 위해 setter를 사용해 Operator를 설정하도록 작성합니다.
    public void setOperator(AbstractOperator Operator){
        this.Operator = Operator;
    }
    //캡슐화를 위해 setter를 사용해 FirstNumber를 설정하도록 작성합니다.
    public void setFirstNumber(String First_Number){
        this.First_Number=First_Number;
    }
    //캡슐화를 위해 setter를 사용해 SecondNumber를 설정하도록 작성합니다.
    public void setSecondNumber(String Second_Number){
        this.Second_Number = Second_Number;
    }
    //모든 값을 받은 후 계산을 진행할 calculate 메서드를 만듭니다.
    public String calculate(){
        return this.Operator.Operate(this.First_Number,this.Second_Number);
    }

}
