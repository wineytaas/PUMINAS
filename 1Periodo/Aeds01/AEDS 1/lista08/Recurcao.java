public class Recurcao{
   public static void main(String[] args){
      System.out.println("Soma de 1 - 20 = " + somatorio(1.0 , 20.0));
   }//fim main
   
   public static double somatorio(double inicio, double fim){
      double soma = 0;
      if(inicio <= fim){
         soma = inicio + somatorio(inicio+1,fim);
      }
      
      return soma;
   }//fim somatorio
}// fim class