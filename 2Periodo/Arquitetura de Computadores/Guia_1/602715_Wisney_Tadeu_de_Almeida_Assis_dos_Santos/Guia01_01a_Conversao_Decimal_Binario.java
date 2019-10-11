import java.util.Scanner;

public class Guia01_01a_Conversao_Decimal_Binario{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      int decimal = s.nextInt();
      escreveEspelhado(dec2bin(decimal));      
   }
   
   public static String dec2bin(int x){
      String binario = "";
      int decimal = x;
      while(decimal > 0){
         binario += (char) decimal%2;
         decimal = (int) decimal / 2;
      }
      return binario; 
   }
   
   public static void escreveEspelhado(String str){
      for(int i = str.length() - 1 ; i >= 0 ; i--){
         System.out.print(str.charAt(i));
      }
   }
}