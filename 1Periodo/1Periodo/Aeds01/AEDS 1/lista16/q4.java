import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class q4{
   public static void main(String[] args){
   
      //System.out.println("Digite o nome do seu arquivo(exemplo.txt): ");
      //String nomeDoArquivo = leString();
      
      lerTexto("exemplo.txt");
   }
   
   public static void lerTexto(String nomeArq){
       try { 
           File arquivo = new File(nomeArq); 
           Scanner scanner = new Scanner(arquivo); 
           while(scanner.hasNext()){ 
             System.out.println(scanner.nextLine()); 
           } 
           scanner.close(); 
       }
       catch (FileNotFoundException fileNotFoundException) { 
           fileNotFoundException.printStackTrace(); 
       } 
     } 
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      return scanner.nextLine();
      
   }
   
}