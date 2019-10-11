import java.util.Scanner;

public class Guia01_05a_Conversao_ASC{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      String str = s.next();
      ASCII2hex(str);
      System.out.println();
      
   }
   
   public static void ASCII2hex(String str){
      int base = 16;
      for(int i = 0 ; i < str.length() ; i++){
         escreveEspelhado(dec2base(base, str.charAt(i)));
         System.out.print(" ");
      }
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