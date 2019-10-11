package lista3;
import lista2.*;
import java.util.Scanner;
/**
 *
 * @author Wisney Tadeu de Almeida Assis dos Santos
 */
public class Q6Bissexto {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        int ano;
        char s;
        do {
            System.out.print("Digite um ano: ");
            ano = ler.nextInt();
            if(ano%4 == 0){
            if(ano%100 != 0){
                System.out.println("Ano Bissexto!");
            }else{
                if(ano%400 == 0){
                    System.out.println("Ano Bissexto!");
                }else{
                    System.out.println("Ano normal!");
                }
                
            }
        }else{
            System.out.println("Ano normal!");
        }
            System.out.println("Deseja testar outro ano?(s/n) ");
            s = ler.next().charAt(0);
        } while (s == 's');
        
        
    }
}
