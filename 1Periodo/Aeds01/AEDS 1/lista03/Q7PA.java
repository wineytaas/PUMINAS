/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3;
import java.util.Scanner;
/**
 *
 * @author Wisney Tadeu de Almeida Assis dos Santos
 */
public class Q7PA {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
       
        
        // n = Número de termos da P.A.
        System.out.print("Digite o número de termos da Progreção Arítimetica(P.A): ");
        int n = s.nextInt();
        n++;
        
        // a1 = Primeiro termo da sequência.
        System.out.print("Digite o valor do primeiro termo da sequência: ");
        int a1 = s.nextInt();
        
        // r = Razão
        System.out.print("Digite o valor da razão: ");
        int r = s.nextInt();
        
         int c = 1; // Contador
        //Termos
        while(n>c){
            System.out.println(a1+(c-1)*r);
            c++;
        }
            
    }
    
}
