package lista4;

import java.util.Scanner;

class Q3Votos{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      int op;
      int c1 = 0, c2 = 0, b = 0 , n = 0;
      
      do{
         System.out.print(
         "0 - Sair do Programa\n" +
		   "1 - Chapa 1\n"+
   		"2 - Chapa 2\n"+
   		"3 - Voto em branco\n"+
   		"4 - Voto nulo\n"+
         "? ");
         op = s.nextInt();
         
         switch(op){
            case 0:
               System.out.println("\nChapa 1: " + c1);
               System.out.println("Chapa 2: " + c2);
               System.out.println("Votos Brancos: " + b);
               System.out.println("Votos Nulos: " + n);
               if(c1 > c2){
                  System.out.println("Chapa 1 ganhou, com "+ (c1*100.0)/(c1+c2) +"% dos votos.");
               }else if(c1 < c2){
                  System.out.println("Chapa 2 ganhou, com "+ (c2*100.0)/(c1+c2) +"% dos votos.");
               }else{
                  System.out.println("As chapas empataram!!");
               }
               break;
            case 1:
               c1++;
               break;
            case 2:
               c2++;
               break;
            case 3:
               b++;
               break;
            case 4:
               n++;
               break;
            default:
               System.out.println("Inv�lida!");
               break;
         }
      }while(op != 0);
      
      
      
      
   }
}