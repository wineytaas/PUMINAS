/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data de inicio:      18/04/2017
*  Data ultima edição:  18/04/2017   
*  Versão: 1.0
*  Funcionalidade: O programa possue um método capaz de preencher
*  um Arranjo com a serie de fibonacci
*/

import java.util.Scanner;

public class Q7Array{
   public static void main(String[] args) {
   	int[] A = new int[12];
      int[] B = new int[12];
   	
      // Preenche todo o arranjo com a sequencia de Fibonacci
      preencheFibonacci(A);
      preencheFibonacciRecurcivo(B,B.length-1);
       
      
      //Escrece Arranjos
   	
      escreveArranjo(A);      
      escreveArranjo(B);
      
   }//fim main
   
   /*
   * Argumento: int[] x , posição a ser preenchida (i < x.length)
   * retorna x[i]
   */
   public static int preencheFibonacciRecurcivo(int[] x, int i){
      
      if(i <= 1){
         x[i] = 1;
      }else{
         x[i] = preencheFibonacciRecurcivo(x, i-1) + preencheFibonacciRecurcivo(x, i-2);
      }
      
      return x[i];
   }//fim preencheFibonacciRecurcivo
   
   public static void preencheFibonacci(int[] x){
      x[0] = 1;
      x[1] = 1;
      for(int i = 2 ; i < x.length ; i++){
         x[i] = x[i-1] + x[i-2];
      }
   }//fim preencheFibonacci
      
   public static int posicaoMaior(int[] x){
      int posicao = 0;
      int maior = x[0];
      
      for(int i = 0 ; i < x.length ; i++){
         if(maior < x[i]){
            posicao = i;
            maior = x[i];
         }
      }
      
      return posicao;
   }//fim posicaoMaior
   
   public static void trocaElemontos(int[] x, int p1 , int p2 ){
      int aux = x[p1];
      
      x[p1] = x[p2];
      x[p2] = aux;
      
   }//fim trocaElemontos
   
   public static void escreveArranjo(int[] x){
      System.out.print(x[0]);
      for(int i = 1 ; i < x.length ; i++){
         System.out.print(","+x[i]);
      }
      System.out.println("");
   }//fim escreve
   
   public static void leArranjo(int[] x){
      for(int i = 0 ; i < x.length ; i++){
         System.out.print("Digite um inteiro: ");
         x[i] = leInt();
      }
   }//fim leArray
   
    public static int leInt(){
      Scanner s = new Scanner(System.in);
      int valor = s.nextInt();
      return valor;
   }//fim leInt
   
}//fim class