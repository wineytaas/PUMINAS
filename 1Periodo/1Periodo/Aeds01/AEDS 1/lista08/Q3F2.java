/*
*  Autor:   Wisney Tadeu de Almeida Assis dos Santos
*  Data:    04/04/2017
*  Nome do programa: Função Recurciva F2
*  Objetivo: determinar a saida de f2, que é uma função recurciva,
*  para valores pré determinados
*/

import java.util.Scanner;

public class Q3F2{
   public static void main(String[] args){
      System.out.println("f2(0) = 1");
      System.out.println("f2(1) = 1");
      /*
         f2(n) = f2(n-1) + 2*f2(n-2)
         
         f2(5) = f2(4) + 2*f2(3) = 11 + 2 * 5 = 21
         f2(4) = f2(3) + 2*f2(2) = 05 + 2 * 3 = 11
         f2(3) = f2(2) + 2*f2(1) = 03 + 2 * 1 = 5 
         f2(2) = f2(1) + 2*f2(0) = 01 + 2 * 1 = 3
         f2(1) = 1
         f2(0) = 1
         
      */
      System.out.println("f2(5) = 21");
      
      
      /*
         int numero = 0;
         System.out.println("f2( " + numero + ") = " + f2(numero));
         numero = 1;
         System.out.println("f2( " + numero + ") = " + f2(numero));
         numero = 5;
         System.out.println("f2( " + numero + ") = " + f2(numero));
      */
   }//fim main 
   
   public static int f2(int n) {
      if (n == 0)
         return (1);
      if (n == 1)
         return (1);
      else
         return(f2(n-1)+ 2 * f2(n-2));
   }
   
   public static int lerInt(){
      Scanner s = new Scanner(System.in);
      System.out.println("Digite um inteiro: ");
      return s.nextInt();
   }//fim ler int
   
}//fim class