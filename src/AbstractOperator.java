public abstract class AbstractOperator {

    //제너릭 T타입 변수 2개를 받아서 T타입 결과로 반환하는 추상메서드 선언.
    public abstract <T extends Number> T Operate(T First_Number,T Second_Number);
}
