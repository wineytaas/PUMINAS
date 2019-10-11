import java.util.Scanner;
import java.io.File;
import java.io.*;

public class q5{
   public static void main(String[] args){
   
      //System.out.println("Digite o nome do seu arquivo(exemplo.txt): ");
      //String nomeDoArquivo = leString();
      
      try{
        InputStream is = new FileInputStream("exemplo.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine(); // lê a primeira linha
        
        while (str != null) {
           System.out.println(str);
    	     str = br.readLine();
        }
        br.close();
      }
      catch(IOException ioexception){
          System.err.println(ioexception);
      }      
   }
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      return scanner.nextLine();
      
   }
   
}