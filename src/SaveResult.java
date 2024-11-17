import java.util.ArrayList;
import java.util.List;

public class SaveResult {
    List<String> Result = new ArrayList<>();
        //저장된 어레이리스트에서 첫번째 값을 삭제합니다.
    public void Remove(){
        Result.remove(0);
    }

    //값을 어레이리스트에 추가합니다.
    public void SetResult(String Result){
        this.Result.add(Result);
    }

    //특정 인덱스 값을 가지는 결과값을 리턴합니다.
    public void GetAllResult(){
       Result.forEach(result ->  System.out.println("계산결과 : "+ result ));
    }
}
