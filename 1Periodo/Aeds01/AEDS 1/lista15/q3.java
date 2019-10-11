import java.util.Scanner;
import java.util.InputMismatchException;

public class q3{
   public static void main(String[] args){
      
      Scanner s = new Scanner(System.in);
      
      double a  = leReal();
      double b  = leReal();
      System.out.println(a + " + " + b + " = " + (a+b) );
   }
   
   public static double leReal(){
      Scanner s = new Scanner(System.in);
      boolean erro = true;
      double valor = 0;
      do{
         try{
            valor  = s.nextInt();
            erro = false;
         }catch(InputMismatchException inputMismatchException){
            System.err.printf("\nExepition:%s\n", inputMismatchException);
            s.nextLine();
            System.out.println("Digite valores inteiros!!");
         }
      }while(erro);   
      

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
