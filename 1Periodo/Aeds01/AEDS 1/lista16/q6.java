import java.util.Scanner;
import java.io.File;
import java.io.*;

public class q6{
   public static void main(String[] args){
   
      //System.out.println("Digite o nome do seu arquivo(exemplo.txt): ");
      //String nomeDoArquivo = leString();
      BufferedReader br = null;
      try{
        OutputStream os = new FileOutputStream("exemplo.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        System.out.println("Endereco: ");
        String endereco = leString();
        bw.write(endereco+"\n");
        bw.close();
   
        InputStream is = new FileInputStream("exemplo.txt");
        InputStreamReader isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        String str = br.readLine(); // lê a primeira linha   
        while (str != null) {
           System.out.println(str);
    	 str = br.readLine();
        }
        
   
      }
      catch(IOException ioexception){
          System.err.println(ioexception);
      }
      finally{
         try{
            br.close();
         }catch(Exception exception){
            System.err.println(exception);
         }
      }   
   }
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      return scanner.nextLine();
      
   }
   
}