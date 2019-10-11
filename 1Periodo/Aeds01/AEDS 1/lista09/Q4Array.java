/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data de inicio:      18/04/2017
*  Data ultima edição:  18/04/2017   
*  Versão: 1.0
*  Funcionalidade: Ordena os elementos de  
*  um Arranjo em ordem crescente
*/

import java.util.Scanner;

public class Q4Array{
   public static void main(String[] args) {
     	int[] A = {6, 5, 4, 3, 2, 1};
   	int[] B = {3, 1, 6, 4, 2, 5};
   	int[] C = new int[6];
   	
      // Preenche todo o arranjo com valores lidos
      
      leArranjo(C);  
      
      // Desloca o maior valor do arranjo para a última posição
   	
      ordena(A);   
   	ordena(B);
   	ordena(C);
      
      // Escreve na tela todo o arranjo
      
   	escreveArranjo(A);   
   	escreveArranjo(B);
   	escreveArranjo(C);
   }//fim main
   
   public static void ordena(int[] x){
      
      for(int i = 0 ; i < x.length ; i++){
         for(int j = i+1 ; j < x.length ; j++){
            if(x[i] > x[j]){
               trocaElemontos(x, i , j);
            }
         }
      }
      
      
   }//fim deslocaMaiorFinal
   
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
         System.out.println("Digite um inteiro: ");
         x[i] = leInt();
      }
   }//fim leArray
   
    public static int leInt(){
      Scanner s = new Scanner(System.in);
      int valor = s.nextInt();
      return valor;
   }//fim leInt
   
}//fim class