/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data de inicio:      18/04/2017
*  Data ultima edição:  18/04/2017   
*  Versão: 1.0
*  Funcionalidade: Troca o primeiro elemento pelo ultimo de  
*  um Arranjo
*/

import java.util.Scanner;

public class Q1Array{
   public static void main(String[] args){
      int[] x = {6,5,4,3,2,1};
      
      escreve(x);
      trocaPrimeiroUltimo(x);
      escreve(x);
   }//fim main
   
   public static void trocaPrimeiroUltimo(int[] x){
      int ultimo = x.length - 1;
      int aux = x[0];
      
      x[0] = x[ultimo];
      x[ultimo] = aux;
      
   }//fim trocaPrimeiroUltimo
   
   public static void escreve(int[] x){
      System.out.print(x[0]);
      for(int i = 1 ; i < x.length ; i++){
         System.out.print(","+x[i]);
      }
      System.out.println("");
   }//fim escreve
   
}//fim class