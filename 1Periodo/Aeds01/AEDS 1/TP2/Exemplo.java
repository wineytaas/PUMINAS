import java.util.Scanner;

public class Exemplo {
	public static void main(String[] args) {
		double[][] M = new double[5][5];
		leMatriz(M);
		double maior = maiorMatriz(M); // maior valor da matriz
		double diagonalSec = somaDiagonalSec(M);  // soma da diagonal secudária
		if ( haZeros(M) ) {  // verifica se há valores iguais a zero na matriz
			System.out.println("Há " + qtZeros(M) + " valores iguais a zero."); // Qtde de zeros
		} // fim if
		System.out.println("Maior valor na matriz = " + maior);
		System.out.println("Soma da diagonal Secundária= " + diagonalSec);
		double[][] N = new double[5][5];
		leMatriz(N);
		if ( linhasIguais(M,N,0) ) {  // verifica se a primeira linha de ambas as matrizes são iguais
			System.out.println("A primeira linha das Matrizes são iguais."); 
		} // fim if
		
	} // fim main()
   
   public static void leMatriz(double[][] a){
      Scanner s = new Scanner(System.in);
      for(int i = 0 ; i < a.length ; i++){
         for(int j =  0 ; j < a[i].length ; j++){
            System.out.print("a["+i+"]["+j+"]: ");
            a[i][j]=s.nextDouble();
         }
      }
   }//fim leMatriz
   
   public static double maiorMatriz(double[][] a){
      double maior = a[0][1];
      int linha = 0;
      
      for(int i = 1 ; i < a.length ; i++){
         for(int j = 0 ; j < a[i].length ;j ++){
            if(a[i][j] > maior){
               maior = a[i][j];
            }//fim if
         }//fim for(j)
      }//fim for(i)
      
      return maior;
   }//fim maiorMatriz
   
   public static double somaDiagonalSec(double[][] a){
      double soma = 0;
      int p = a.length-1;
      
      for(int i = 0 ; i < a.length ; i++){
         soma = soma + a[i][p-i];
      }//fim for(i)
      
      return soma;
   }//fim somaDiagonalSec
   
   public static boolean haZeros(double[][] a){
      return haZeros(a, a.length-1, a.length-1);
   }//fim haZeros
   
   /*
      00 01 02 03
   00 00 01 02 03
   01 10 11 12 13
   02 20 21 22 23
   03 30 31 32 33
   
   */
   public static boolean haZeros(double[][] a, int i ,int j){
      boolean zero = false;
      
      if(j < 0){
         j = a[i].length-1;
         i--;
      }
      if(i < 0){
         zero = false;
      }else {
         if(a[i][j] == 0){
            zero = true;
         }else{
            zero = haZeros(a,i,j-1);
         }
      }
      return zero;
   }//fim haZeros
   
   public static int qtZeros(double[][] a){
      return qtZeros(a, a.length-1, a[0].length-1);
   }//fim qtZeros
   
   public static int qtZeros(double[][] a, int i ,int j){
      int zero;
      if(j < 0){
         j = a[i].length-1;
         i--;
      }
      if(i < 0){
         zero = 0;
      }else {
         if(a[i][j] == 0){
            zero = 1 + qtZeros(a,i,j-1);
         }else{
            zero = qtZeros(a,i,j-1);
         }
      }
      return zero;
   }//fim qtZeros
   
   public static boolean linhasIguais(double[][]m,double[][]n,int i){
      int j = 0;
      boolean iguais = true;
      if(m[i].length != n[i].length || i < 0 || i > m[i].length){
         iguais = false;
      }else{
         while(j < m[i].length && m[i][j] == n[i][j] ){
            j++;
         }
         if(j < m[i].length) iguais = false;
      }
      return iguais;
   }//fim linhasIguais

}// fim classe Exemplo
