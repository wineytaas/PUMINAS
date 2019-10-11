/***************************************************************
 * Nome do programa: MinutosParaSegundos
 * Data da elaboração: 28/3/2017
 * Autor: Wisney Tadeu de Almeida Assis dos Santos
 * Objetivo: Converter minutos para segundos
 * Argumentos: Tempo em minutos
 * Valor gerado: Tempo em segundos
 ****************************************************************
 */
 
 import java.util.Scanner;
 
 public class Q3SegundosParaMinutos{
   public static void main(String[] args){
      int minutos = leMinutos();
      escreveConvercaoMinutosSegundos(minutos);
   }//fim main
   
   public static int leMinutos(){
      Scanner s = new Scanner(System.in);
      
      int minutos;
      boolean errado;
      do{
         System.out.println("Minutos: ");
         minutos = s.nextInt();
         errado = minutos < 0;
         if(errado) System.out.println("\nValor Invalido! Digite um tempo positivo!\n");
      }while(errado);
      
      return minutos;
   }//fim leMinutos
   
   public static void escreveConvercaoMinutosSegundos(int minutos){
      int segundos = minutos * 60;
      System.out.println("Minutos: "+minutos+"\nSegundos: "+segundos);      
   }//fim escreveConvercaoMinutosSegundos
   
 }//fim class