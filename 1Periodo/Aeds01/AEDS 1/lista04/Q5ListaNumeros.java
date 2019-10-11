package lista4;
import java.util.Scanner;
/**
 *
 * @author Wisney Tadeu de Almeida Assis dos Santos
 */
public class Q5ListaNumeros {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = 0;
        int num = 0;
        int soma = 0;
        System.out.println("Esse programa calcula a média de n números. Para sair do programa digite 0(zero):");
        do {
            System.out.print("? ");
            num = s.nextInt();
            soma += num;
            n++;
        } while (num != 0);
        n--;
        System.out.println("A média dos números digitados = "+soma/n);
        
    }
}
