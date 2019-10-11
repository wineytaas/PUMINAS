/***************************************************************
 * Nome do programa: Ano Bissexto
 * Data da elaboração: 28/3/2017
 * Autor: Wisney Tadeu de Almeida Assis dos Santos
 * Objetivo: Identificar se um ano declarado eh bissexto
 * Argumentos: ano(inteiro positivo nao nulo)
 * Valor gerado: True - ano bissexto // False - ano comum
 * 
 ****************************************************************
 */
 
 import java.util.Scanner;
 
 public class Q7AnoBissexto{
   public static void main(String[] args){
      System.out.println("Ano bissexto: "+ ehBissexto(leAno()));
   }//fim main
   
   public static int leAno(){
      Scanner s = new Scanner(System.in);
      int ano;
      boolean errado;
      
      do{
         System.out.print("Digite um ano: ");
         ano = s.nextInt();
         errado = ano < 0;
         if(errado)System.out.print("\nAno invalido! Digite um ano positivo!");
      }while(errado);
       
      return ano;
   }//fim leAno
   
   public static boolean ehBissexto(int ano){
      boolean bissexto = false;
      if(ano%4 == 0 && (ano%100 != 0 || ano%400 == 0))
         bissexto = true;
      
      return bissexto;
   }//fim ehBissexto
   
}//fim class