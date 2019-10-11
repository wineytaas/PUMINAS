/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data:  04/04/2017
*  Nome do programa: OperacoesAritimeticas 
*  Objetivo : Criar varios metodos com diferentes operações aritimeticas
*/
import java.util.Scanner;


public class TesteOperacoesAritimeticas{
   public static void main(String[] args){
      
      System.out.println("Somatorio de 1 - 10 : " + OperacoesAritimeticas.somatorio((double)1,(double)10));
      System.out.println("Somatorio de 10 - 1 : " + OperacoesAritimeticas.somatorio((double)10,(double)1));
      System.out.println("Fatorial de 5 = "  + OperacoesAritimeticas.fatorial(5));
      System.out.println("Fibonacci na 6 posição = "  + OperacoesAritimeticas.fibonacci(6));
      OperacoesAritimeticas.escreveOrdemDecrecente(5);
      System.out.println("Soma dos 3 primeiros Cubos = "  + OperacoesAritimeticas.somaNCubos(3));
      
   }//fim main
}//fim class TesteOperacoesAritimeticas


class OperacoesAritimeticas{
   /*
   *  Soma de n até m
   */
   public static double somatorio(double n , double m){
      double soma;
      if(n == m)
         soma = 0;
      else if(n < m)
         soma = n + somatorio(n+1,m);
      else
         soma = m + somatorio(n,m+1);
      
      return soma;
   }//fim somatorio
   
   /*
   * Fatorial(n)
   */
   public static int fatorial(int n){
      int f = 1;
      if(n > 1){
         f = n * fatorial(n-1);
      }
      
      return f;
   }//fim fatorial
    
   /*
   *  1,1,2,3,5,8,13,...  
   *  Calcula o valor do fibonacci na posição N
   */
   
   public static int fibonacci(int posicao){
      int fibN = 1;
      if(posicao > 2){
         fibN = fibonacci(posicao-1) + fibonacci(posicao - 2);
      }
      
      return fibN;
   }
   
   /*
   *  Escreve inteiro decrecentes de N até 0
   *
   */
   public static void escreveOrdemDecrecente(int n){
      if(n <= 0){
         System.out.println(n);
      }else if(n > 0){
         System.out.print(n + " , ");
         escreveOrdemDecrecente(n-1);
      }
   }//fim escreveOrdemDecrecente
   
   /*
   *  S= 13 + 23 + 33 + ... + N3
   */
   public static long somaNCubos(int n){
      long soma = 0;
      if(n > 0){
         soma = (n * n * n) + somaNCubos(n-1);
      }
      return soma;
   }//fim escreveOrdemDecrecente
   
}//fim class OperacoesAritimeticas

