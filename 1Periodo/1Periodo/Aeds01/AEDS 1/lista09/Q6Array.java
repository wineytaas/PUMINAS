/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data de inicio:      18/04/2017
*  Data ultima edição:  18/04/2017   
*  Versão: 1.0
*  Funcionalidade: Conta o número de elementos impares e pares em  
*  um Arranjo de modo Recurcivamente
*/

import java.util.Scanner;

public class Q6Array{
   public static void main(String[] args) {
     	int[] A = {6, 5, 4, 3, 2, 1};
   	int[] B = {3, 1, 6, 4, 2, 5};
      int[] C = new int[6];
   	
      // Preenche todo o arranjo com valores lidos
      
      leArranjo(C);  
      
      //Conta Impars Pares
   	
      escreveArranjo(A);
      System.out.println("Par(es): "+contaPar(A,0));
      System.out.println("Impar(es): "+contaImpar(A,0)+"\n");
      
      escreveArranjo(B);
      System.out.println("Par(es): "+contaPar(B,0));
      System.out.println("Impar(es): "+contaImpar(B,0)+"\n");
      
      escreveArranjo(C);
      System.out.println("Par(es): "+contaPar(C,0));
      System.out.println("Impar(es): "+contaImpar(C,0)+"\n");
   }//fim main
   
   public static int contaPar(int[] x, int i){
      int par;
      
      if(i >= x.length){
         par = 0;
      }else if(x[i]%2 == 0 && x[i] != 0){
         par = 1 + contaPar(x, i+1);
      }else{
         par = contaPar(x, i+1);
      }
      
      return par;      
   }//fim contaPar
   
   public static int contaImpar(int[] x, int i){
      int impar;
      if(i >= x.length){
         impar = 0;
      }else if(x[i]%2 == 0 && x[i] != 0){
         impar = 1 + contaImpar(x, i+1);
      }else{
         impar = contaImpar(x, i+1);
      }
      
      return impar;      
   }//fim contaImpar
      
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