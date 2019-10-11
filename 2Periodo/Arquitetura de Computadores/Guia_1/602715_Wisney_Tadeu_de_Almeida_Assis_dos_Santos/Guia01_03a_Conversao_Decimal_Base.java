import java.util.Scanner;

public class Guia01_03a_Conversao_Decimal_Base{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      int x = s.nextInt();
      int base = s.nextInt();
      escreveEspelhado(dec2base(base, x));   
   }
   
   public static String dec2base(int base,int x){
      String result = "";
      while(x > 0){
         //System.out.println(x + " % " + base + " = " + x % base);
         if(x % base <= 9){
            result += x % base ;
         }else{
            result += (char)(((x % base) - 10) + 'A');
         }
         x = x / base; 
      }
      
      return result;
   }
   
   public static void escreveEspelhado(String str){
      for(int i = str.length() - 1 ; i >= 0 ; i--){
         System.out.print(str.charAt(i));
      }
   }
}