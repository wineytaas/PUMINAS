import java.util.Scanner;
public class Q3maior{
   public static void main(String[] args){
      double a = leDouble();
      double b = leDouble();
      double maior = maior(a,b);
      
      System.out.println("\nA maior valor entre os numeros "+ a + " e " + b + " eh : "+ maior);
      
   }//fim main
   
   public static double maior(double a, double b){
      double maior;
      if(a > b)
         maior = a;
      else 
         maior = b;
      return maior;
   }//fim maior
   
   public static double leDouble(){
      Scanner s = new Scanner(System.in);
      System.out.print("\nDigite um numero real: ");
      double real = s.nextDouble();
      return real;
   }//fim leDouble
}//fim class