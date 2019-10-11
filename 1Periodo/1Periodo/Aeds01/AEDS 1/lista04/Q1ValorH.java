package lista4;

/*
1. Calcular e escreve o valor de H, sendo H igual a:
		H = 1/100 + 1/97 + 1/94 + 1/91 + ...
   A precis�o de H (o n�mero de termos a serem considerados no somat�rio) dever� ser um valor lido.
	Obs: n�o se esque�a que o operador de divis�o em Java � sobrecarregado: 
   divis�o inteira e divis�o real � a opera��o � definida em termos do tipo dos operandos.
*/

import java.util.Scanner;

class Q1ValorH{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
           
      System.out.print("Digite o número de termos a serem considerados: ");
      int n = s.nextInt();
      
      double h = 0;
      
      int num = 100;
      System.out.print("H = ");
      
      while(n != 0){
         h += 1.0/num;
         System.out.print(" + (1/"+num+")");
         num -= 3; 
         n--;
      }
      
      System.out.println("\nO valor de H: " + h);
   }
}