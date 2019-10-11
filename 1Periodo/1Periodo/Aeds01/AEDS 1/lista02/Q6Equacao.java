package lista2;
import java.util.Scanner;

/**
 *
 * @author Wisney Tadeu de Almeida Assis dos Santos
 */
public class Q6Equacao {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.println("ax² + bx + c = 0 ");
        System.out.print("a: ");
        double a = ler.nextDouble();
        System.out.print("b: ");
        double b = ler.nextDouble();
        System.out.print("c: ");
        double c = ler.nextDouble();
        
        double delta = Math.pow(b,2) - (4*a*c);
        double x = (-b + Math.sqrt(delta))/(2*a);
        double x1 = (-b - Math.sqrt(delta))/(2*a);
        System.out.println(a + " x² + ( " + b + " )x + ( " + c + " ) = 0 ");
        System.out.println("x' = " + x);
        System.out.println("x'' = " + x1);
        
    }
}
