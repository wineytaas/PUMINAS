import java.util.Scanner;

public class Guia01_02a_Conversao_Binario_Decimal{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      String bin = s.next();
      int dec = bin2dec(bin);
      System.out.println(dec);   
   }
   
   public static int bin2dec(String x){
      int decimal = 0;
      for(int i = 0 ; i < x.length() ; i++){
         decimal += ((int) (x.charAt((x.length() - 1) - i) - '0')) * Math.pow(2,i);
      } 
      return decimal;
   }
   
   public static void escreveEspelhado(String str){
      for(int i = str.length() - 1 ; i >= 0 ; i--){
         System.out.print(str.charAt(i));
      }
   }
}