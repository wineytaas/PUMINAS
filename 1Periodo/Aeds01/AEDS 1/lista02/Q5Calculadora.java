package lista2;
import java.util.Scanner;

/**
 *
 * @author Wisney Tadeu de Almeida Assis dos Santos
 */
public class Q5Calculadora {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.print("Escolha uma operação:"
                + "\n1 - soma"
                + "\n2 - subitração"
                + "\n3 - multiplicação"
                + "\n4 - divisão"
                + "\n?  ");
        int q = ler.nextInt();
        double a = 0;
        double b = 0;
        double resultado = 0;
        if( q == 1){
            System.out.println("Digite os valores separados por espaço : ");
            a = ler.nextInt();
            b = ler.nextInt();
            resultado = a + b;
            System.out.println(a + " + " + b + " = " + resultado );
        }
        if( q == 2){
            System.out.println("Digite os valores separados por espaço : ");
            a = ler.nextInt();
            b = ler.nextInt();
            resultado = a - b;
            System.out.println(a + " - " + b + " = " + resultado );
        }
        if( q == 3){
            System.out.println("Digite os valores separados por espaço : ");
            a = ler.nextInt();
            b = ler.nextInt();
            resultado = a * b;
            System.out.println(a + " * " + b + " = " + resultado );
        }
        if( q == 4){
            System.out.println("Digite os valores separados por espaço : ");
            a = ler.nextInt();
            b = ler.nextInt();
            resultado = a / b;
            System.out.println(a + " / " + b + " = " + resultado );
        }
    }
    
}
