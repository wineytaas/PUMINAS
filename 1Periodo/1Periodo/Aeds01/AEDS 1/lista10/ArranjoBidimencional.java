/* ----------  LISTA 10 ----------
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data de inicio:      25/04/2017
*  Data ultima edição:  25/04/2017   
*  Versão: 1.0
*  
*/
public class ArranjoBidimencional{
   public static void main(String[] args){
      double[][] a = {{1,2,3},{3,4,5},{6,7,8}};
      double[][] b = {{9,8,7},{6,5,4},{3,2,1}};
      
      // exercicio 1
      System.out.println("---------------Exercicio 1---------------");
      copiaMatrixAB(a,b);
      
      System.out.println("Matrix A");
      escreveMatrix(a);
      System.out.println("\nMatrix B");
      escreveMatrix(b);
      
      //exercio 2
      System.out.println("\n---------------Exercicio 2---------------");
  
      boolean iguais = matrixAEhIgualMatrixB(a,b);
      
      System.out.println("\nMatrix A == Matrix B : " + iguais);
      
      //exercio 3
      System.out.println("\n---------------Exercicio 3---------------");
      double chave = 2;
      System.out.println("\nAparecem " + quantasChavesNaMatrix(a,chave) + " vezes o valor " + chave + " na matrix A");
      
      //exercio 4
      System.out.println("\n---------------Exercicio 4---------------");
      System.out.println("O maior valor da matrix se encontra na linha: " + linhaMaiorValorMatrix(a));
      
      //exercio 5
      System.out.println("\n---------------Exercicio 5---------------");
      System.out.println("O media da matrixA: " + mediaMatrix(a));
      System.out.println("Numero de elementos maiores que a media da matrixA: " + contaValoresMaioresMediaMatrix(a));
      
      //exercio 6
      System.out.println("\n---------------Exercicio 6---------------");
      System.out.println("Primeira linha iguala diagonal principal da matrix A : " + ehIgualDiagonalPrincipalEPrimeiraLinha(a));
      
      //exercio 7
      System.out.println("\n---------------Exercicio 7---------------");
      System.out.println("Maior valor acima da diagonal principal da matrix A : " + maiorValorAcimaDiagonalPrincipalMatrix(a));

      //gerencia de projetos de softwar // gestao de ti
      
      //exercio 8
      System.out.println("\n--------------- Exercicio 8 ---------------");
      //System.out.println("Maior valor acima da diagonal principal da matrix A : " + maiorValorAcimaDiagonalPrincipalMatrix(a));
      //System.out.println("Maior valor abaixo da diagonal principal da matrix A : " + maiorValorAbaixoDiagonalPrincipalMatrix(a));
      System.out.println("Diferenca entre os maiores valores acima e abaixo da diagonal principal da matrix A: " + diferencaMaiorValorAcimaAbaixoDiagonalPrincipalMatrix(a));
      
      //exercio 9
      System.out.println("\n--------------- Exercicio 9 ---------------");
      System.out.println("Soma dos valores da coluna 0 da matrix A: " + somaColunaMatrix(a,0));
      
      //exercio 10
      System.out.println("\n--------------- Exercicio 10 ---------------");
      System.out.println("Tem a chave '25' na matrix matrix A: " + temChavesMatrix(a, 25 ));
      System.out.println("Tem a chave '3' na matrix matrix A: " + temChavesMatrix(a,3));
      
   }//fim main
   
   public static boolean escreveMatrix(double[][] a){
      boolean faz;
      faz = true;
      for(int i = 0; i < a.length ; i++){
         System.out.print(a[i][0]);
         for(int j = 1 ; j < a[i].length; j++){
           System.out.print(", "+a[i][j]);
         }
         System.out.println(" ");
      }
      
      
      return faz;
   }//fim escreveMatrix
   
   public static boolean copiaMatrixAB(double[][] a, double[][] b ){
      boolean faz;
      if(a.length != b.length || a[0].length != b[0].length){
         faz = false;
      }else{
         faz = true;
         for(int i = 0; i < a.length ; i++){
            for(int j = 0 ; j < a[i].length; j++){
               b[i][j] = a[i][j];
            }
         }
      }
      
      return faz;
   }//fim copiaMatrixAB
   
   public static boolean matrixAEhIgualMatrixB(double[][] a, double[][] b ){
      boolean igual;
      if(a.length != b.length || a[0].length != b[0].length){
         igual = false;
      }else{
         int i = 0;
         int j = a[i].length;
         while(i < a.length && j == a[i].length){
            j = 0;
            while(j < a[i].length && a[i][j] == b[i][j]){
               j++;
            }//fim while(j)
            i++;
         }//fim while(i)
         
         if(i < a.length){
            igual = false;
         }else{
            igual = true;
         }
         
      }//fim if else
      
      return igual;
   }//fim matrixAEhIgualMatrixB
   
   
   public static int quantasChavesNaMatrix(double[][] a, double b ){
      int chaves = 0;
      
      for(int i = 0 ; i < a.length ; i++){
         for(int j = 0 ; j < a[i].length ;j ++){
            if(a[i][j] == b)
               chaves++;
         }//fim for(j)
      }//fim for(i)
      
      return chaves;
   }//fim quantasChavesNaMatrix
   
