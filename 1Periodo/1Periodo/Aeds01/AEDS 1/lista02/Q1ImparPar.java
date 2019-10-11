package lista2;
import java.util.Scanner;
/**
 *
 * @author Wisney Tadeu de Almeida Assis dos Santos
 */
public class Q1ImparPar {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um inteiro: ");
        int in = ler.nextInt();
        if (in%2 == 0) {
            System.out.println("Par");
        }else{
            System.out.println("Impar");
        }
    }
}
