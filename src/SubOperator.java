public class SubOperator extends AbstractOperator{
    public String Operate(String First_Number,String Second_Number){
        return String.valueOf(Integer.parseInt(First_Number)+Integer.parseInt(Second_Number));
    }
}
