/*
*  Autor:   Wisney Tadeu de Almeida Assis dos Santos
*  Data:    04/04/2017
*  Nome do programa: Sequencia
*  Objetivo: Printar uma a sequêcia de numeros 1,2,3,4,5,6,7,8,9,10
*  
*/
import java.util.Scanner;

public class Q5Sequencia{
   public static void main(String[] args){
      int inicio = 1;
      int fim = 10;
      
      seqEnd(fim);
      System.out.println("\n\n");
      seqInEnd(inicio,fim);       
   }//fim main 
   
   public static void seqEnd(int fim){
      if(fim > 0){
         seqEnd(fim-1);
         System.out.print(fim+" , ");
      }      
   }
   
   public static void seqInEnd(int inicio, int fim){
      if(inicio == fim){
         System.out.print(inicio + " , ");
      }else if(inicio < fim){
         System.out.print(inicio + " , ");
         seqInEnd(inicio+1, fim);
      }else if(fim < inicio){
         seqInEnd(inicio, fim+1);
         System.out.print(fim + " , ");
      }      
   }
   
   public static int lerInt(String msg){
      Scanner s = new Scanner(System.in);
      System.out.println("Digite um inteiro "+msg+" : ");
      return s.nextInt();
   }//fim ler int
   
}//fim class