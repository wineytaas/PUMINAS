/*
*  Autor:   Wisney Tadeu de Almeida Assis dos Santos
*  Data:    04/04/2017
*  Nome do programa: Função Recurciva F2 com um return
*  Objetivo: Modificar a função f2 do exercício anterior
*  para uma forma que tenha apenas um return
*/

import java.util.Scanner;

public class Q4F2UnicoReturn{
   public static void main(String[] args){
      int numero = lerInt();
      
      System.out.println("f2( " + numero + ") = " + f2(numero));
       
   }//fim main 
   
   public static int f2(int n) {
      int f;
      if (n == 0 || n == 1)
         f = 1;
      else
         f = (f2(n-1)+ 2 * f2(n-2));
      return f;
   }
   
   public static int lerInt(){
      Scanner s = new Scanner(System.in);
      System.out.println("Digite um inteiro: ");
      return s.nextInt();
   }//fim ler int
   
}//fim class