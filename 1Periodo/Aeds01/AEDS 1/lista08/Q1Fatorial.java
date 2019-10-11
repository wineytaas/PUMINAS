/*
*  Autor:   Wisney Tadeu de Almeida Assis dos Santos
*  Data:    04/04/2017
*  Nome do programa: Fatorial
*  Objetivo: Por meio de um metodo recurcivo dizer quais seram suas saidade de 
*  acordo com cada entrada terterminada na lista
*  
*/

import java.util.Scanner;

public class Q1Fatorial{
   public static void main(String[] args){
      System.out.println("f(0) = " + 1 );
      System.out.println("f(1) = " + 1 );
      System.out.println("f(4) = " + 24 );
      /*
      System.out.println("\n\n------- TESTE --------\n");
      int numero = 0;
      System.out.println("Fatorial de " + numero + " = " + f1(numero));
      numero = 1;
      System.out.println("Fatorial de " + numero + " = " + f1(numero));
      numero = 4;
      System.out.println("Fatorial de " + numero + " = " + f1(numero));
      */
   }//fim main 
   
   public static int f1(int n){
    if (n == 0)
      return (1);
    else
      return (n * f1(n-1));
   }//fim f1
   
   public static int lerInt(){
      Scanner s = new Scanner(System.in);
      System.out.println("Digite um inteiro: ");
      return s.nextInt();
   }//fim ler int
   
}//fim class