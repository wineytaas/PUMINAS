import java.util.Scanner;
import java.util.InputMismatchException;
public class q1{
   public static void main(String[] args){
      boolean erro = true;
      Scanner s = new Scanner(System.in);
      do{
         try{
            double a  = s.nextInt();
            double b  = s.nextInt();
            System.out.println(a + " + " + b + " = " + (a+b) );
            erro = false;
         }catch(InputMismatchException inputMismatchException){
            System.err.printf("\nExepition:%s\n", inputMismatchException);
            s.nextLine();
            System.out.println("Digite valores inteiros!!");
         }
      }while(erro);
   }
}
