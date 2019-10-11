/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data:  04/04/2017
*  Nome do programa: Escrever uma função que escreva na tela
*  uma sequencia de numeros espelhados 
*  1,2,3,4,5,5,4,3,2,1
*/
import java.util.Scanner;

public class Q6SequenciaEspelhada{
   public static void main(String[] args){    
     seqIn(1);       
   }//fim main 
   
   public static void seqIn(int inicio){
       if(inicio <= 5){
         System.out.print(inicio + " , ");
         seqIn(inicio+1);
         System.out.print(inicio + " , ");
       }
   }
   
   public static int lerInt(String msg){
      Scanner s = new Scanner(System.in);
      System.out.println("Digite um inteiro "+msg+" : ");
      return s.nextInt();
   }//fim ler int
   
}//fim class