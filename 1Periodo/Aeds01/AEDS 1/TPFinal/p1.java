import java.util.Scanner;
import java.util.InputMismatchException;

public class p1{
   public static void main(String[]args){
      double[][] matriz = new double[5][5];
      double[][] matrizTransposta = new double[5][5];
      
      
      /*for(int i = 0 ; i < matriz.length ; i++){
         for(int j = 0 ; j < matriz[i].length ; j++){
            matriz[i][j] = (i+1)*(j+1);
         }
      }*/
      
      preencherMatrizReais(matriz);
      
      escreveMaiorValorDasLinhas(matriz);
      
      System.out.println("Media diagonal Principal: "+mediaDiagonal(matriz));
      System.out.println("Maior valor abaixo diagonal Principal: "+ maiorAbaixoDiagonal(matriz));
      System.out.println("Coluna do maior valor da matriz: "+ colunaMaiorValor(matriz));
      System.out.println("Coluna do maior valor da matriz: "+ linhaMaiorValor(matriz));
      
      transposta(matriz,matrizTransposta);
      
      escreveMatriz(matriz);
      
      System.out.println("\nTransposta\n");
      escreveMatriz(matrizTransposta);
      
   }
   
   public static void escreveMatriz(double[][] matriz){
      try{
         for(int i = 0 ; i < matriz.length ; i++){
            for(int j = 0 ; j < matriz[i].length ; j++){
                 System.out.print(matriz[i][j]+" ");
            }
            System.out.println(" ");
         }
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
         System.err.println("Posicao invalida do arranjo!");
      }
   }
   
   public static void transposta(double[][] matriz,double[][] matrizTransposta ){
      
      try{
         if(matriz.length == matrizTransposta[0].length && matriz[0].length == matrizTransposta.length){
            for(int i = 0 ; i < matriz.length ; i++){
               for(int j = 0 ; j < matriz[i].length ; j++){
                    matrizTransposta[j][i] = matriz[i][j];
               }
            }
         }
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
         System.err.println("Posicao invalida do arranjo!");
      }
   }
   
   public static int linhaMaiorValor(double[][] matriz){
      int linha = 0;
      double maior = matriz[0][0];
      try{
         for(int i = 0 ; i < matriz.length ; i++){
            for(int j = 0 ; j < matriz[i].length ; j++){
               if(maior < matriz[i][j]){
                  maior = matriz[i][j];
                  linha = i;
               }   
            }
         }
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
         System.err.println("Posicao invalida do arranjo!");
      }
      
      return linha;
   }
   
   
   public static int colunaMaiorValor(double[][] matriz){
      int coluna = 0;
      double maior = matriz[0][0];
      try{
         for(int i = 0 ; i < matriz.length ; i++){
            for(int j = 0 ; j < matriz[i].length ; j++){
               if(maior < matriz[i][j]){
                  maior = matriz[i][j];
                  coluna = j;
               }   
            }
         }
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
         System.err.println("Posicao invalida do arranjo!");
      }
      
      return coluna;
   }
   
   
   public static double maiorAbaixoDiagonal(double[][] matriz){
      double maior = matriz[0][1];
      try{
         for(int i = 0 ; i < matriz.length ; i++){
            for(int j = 0 ; j < i ; j++){
               if(maior < matriz[i][j]){
                  maior = matriz[i][j];
               }   
            }
         }
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
         System.err.println("Posicao invalida do arranjo!");
      }
      
      return maior;
   }
   
   public static double mediaDiagonal(double[][] matriz){
      double media = 0;
      double soma = 0;
      try{
         for(int i = 0 ; i < matriz.length ; i++){
            soma = soma + matriz[i][i];
         }
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
         System.err.println("Posicao invalida do arranjo!");
      }
      media = soma /(double) matriz.length;
      return media;
   }
   
   public static void escreveMaiorValorDasLinhas(double[][] matriz){
      for(int i = 0 ; i < matriz.length ; i++){
         System.out.println("Maior valor linha["+i+"] : "+maiorValorLinha(matriz,i));
      }
   
   }
   
   public static double maiorValorLinha(double[][] matriz , int linha){
      double maiorValor = matriz[linha][0];
      
      for(int j = 1 ; j < matriz[linha].length ; j++){
         if(maiorValor < matriz[linha][j]){
            maiorValor = matriz[linha][j];
         }
      }
      
      return maiorValor;
   }
   
   public static void preencherMatrizReais(double matriz[][]){
      for(int i = 0 ; i < matriz.length ; i++){
         for(int j = 0 ; j < matriz[i].length ; j++){
            matriz[i][j] = leReal();
         }
      }
   }
   
   public static double leReal(){
      double valor = 0;
      boolean erro = true;
      do{
         try{
            Scanner scanner = new Scanner(System.in);
            valor = scanner.nextDouble();
            erro = false;
         }
         catch(InputMismatchException inputMismatchException){
            System.out.println("\nDigite um valor real!!\n");
         }
      }while(erro);
      
      
      return valor;
   }
}