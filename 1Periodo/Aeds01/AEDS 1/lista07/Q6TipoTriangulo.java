/***************************************************************
 * Nome do programa: Tipo de Triângulo
 * Data da elaboração: 28/3/2017
 * Autor: Wisney Tadeu de Almeida Assis dos Santos
 * Objetivo: indentificar se é um triângulo, se sim qual tipo(Escaleno, Isocele, Equilatero)
 * Argumentos: lados(valores reais, positivos não nulos)
 * Valor gerado: 
 *       0 – caso os valores dos lados não formam um triângulo;
 * 		1 – se triângulo equilátero
 * 		2 – se triângulo isóscele
 * 		3 – se triângulo escaleno
 * 
 ****************************************************************
 */
 
 import java.util.Scanner;
 
 public class Q6TipoTriangulo{
   public static void main(String[] args){
      double ladoA = leLado(" lado a "),
             ladoB = leLado(" lado b "),
             ladoC = leLado(" lado c ");
      int tipo = identificaTriangulo(ladoA, ladoB, ladoC);
      escreveTipoTriangulo(tipo);
   }//fim main
   
   public static void escreveTipoTriangulo(int tipo){
      switch(tipo){
         case 0:
            System.out.println("\nNao eh triangulo");
            break;
         case 1:
            System.out.println("\nEquilatero");
            break;
         case 2:
            System.out.println("\nIsocele");
            break;
         case 3:
            System.out.println("\nEscaleno");
            break;
         default:
            System.out.println("Opicao invalida!");
            break;
      }
   }//fim escreveTipoTriangulo
   
   public static int identificaTriangulo(double a, double b, double c){
      int tipo = 0;
      
      if(ehTriangulo(a,b,c)){
         if(ehEquilatero(a,b,c)) tipo = 1;
         else if(ehIsoceles(a,b,c)) tipo = 2;
         else if(ehEscaleno(a,b,c)) tipo = 3;
      }
      
      return tipo;
   }//fim identificaTriangulo
   
   public static double leLado(String mensagem){
      Scanner s = new Scanner(System.in);
      double lado;
      boolean errado;
      
      do{
         System.out.print("Digite "+mensagem+" : ");
         lado = s.nextDouble();
         errado = lado <= 0 ;
         if(errado)System.out.println("\nValor invalido! Digite um valor para "+mensagem+"  positivo maior que 0!\n");
      }while(errado);
      
      return lado;
   }//fim leLado
   
   public static boolean ehEquilatero(double a , double b, double c){
      boolean equilatero = false;
      if(a == b && a == c) equilatero = true;
      return equilatero;
   }//fim ehEquilatero
   
   public static boolean ehIsoceles(double a , double b, double c){
      boolean isoceles = false;
      if(a == b && a != c && b != c) isoceles = true;
      else if(a == c && a != b && b != c) isoceles = true;
      else if(b == c && a != b && a != c) isoceles = true;
      
      return isoceles;
   }//fim ehEscaleno
   
   public static boolean ehEscaleno(double a , double b, double c){
      boolean escaleno = false;
      if(a != b && a != c && b != c) escaleno = true;
      return escaleno;
   }//fim ehEscaleno
   
   public static boolean ehTriangulo(double a, double b, double c){
      boolean triangulo = false;
      if(Math.abs(b - c) < a && a < b + c
         && Math.abs( a - c ) < b && b < a + c
         && Math.abs( a - b ) < c && c < a + b)triangulo = true;
      
      return triangulo;
   }//fim ehTriangulo
   
   
 }//fim class