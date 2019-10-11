import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class q3{
   public static void main(String[] args){
   
      //System.out.println("Digite o nome do seu arquivo(exemplo.txt): ");
      //String nomeDoArquivo = leString();
      
      File arquivo = new File("exemplo.txt");
      
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
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      return scanner.nextLine();
      
   }
   
}