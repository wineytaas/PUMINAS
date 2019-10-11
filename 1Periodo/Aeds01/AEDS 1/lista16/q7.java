import java.util.Scanner;
import java.io.*;

public class q7{
   public static void main(String[]args){
      String nomeArquivo = leString();
      int count = countCharArquivo(nomeArquivo);
      System.out.println("\nNo arquivo "+nomeArquivo+" existem "+count+" caracteres!");
   }
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      return scanner.nextLine();
   }
   
   public static int countCharArquivo(String nomeArquivo){
      File arquivo = new File(nomeArquivo);
      int numeroChar = 0;
      try( FileReader fr = new FileReader(arquivo) ){
         int  c = fr.read();
         while( c != -1){
             //System.out.print((char)c);
             c = fr.read();
             numeroChar++;
         } 
      } 
      catch(IOException ioException){ 
         System.out.print(ioException);
      }
	   return numeroChar;
   }
}