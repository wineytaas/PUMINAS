package lista4;
import java.util.Scanner;

class Q4Fibonacci{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
           
      System.out.print("Digite o n�mero de termos a serem exibidos da serie de Fibonacci: ");
      int n = s.nextInt();
      int f = 1;
      int a = 0;
      int b = 0;
      
      while(n != 0){
         System.out.print(f+" , ");
         b = f;
         f += a;
         a = b;
         n--;
      }
       System.out.println("");
   }
}