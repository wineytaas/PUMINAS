import java.util.Scanner;
import java.io.File;
import java.io.*;

public class q8{
   public static void main(String[] args){
   
      //System.out.println("Digite o nome do seu arquivo(exemplo.txt): ");
      //String nomeDoArquivo = leString();
      String nomeDoArquivo = "exemplo.txt";
      File arquivo = new File(nomeDoArquivo);
      escreveArquivo(arquivo);
   }
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      return scanner.nextLine();
      
   }
   
   public static void escreveArquivo(File arquivo){
      try( FileReader fr = new FileReader(arquivo) ){
         int  c = fr.read();
         while( c != -1){
             System.out.print((char)c);
             c = fr.read();
         } 
      } 
      catch(IOException ioException){ 
         System.out.print(ioException);
      }
   }
   
}