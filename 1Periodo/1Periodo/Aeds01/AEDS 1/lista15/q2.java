import java.util.Scanner;
import java.util.InputMismatchException;

public class q2{
   public static void main(String[] args){
      boolean erro = true;
      Scanner s = new Scanner(System.in);
      do{
         try{
            double a  = leReal();
            double b  = leReal();
            System.out.println(a + " + " + b + " = " + (a+b) );
            erro = false;
         }catch(InputMismatchException inputMismatchException){
            System.err.printf("\nExepition:%s\n", inputMismatchException);
            s.nextLine();
            System.out.println("Digite valores inteiros!!");
         }
      }while(erro);
   }
   
   public static double leReal() throws InputMismatchException{
      Scanner s = new Scanner(System.in);
      
      double valor  = s.nextInt();
      
      return valor;
   }
   
   public static double soma(double a, double b){
      double soma  = a + b;
      
      return soma;
   }
   
   public static void soma(double soma){
      System.out.println("Soma: " + soma);
   }
   
}
