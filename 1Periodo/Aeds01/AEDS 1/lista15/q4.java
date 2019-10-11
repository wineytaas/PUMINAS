import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArithmeticException;

public class q4{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      double a , b;
      int op = 1;
      do{ 
         try{
            
            op = menu();
              
            switch(op){
               case 1:
                  System.out.print("Digite a: ");
                  a = leReal();
                  System.out.print("Digite b: ");
                  b = leReal();
                  System.out.println(a + " + " + b + " = " + soma(a,b));
                  break;
               case 2:
                  System.out.print("Digite a: ");
                  a = leReal();
                  System.out.print("Digite b: ");
                  b = leReal();
                  System.out.println(a + " - " + b + " = " + subtracao(a,b));
                  break;
               case 3:
                  System.out.print("Digite a: ");
                  a = leReal();
                  System.out.print("Digite b: ");
                  b = leReal();
                  System.out.println(a + " * " + b + " = " + mult(a,b));
                  break;
               case 4:                  
                  System.out.print("Digite a: ");
                  a = leReal();
                  System.out.print("Digite b: ");
                  b = leReal();
                  double valor = div(a,b);
                  System.out.println(a + " / " + b + " = " + valor);
                  break;
               default:
                  break;
            }
              
         }
         catch(InputMismatchException inputMismatchException){
            System.err.printf("\nExepition:%s\n", inputMismatchException);
            s.nextLine();
            System.out.println("Digite valor invalido!!");
         }
         catch(ArithmeticException arithmeticException){
            System.out.println("Divicao por zero!");
         }catch(Exception exception){
            System.out.println("Opcao Invalida!!");
         }
      }while(op != 0);
   }
   
   public static double div(double a , double b) throws ArithmeticException{
      if(b == 0)
         throw new ArithmeticException();
      return a / b;
   }
   
   public static double mult(double a , double b){
      return a * b;
   }
   
   public static double subtracao(double a , double b){
      return a - b;
   }
   
   public static double soma(double a , double b){
      return a + b;
   }
   
   public static void intervalo(int min, int max , int valor)
   throws Exception
   {
      if(valor < min || valor > max)
         throw new Exception();   
   }
   
   public static int menu() throws Exception{
      int op = 0;
      boolean erro = true;
      int min = 0;
      int max = 4;      
      System.out.println(  "0 - Sair\n"+
                                 "1 - Adicao\n"+
                                 "2 - Substracao\n"+
                                 "3 - Multiplicacao\n"+
                                 "4 – Divisão");
      op = leInt();
      intervalo(min,max,op);
      
      return op;
   }
   
   public static double leReal() throws InputMismatchException{
      Scanner s = new Scanner(System.in);

      double valor = 0;
      
      valor  = s.nextDouble();  
        
      return valor;
   }
   
   public static int leInt() throws InputMismatchException{
      Scanner s = new Scanner(System.in);
      int valor = s.nextInt();
       
      return valor;
   }
}
