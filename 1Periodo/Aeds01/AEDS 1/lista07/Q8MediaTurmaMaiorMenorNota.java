/***************************************************************
 * Nome do programa: Maior , Menor e Media das Notas da Turma
 * Data da elaboração: 28/3/2017
 * Autor: Wisney Tadeu de Almeida Assis dos Santos
 * Objetivo: calcular a Maior , a Menor e a Media das Notas da Turma
 * Argumentos: nota dos N alunos
 * Valor gerado: maior e menor nota alem da media da turma
 * 
 ****************************************************************
 */
 
 import java.util.Scanner;
 
 public class Q8MediaTurmaMaiorMenorNota{
   public static void main(String[] args){
      double nota = leNota();
      double maior = nota , menor = nota , soma = 0;
      int alunos = 0; 
      
      while(nota != -1){
         soma = soma + nota;
         maior = ohMaior( nota , maior);
         menor = ohMenor( nota , menor);
         nota = leNota();
         alunos++;
      }
      
      escreveMedia(soma,alunos);
      escreveMaiorMenor(maior,menor);
      
   }//fim main
   
   public static void escreveMaiorMenor(double maior, double menor){
      if(maior != -1){
         System.out.println("Maior: "+maior);
         System.out.println("Menor: "+menor);
      }else{
         System.out.println("Maior: 0");
         System.out.println("Menor: 0");
      }
   }//fim escreveMaiorMenor
   
   public static void escreveMedia(double soma, int alunos){
      if(alunos == 0){
         System.out.println("Media nao pode ser calculada!");
      }else{
         double media = soma/(double)alunos;
         System.out.println("Media: "+ media);
      }
   }//fim escreveMedia
   
   public static double ohMenor(double a , double b){
      double menor = a;
      if(b < a) menor = b;
      return menor;
   }//fim ohMenor
   
   public static double ohMaior(double a , double b){
      double maior = a;
      if(b > a) maior = b;
      return maior;
   }//fim ohMaior
      
   public static double leNota(){
      Scanner s = new Scanner(System.in);
      double nota;
      boolean errado;
      
      do{
         System.out.print("Digite a nota[-1 - sair]: ");
         nota = s.nextDouble();
         errado = (0 > nota || nota > 100) && nota != -1 ;
         if(errado)System.out.println("\nValor invalido! Digite uma nota entre 0 - 100!");
      }while(errado);
      
      return nota;
   }//fim leNota
   
}//fim class