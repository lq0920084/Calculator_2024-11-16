public class AddOperator extends AbstractOperator {

    public <T extends Number> T Operate(T First_Number,T Second_Number){
            //제너릭형식  덧셈 선언.
        if(First_Number instanceof Integer ){
            return (T) Integer.valueOf(First_Number.intValue()+Second_Number.intValue());
         }else{
            return (T) Double.valueOf(First_Number.doubleValue()+ Second_Number.intValue());
        }
    }
}
