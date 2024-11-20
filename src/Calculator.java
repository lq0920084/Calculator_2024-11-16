public class Calculator<T extends Number> {
    //연산자를 받을 추상메서드 선언.
    AbstractOperator AbstractOperator;
    //첫번째 숫자를 받을 제너릭 선언.
    T First_Number;
    //두번째 숫자를 받을 제너릭 선언.
    T Second_Number;
    //연산자를 설정할 setter 선언.
    public void SetOperator(AbstractOperator AbstractOperator){
        this.AbstractOperator = AbstractOperator;
    }

    ///첫번째 제너릭을 설정할 setter 선언.
    public void SetFirst_Number(T First_Number){
        this.First_Number = First_Number;
    }

    ///두번째 제너릭을 설정할 setter 선언.
    public void SetSecond_Number(T Second_Number){
        this.Second_Number = Second_Number;
    }

    //계산할 메서드 선언.
    public T Calculate(){
        return AbstractOperator.Operate(this.First_Number,this.Second_Number);
    }


}
