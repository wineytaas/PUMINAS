import java.util.Scanner;
public class Q2ImparPar{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      System.out.print("Digite um numero inteiro: ");
      int valor = s.nextInt();
      boolean par = par(valor);
      
      if(par)
         System.out.println("\n"+ valor + " eh um numero par !!");
      else 
         System.out.println("\n"+ valor + " eh um numero impar !!");
   }//fim main
   
   public static boolean par(int valor){
      boolean par = valor%2 == 0;
      return par;
   }//fim par
   
}//fim class