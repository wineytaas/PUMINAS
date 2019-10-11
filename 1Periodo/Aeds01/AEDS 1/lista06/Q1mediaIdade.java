import java.util.Scanner;
public class Q1mediaIdade{
   public static void main(String[] args){
      int soma = 0, numeroPessoas = 0, idade = leIdade();
      double media;
      
      while(idade != 0){
         soma = soma  + idade;
         numeroPessoas++;
         
         idade = leIdade();
      }
      
      if(numeroPessoas != 0){
         media = (double)soma / (double) numeroPessoas;
         System.out.println("\nMedia das idades: "+media);
      }else{
         System.out.println("\nMedia das idades: nao foi calculada");
      }
      
      
      
   }//fim main
   
   public static int leIdade(){
      Scanner s = new Scanner(System.in);
      int idade;
      boolean erro;
      do{
         System.out.print("Digite uma idade[0-sair]: ");
         idade = s.nextInt();
         erro = idade < 0 || idade > 150;
         if(erro)
            System.out.println("Idade invalida! Digite uma idade de 0 a 150!");
      }while(erro);
      
      return idade;
   }//fim leIdade
   
}//fim class