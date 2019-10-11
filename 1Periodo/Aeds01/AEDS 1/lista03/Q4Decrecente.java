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
public class Q4Decrecente {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Decrecente"+"\nDigite o maior valor: ");
        int maior = s.nextInt();
        System.out.println("Digite o menor valor: ");
        int menor = s.nextInt();
        
        System.out.println("Valores em ordem decrecente: ");
        
        while (maior >= menor){
            System.out.println(maior);
            maior--;
        }
        
    }
    
}
