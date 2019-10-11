/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data:  04/04/2017
*  Nome do programa: Escrever uma função que receba como parametro o inicio e o fim de
*  uma sequencia de numeros espelhados e os escreva na tela
*  1,2,3,4,5,5,4,3,2,1
*/

import java.util.Scanner;

public class Q7SequenciaEspelhada{
   public static void main(String[] args){
      int inicio = lerInt("para o inicio");
      int fim = lerInt("para o fim");
      
      seqInEnd(inicio,fim);       
   }//fim main 
   
   public static void seqInEnd(int inicio, int fim){
      if(inicio == fim){
         System.out.print(inicio + " , " + inicio + " , ");
      }else if(inicio < fim){
         System.out.print(inicio + " , ");
         seqInEnd(inicio+1, fim);
         System.out.print(inicio + " , ");
      }else if(fim < inicio){
         System.out.print(inicio + " , ");
         seqInEnd(inicio-1, fim);
         System.out.print(inicio + " , ");
      }      
   }
   
   public static int lerInt(String msg){
      Scanner s = new Scanner(System.in);
      System.out.println("Digite um inteiro "+msg+" : ");
      return s.nextInt();
   }//fim ler int
   
}//fim class