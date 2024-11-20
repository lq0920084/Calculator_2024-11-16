import java.util.ArrayList;
import java.util.List;

public class ResultSave {
    //데이터를 저장할 Store선언.
    private List<Double> Store = new ArrayList<>();

    public void setResult(Double data){
        Store.add(data);
    }

    public void getAllResult(){
            Store.forEach(data -> System.out.println("계산결과: "+ data));
    }
    public void getValue_greater(double data){
        Store.stream().filter(Value -> Value>data ).forEach(Result -> System.out.println("계산결과: "+ Result));
    }
    public void remove(){
        Store.remove(0);
    }

}
