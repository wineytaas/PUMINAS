import java.util.Scanner;

public class Guia01_04a_Conversao_Binario_Base{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      String bin = s.next();
      int base = s.nextInt();
      int dec = bin2dec(bin);
      System.out.println("\n= "+dec+"(10)");
      escreveEspelhado("\n)"+base+"("+dec2base(base, dec)+" =");   
   }
   
   public static int bin2dec(String x){
      int decimal = 0;
      for(int i = 0 ; i < x.length() ; i++){
         //System.out.println("\t2^" + i + " * "+ x.charAt((x.length() - 1) - i) +" = " + (((int) (x.charAt((x.length() - 1) - i) - '0')) * Math.pow(2,i)) + "\t+");
         decimal += ((int) (x.charAt((x.length() - 1) - i) - '0')) * Math.pow(2,i);
      } 
      return decimal;
   }
   
   public static String dec2base(int base,int x){
      String result = "";
      while(x > 0){
         //System.out.println("\t"+x + " % " + base + " = " + x % base);
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