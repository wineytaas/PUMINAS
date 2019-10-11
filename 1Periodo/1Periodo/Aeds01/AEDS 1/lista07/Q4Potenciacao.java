/***************************************************************
 * Nome do programa: Potenciacao
 * Data da elaboração: 28/3/2017
 * Autor: Wisney Tadeu de Almeida Assis dos Santos
 * Objetivo: Calcula a potencia de numeros inteiro
 * Argumentos: base e expoente / b^e onde b && e positivos e inteiros
 * Valor gerado: potencia de b^e
 ****************************************************************
 */
 import java.util.Scanner;
 
 public class Q4Potenciacao{
   public static void main(String[] args){
      int base = leInt("base"), 
          potencia = leInt("potencia");
      long resultadoPotencia = potenciacao(base,potencia);
      escreveResultado(resultadoPotencia);
   }//fim main
   
   public static long potenciacao(int base, int potencia){
      long resultado = 0;
      if(base >= 0) resultado = 1;
      
      while(potencia > 0){
         resultado = resultado * base;
         potencia--;
      }
      
      return resultado;
   }//fim potencia
   
   public static int leInt(String mensagem){
      
      Scanner s = new Scanner(System.in);
      boolean errado;
      int inteiro;
      
      do{
         System.out.print("Digite o valor da "+mensagem+": ");
         inteiro = s.nextInt();
         errado = inteiro < 0;
         if(errado) 
         System.out.println("\nValor invalido! Digite um valor positivo e inteiro para "+mensagem);
      }while(errado);
      
      return inteiro;
   }//fim leInt
      
   public static void escreveResultado(long resultado){
      System.out.println("\nResultado da potenciacao eh: "+resultado);
   }//fim escreveResultado
   
 }//fim class