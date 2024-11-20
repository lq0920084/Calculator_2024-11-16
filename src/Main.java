import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
   public static void main(String[] args){
       //입력을 받을 변수 선언.
       String input;
       //입력을 담당할 스캐너 선언.
       Scanner sc = new Scanner(System.in);
       Parser calc = new Parser();
       System.out.println("숫자 2개와 연산자를 입력하고 calc를 입력하여 계산결과를 출력할 수 있습니다.");
       try{
           do {
               input = sc.nextLine();
               if(input.equals("exit")){
                   break;
               }else{
                   calc.Calculate(input);

               }



           }while(true);


       }catch(Exception e) {
           e.printStackTrace();
       }
   }
}
