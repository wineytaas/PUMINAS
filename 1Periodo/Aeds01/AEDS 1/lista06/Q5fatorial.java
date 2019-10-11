import java.util.Scanner;

public class Q5fatorial{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in); 
      int numero;
      int fatorial;
      int fatorialLoop;
      char repitir;
      boolean erro;
      
      do{
         numero = lerInt();
         fatorial = fatorial(numero);
         fatorialLoop = fatorialLoop(numero);
         
         System.out.println("\n"+numero+"! = "+fatorial);
         System.out.println(numero+"! = "+fatorialLoop+" Recursivo");
         
         do{
            System.out.println("Deseja repetir o programa[s/n]: ");
            repitir = s.next().charAt(0);
            erro = repitir != 's' && repitir != 'S' && repitir != 'n' && repitir != 'N';
            if(erro)
               System.out.println("\nValor invalido!! Digite um valor valido!(s,S,n,N)");
         }while(erro);
         
         erro = repitir == 's' || repitir == 'S';
      }while(erro);
      
      
   }//fim class
   
   public static int fatorial(int n){
      int fatorial = 1;
      for(int i = 2; i <= n; i++){
         fatorial = fatorial * i;
      }
      return fatorial;
   }//fim fatorial
   
   public static int fatorialLoop(int n){
      if(n > 1) 
         return n * fatorial(n-1);
         
      return 1;
   }//fim fatorialLoop
   
   public static int lerInt(){
      int inteiro;
      boolean erro;
      Scanner s = new Scanner(System.in);
      
      do{
         System.out.println("Digite um numero inteiro positivo: ");
         inteiro = s.nextInt();
         erro = inteiro < 0;
         if(erro) System.out.println("Valor invalido!!");
      }while(erro);
      
      return inteiro;
   }//fim lerInt
   
}//fim class