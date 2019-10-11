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
public class Q5MediaIdade {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        //Coletar o numero de alunos
        System.out.print("Digite o número de alunos: ");
        int n = s.nextInt();
        
        int c = n; // Contador
        int idade = 0; //Soma da idade dos alunos
        while(c > 0){
            System.out.print("Digite a idade do aluno: ");
            idade += s.nextInt();
            c--;
        }
        System.out.println("Media da idade dos alunos: " + idade/n);
    }
}
