package lista4;
/*
2. Calcular e escrever os n primeiros termos da sequ�ncia abaixo, sendo n um valor lido:
		1/100,   97/2,   3/94,   91/4,   5/88,   ... 
*/

import java.util.Scanner;

class Q2{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
           
      System.out.print("Digite o n�mero de termos a serem considerados: ");
      int n = s.nextInt();
      
      double h = 0;
      
      int num = 1;
      double den = 100.0;
      
      System.out.print("H = ");
      while(n != 0){
         if(num %2 != 0){
            h += num / den;
            System.out.print(" + ("+num+"/"+den+")");
         }else{
            h += den / num;
            System.out.print(" + ("+den+"/"+num+")");
         }
         num++;
         den -= 3;
         n--;
      }
      
      System.out.println("\nO valor de H: " + h);
   }
}