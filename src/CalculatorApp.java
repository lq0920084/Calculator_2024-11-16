public class CalculatorApp {
    //계산을 위한 Calculator 객체를 생성합니다.
   private  Calculator calc = new Calculator();
    //객체 유효성 검사를 위한 CheckVerification 객체를 생성합니다.
   private  CheckVerification check = new CheckVerification();
    //계싼 결과를 저장할 SaveResult 객체를 생성합니다.
    private SaveResult save = new SaveResult();
    //현재 순서를 확인하기 위해 열거형 타입을 생성합니다.
    private Check_Order Order_Data = Check_Order.First_Number;
    //리턴데이터값을 저장할 String 변수를 생성합니다.
    String ReturnData = "";
    //0으로 나눌 수 없어야 하므로 나눗셈 중인지 확인하기 위해 연산자를 보관할 변수가 필요합니다.
    String Operator = "";
    //결과 값을 저장할 Result변수를 선언합니다.
    String Result;

    //각 객체들을 조합하고 작동로직을 완성할 calculate 메서드를 생성합니다. Main 메서드에서 받은 입력값이 여기로 들어옵니다.
    public String calculate(String input){
        //만약 들어온 값이 Exit라면?
        if(input.equals("Exit")){
            //input값을 그대로 Result에 넣습니다.
            this.ReturnData = input;
            //들어온 값이 Remove라면?
        } else if(input.equals("Remove")){
            //저장된 계산 결과 중 첫번째를 삭제합니다.
                save.Remove();
            //input값을 그대로 Result에 넣습니다.
            this.ReturnData = input;
                //등어온 값이 GetAllResult라면?
        } else if(input.equals("GetAllResult")){
            //저장된 모든 결과값을 출력합니다.
            save.GetAllResult();
            //input값을 그대로 Result에 넣습니다.
            this.ReturnData = input;
            //그게 아니라면?
        }else if(input.equals("Start")){
            //input값을 그대로 Result에 넣습니다.
            this.ReturnData = input;

        } else {
            //switch로 현재 어떤 값을 넣어야 할 상황인지 확인합니다.
            switch(Order_Data){
                //만일 첫번째 숫자를 받아야 할 상황이라면?
                case First_Number:{
                    //입력 받은 값의 유효성을 확인합니다.
                    ReturnData = check.CheckVerification(input,Order_Data);
                    //입력값이 정상이라면?
                    if(!ReturnData.equals("NoData")){
                        //이 값을 계산할 첫번째 값으로 설정합니다.
                        calc.setFirstNumber(input);
                        //정상적으로 값이 설정되었음을 Result에 넣어 상위 메소드에 반환합니다.
                        ReturnData ="First_Number_OK";
                        //enum을 다음값으로 넘깁니다.
                        Order_Data=Check_Order.Operator;
                    }
                    break;
                }
                case Operator: {
                    //입력 받은 값의 유효성을 확인합니다.
                    ReturnData = check.CheckVerification(input,Order_Data);
                    //입력값이 정상이라면?
                    if(!ReturnData.equals("NoData")){
                        //입력받은 값을 연산자에 넣습니다.
                        OperatorParse(input);
                        //0으로 나누는 것을 방지하기 위해 연산자를 임시 보관합니다.
                        Operator = input;
                        //정상적으로 값이 설정되었음을 Result에 넣어 상위 메소드에 반환합니다.
                        ReturnData ="Operator_OK";
                        //enum을 다음 순서로 넘깁니다.
                        Order_Data=Check_Order.Second_Number;
                    }
                    break;
                } case Second_Number:{
                    //입력 받은 값의 유효성을 확인합니다.
                    ReturnData = check.CheckVerification(input,Order_Data);
                    //입력값이 NoData가 아니라면?
                    if(!ReturnData.equals("NoData")){
                        //0으로 나누지 않는 다면?
                        if(!(Integer.parseInt(ReturnData)==0&&Operator.equals("/"))){
                            //이 값을 계산할 두번째 값으로 설정합니다.
                            calc.setSecondNumber(input);
                            //정상적으로 값이 설정되고 계산되었음을 Result에 넣어 상위 메소드에 반환합니다.
                            ReturnData ="Second_Number_Set_Calculate_OK";
                            Result=calc.calculate();
                            //계산 결과를 지정된 어레이리스트에 저장합니다.
                            save.SetResult(Result);
                            Order_Data=Check_Order.First_Number;


                        }
                    }
                    break;
                }
            }


        }


        return this.ReturnData;
    }
    //연산자를 확인해서 맞는 메서드를 넣습니다.
    public void OperatorParse(String Operator){
        switch(Operator){
            //만일 +라면 더하기 객체를 넣습니다.
            case "+":{
                    calc.setOperator(new AddOperator());
                break;
            }
            //만일 -라면 빼기 객체를 넣습니다.
            case "-":{
                calc.setOperator(new SubOperator());
                break;
            }
            //만일 *라면 곱하기 객체를 넣습니다.
            case "*":{
                calc.setOperator(new MulOperator());
                break;
            }
            //만일 /라면 나누기 객체를 넣습니다.
            case "/":{
                calc.setOperator(new DivOperator());
                break;
            }
            
            
        }
        
    }

    public String getResult(){
        return Result;
    }

}
