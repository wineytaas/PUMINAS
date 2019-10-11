import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class q2{
   public static void main(String[] args){
   
      //System.out.println("Digite o nome do seu arquivo(exemplo.txt): ");
      //String nomeDoArquivo = leString();
      
      File arquivo = new File("exemplo.txt");
      
      try( FileWriter fw = new FileWriter(arquivo) ){
         System.out.print("Nome: ");
         String dado = leString();
         fw.write(dado+"\n");
         
         System.out.print("Numero de matricula: ");
         dado = leString();
         fw.write(dado+"\n");
         
         System.out.print("Telefone: ");
         dado = leString();
         fw.write(dado+"\n");
         
         System.out.print("E-mail: ");
         dado = leString();
         fw.write(dado+"\n");
         
      }
      catch(IOException ioException){
         System.out.print(ioException);
      }
      finally{
         fw.flush();
      }
   }
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      return scanner.nextLine();
      
   }
   
}