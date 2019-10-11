/*
*  Autor:   Wisney Tadeu de Almeida Assis dos Santos
*  Data:    04/04/2017
*  Nome do programa: Fatorial
*  Objetivo: Escrever o valor do Fatorial(n), modificando a função f1()
*  do exercício anterior para que ela tenha apenas um return
*/
import java.util.Scanner;

public class Q2Fatorial{
   public static void main(String[] args){
      int numero = lerInt();
      System.out.println("Fatorial de " + numero + " = " + f1(numero));
   }//fim main 
   
   public static int f1(int n){
      int f = 0;
      if (n == 0)
        f = 1;
      else
        f = (n * f1(n-1));
      return f;
   }//fim f1
   
   public static int lerInt(){
      Scanner s = new Scanner(System.in);
      System.out.println("Digite um inteiro: ");
      return s.nextInt();
   }//fim ler int
   
}//fim class