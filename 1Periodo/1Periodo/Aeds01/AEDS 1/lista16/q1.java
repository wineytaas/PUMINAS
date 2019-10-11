import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class q1{
   public static void main(String[] args){
   
      System.out.println("Digite o nome do seu arquivo(exemplo.txt): ");
      String nomeDoArquivo = leString();
      
      File arquivo = new File(nomeDoArquivo);
      try{
         if( arquivo.createNewFile() ){
            System.out.println("Foi criado o arquivo exemplo.txt");
         }
      }
      catch(IOException ioException){
         System.out.print(ioException);
      }
       if( arquivo.exists() ){
          System.out.println("Nome: " + arquivo.getName());
          System.out.println("Tamanho: " + arquivo.length());
          System.out.println("Diretório: "+ arquivo.getPath());
       } 
       else {
           System.out.println("Arquivo inexistente.");
      }
   }
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      return scanner.next();
      
   }
   
}