import java.util.Scanner;

public class Q4anoBissexto{
   public static void main(String[] args){
   
      int ano = leAno();
      if(bissexto(ano)){
         System.out.println("Ano "+ano+" eh bissexto!");
      }else{
         System.out.println("Ano "+ano+" nao eh bissexto!");
      }
      
   }//fim class
   
   public static boolean bissexto(int ano){
      boolean bissexto = false;
      bissexto = ano%4 == 0 && ano%400 == 0 || ano%100 != 0;
      return bissexto;
   }// fim bissexto
   
   public static int leAno(){
      Scanner s = new Scanner(System.in);
      int ano;
      boolean erro;
      do{
         System.out.println("Digite o ano: ");
         ano = s.nextInt();
         erro = ano < 0;
         if(erro)System.out.println("\nAno invalido! Digite um ano maior que zero!");
      }while(erro);
      return ano;
   }// fim leAno
   
}//fim class