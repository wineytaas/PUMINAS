/***************************************************************
 * Nome do programa: Q2AprovacaoDeAluno
 * Data da elaboração: 28/3/2017
 * Autor: Wisney Tadeu de Almeida Assis dos Santos
 * Objetivo: Saber se um aluno foi ou não aprovado por meio de duas de suas notas
 * Argumentos: Notas do aluno
 * Valor gerado: Aprovado/Não Aprovado
 ****************************************************************
 */
 
import java.util.Scanner;
 
 
public class Q2AprovacaoAluno{
   public static void main(String[] args){
      apresentacao();
      escreveAprovado(notaFinal(leNota(),leNota()));
      
   }//fim main
   
   public static void apresentacao(){
      System.out.println("Aprovacao de Alunos\n"
                         +"Esse programa diz se um aluno foi aprovado por meio de seuas notas");
   }//fim apresentacao
   
   public static double leNota(){
      double nota = 0;
      boolean errado;
      Scanner s = new Scanner(System.in);
      
      do{
         System.out.print("Digite a nota do aluno: ");
         nota = s.nextDouble();
         
         errado = nota < 0 || nota > 50;
         
         if(errado)
            System.out.println("Nota invalida! Digite uma nota entre 0  e 50!");
            
      }while(errado);
      
      return nota;
   }//fim leNota
   
   public static boolean foiAprovado(double nota){
      boolean aprovado = false;
      
      if(nota >= 60) aprovado = true;
      
      return aprovado;
   }//fim aprovado
   
   public static void escreveAprovado(double notaFinal){
      if(foiAprovado(notaFinal))
         System.out.println("\n O aluno foi aprovado!");
      else
         System.out.println("\n O aluno nao foi aprovado!");
   }//fim escreveAprovado
   
   public static double notaFinal(double notaUm, double notaDois){
      double somaNota = notaUm + notaDois;
      
      return somaNota;
   }//fim notaFinal
   
}//fim class