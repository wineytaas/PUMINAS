/* ----------  LISTA 10 ----------
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data de inicio:      25/04/2017
*  Data ultima edição:  25/04/2017   
*  Versão: 1.0
*  
*/
public class Q3MinMax{
   public static void main(String[] args){
      double[][] a = {{1,2,3},{3,4,5},{6,7,8}};
      System.out.println("MinMax: " + minMax(a));      
   }//fim main
   
   public static double maiorValorLinha(double[][] a, int linha){
      double maior = a[linha][0];
      for(int i = 0 ; i < a.length ; i++){
         if(maior < a[linha][i]) maior = a[linha][i];
      }
      return maior;
   }
   
   public static int linhaMenorValorMatrix(double[][] a){
      double menor = a[0][0];
      int linha = 0;
      for(int i = 0 ; i < a.length ; i++){
         for(int j = 0 ; j < a.length ; j++){
            if(menor > a[i][j]){
               menor = a[i][j];
               linha = i;
            } 
         }
      }
      return linha;
   }
   
   public static double minMax(double[][]a){
      return maiorValorLinha(a,linhaMenorValorMatrix(a));
   }
   
}//fim ArranjoBidimencional