   public static int linhaMaiorValorMatrix(double[][] a){
      double maior = a[0][0];
      int linha = 0;
      
      for(int i = 0 ; i < a.length ; i++){
         for(int j = 0 ; j < a[i].length ;j ++){
            if(a[i][j] > maior){
               maior = a[i][j];
               linha = i;
            }//fim if
         }//fim for(j)
      }//fim for(i)
      
      return linha;
   }//fim linhaMaiorValorMatrix
   
   
   public static double mediaMatrix(double[][] a){
      double soma = 0;
      double media;
      for(int i = 0 ; i < a.length ; i++){
         for(int j = 0 ; j < a[i].length ;j ++){
            soma = soma + a[i][j];
         }//fim for(j)
      }//fim for(i)
      
      media = soma /(double)(a.length*a[0].length);
      
      return media;
   }//fim mediaMatrix
   
   
   public static int contaValoresMaioresMediaMatrix(double[][] a){
      int conta = 0;
      double media = mediaMatrix(a);
      for(int i = 0 ; i < a.length ; i++){
         for(int j = 0 ; j < a[i].length ;j ++){
            if(a[i][j] > media){
               conta++;
            }
         }//fim for(j)
      }//fim for(i)
            
      return conta;
   }//fim contaValoresMaioresMediaMatrix
   
   
   public static boolean ehIgualDiagonalPrincipalEPrimeiraLinha(double[][] a){
      boolean igual;
      if(a.length != a[0].length){
         igual = false;
      }else{
         int i = 0;
         while(i < a.length && a[0][i] == a[i][i]){
            i++;
         }//fim while(i)
         
         if(i < a.length){
            igual = false;
         }else{
            igual = true;
         }
         
      }//fim if else
      
      return igual;
   }//fim ehIgualDiagonalPrincipalEPrimeiraLinha
   
   /*
     |00 01 02 03 04 05
   --------------------
   00|   01 02 03 04 05
   01|      12 13 14 15
   02|         23 24 25
   03|            34 35
   04|               45
   05|                 
      
   */
      
   public static double maiorValorAcimaDiagonalPrincipalMatrix(double[][] a){
      double maior = a[0][1];
      int linha = 0;
      
      for(int i = 1 ; i < a.length ; i++){
         for(int j = i+1 ; j < a[i].length ;j ++){
            if(a[i][j] > maior){
               maior = a[i][j];
            }//fim if
         }//fim for(j)
      }//fim for(i)
      
      return maior;
   }//fim maiorValorAcimaDiagonalPrincipalMatrix
   
   public static double maiorValorAbaixoDiagonalPrincipalMatrix(double[][] a){
      double maior = a[0][1];
      int linha = 0;
      
      for(int i = 1 ; i < a.length ; i++){
         for(int j = i-1 ; j >= 0 ;j--){
            if(a[i][j] > maior){
               maior = a[i][j];
            }//fim if
         }//fim for(j)
      }//fim for(i)
      
      return maior;
   }//fim maiorValorAbaixoDiagonalPrincipalMatrix
   
   public static double diferencaMaiorValorAcimaAbaixoDiagonalPrincipalMatrix(double[][] a){
      double maiorAcima = maiorValorAcimaDiagonalPrincipalMatrix(a);
      double maiorAbaixo = maiorValorAbaixoDiagonalPrincipalMatrix(a);
      
      double diferenca = maiorAcima - maiorAbaixo;
     
      return diferenca;
   }//fim diferencaMaiorValorAcimaAbaixoDiagonalPrincipalMatrix
   
   
   public static double somaColunaMatrix(double[][] a, int coluna){
      double soma = 0;
      if(0 <= coluna && coluna < a[0].length ){
         for(int i = 0 ; i < a[coluna].length ; i++){
            soma = soma + a[i][coluna];
         }//fim for(i)
      }//fim if
            
      return soma;
   }//fim somaColunaMatrix(a,1)
   
   
   public static boolean temChavesMatrix(double[][] a, double b ){
      boolean chave = a[0][0] == b;
      
      int i = 0;
      int j = 0;
      
      while(i < a.length && !chave){
         j = 0;
         while(j < a[i].length && !chave){
            chave = a[i][j] == b;
            j++;
         }
         i++;
      }
      
      return chave;
   }//fim temChavesMatrix
   
}//fim ArranjoBidimencional