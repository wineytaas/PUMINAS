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
public class Q1CalculadoraSwitchWhile {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        int q = 0;
        double a = 0;
        double b = 0;
        double resultado = 0;
        
        System.out.print("Escolha uma operação:"
            + "\n1 - soma"
            + "\n2 - subitração"
            + "\n3 - multiplicação"
            + "\n4 - divisão"
            + "\n?  ");
        q = ler.nextInt();
            
            
        switch(q){
            case 1:
                System.out.println("Digite os valores separados por espaço (a b) : ");
                a = ler.nextInt();
                b = ler.nextInt();
                resultado = a + b;
                System.out.println(a + " + " + b + " = " + resultado );
                break;
            case 2:
                System.out.println("Digite os valores separados por espaço (a b) : ");
                a = ler.nextInt();
                b = ler.nextInt();
                resultado = a - b;
                System.out.println(a + " - " + b + " = " + resultado );
                break;
            case 3:
                System.out.println("Digite os valores separados por espaço (a b) : ");
                a = ler.nextInt();
                b = ler.nextInt();
                resultado = a * b;
                System.out.println(a + " * " + b + " = " + resultado );
                break;
            case 4:
                System.out.println("Digite os valores separados por espaço (a b) : ");
                a = ler.nextInt();
                b = ler.nextInt();
                resultado = a / b;
                System.out.println(a + " / " + b + " = " + resultado );
                break;
            default:
                System.out.println("Opção invalida!! ");
                break;
        }
    }
}
