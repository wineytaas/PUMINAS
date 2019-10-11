/***************************************************************
 * Nome do programa: Perimetro de um Retângulo
 * Data da elaboração: 28/3/2017
 * Autor: Wisney Tadeu de Almeida Assis dos Santos
 * Objetivo: Calcula o perimetro de um retangulo qualquer
 * Argumentos: lado e altura(valores reais, positivos não nulos)
 * Valor gerado: perimetro do retangulo
 ****************************************************************
 */
 
 import java.util.Scanner;
 
 public class Q5Perimetro{
   public static void main(String[] args){
      double base, altura;
      double perimetro = perimetroRetangulo(leLado("a base"), leLado("a altura"));
      escrevePerimetro(perimetro);
   }//fim main
   
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
   
   public static void escrevePerimetro(double perimetro){
      System.out.println("O perimetro deste Retangulo eh: "+perimetro);
   }//fim escrevePerimetro
   
   public static double perimetroRetangulo(double base, double altura){
      double perimetro;
      
      perimetro = 2*base + 2*altura;
      
      return perimetro;
   }//fim perimetroRetangulo
   
 }//fim class