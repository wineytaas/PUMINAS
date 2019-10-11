/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data de inicio:      18/04/2017
*  Data ultima edição:  18/04/2017   
*  Versão: 1.0
*  Funcionalidade: Troca o x[n] por x[m] de um Arranjo  
*   m < x.length && n < x.length
*/

import java.util.Scanner;

public class Q2Array{
   public static void main(String[] args){
      int[] x = {6,5,4,3,2,1};
            
      escreve(x);
      trocaElemontos(x , 0 , (x.length-1));
      escreve(x);
   }//fim main
   
   public static void trocaElemontos(int[] x, int p1 , int p2 ){
      int aux = x[p1];
      
      x[p1] = x[p2];
      x[p2] = aux;
      
   }//fim trocaElemontos
   
   public static void escreve(int[] x){
      System.out.print(x[0]);
      for(int i = 1 ; i < x.length ; i++){
         System.out.print(","+x[i]);
      }
      System.out.println("");
   }//fim escreve
      
}//fim class