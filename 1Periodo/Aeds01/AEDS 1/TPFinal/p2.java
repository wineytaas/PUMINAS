import java.util.Scanner;
import java.util.InputMismatchException;


public class p2{
   public static void main(String[] args){
      int op;
      do{
         op = menu();
         switch(op){
            case 1:
               System.out.println("N: ");
               int n = leInt();
               int fibN = fibonacci(n);
               System.out.println("O "+n+" fibonacci eh: "+ fibN+"\n\n");
               break;
            case 2:
               arranjo();
               break;
            case 3:
               Scanner s = new Scanner(System.in);
               System.out.println("Digite uma frase ou palavra: ");
               String frase = s.nextLine();
               if(ehPalindromo(frase)){
                  System.out.println(frase+" eh um palindromo!");
               }else{
                  System.out.println(frase+" NAO eh um palindromo!");
               }
               break;
            default:
               break;
         }
      }while(op != 0);
   }
   
   public static String soLetras(String frase){
      String soLetras = "";
      frase = frase.toUpperCase();
      for(int i = 0 ; i < frase.length() ; i++){
         if('A' < (int)frase.charAt(i) && frase.charAt(i) < 'Z'){
            soLetras = soLetras + frase.charAt(i);
         }
      }
      return soLetras;
   
   }
   public static boolean ehPalindromo(String palavra){
      String letras = soLetras(palavra);
      return ehPalindromo(letras,0,letras.length()-1);
   }
   
   public static boolean ehPalindromo(String palavra, int in, int end){
      boolean palindromo = false;
      if(in >= end){
         palindromo = true;
      }else if(palavra.charAt(in) == palavra.charAt(end)){
         palindromo = ehPalindromo(palavra,in+1,end-1);
      }
      
      return palindromo;
   }
   
   /*
   public static boolean ehPalindromo(String palavra){
      
      
      int i = 0;
      int j = palavra.length() - 1;
      boolean palindromo = false;
      
      
      
      while(i < j && palavra.charAt(i) == palavra.charAt(j)){
         i++;
         j--;
      }
      if(i >= j )
         palindromo = true;
      
      return palindromo;
   }*/
   
   
   public static int menuArranjo(){
      int op;
      boolean erro;
      do{
         System.out.print("0 - Sair\n"+
                              "1 - Criar Arranjo\n"+
                              "2 - Inverter Arranjo\n"+
                              "3 - Printar Arranjo\n"+
                              "[0-3]: ");
         op = leInt();
         erro = op < 0 || op > 3;                       
         if(erro)
            System.out.println("Valor Invalido!! Digite um valor valido!! [0-3]\n\n");                
      }while(erro);
         
      return op;
   }
   public static void arranjo(double[] arranjo){
      arranjo(arranjo,0,arranjo.length-1);
   }
   public static void arranjo(double[] arranjo, int in, int end){
      if(in < end){
         double aux = arranjo[in];
         arranjo[in] = arranjo[end];
         arranjo[end] = aux;
         arranjo(arranjo, in+1,end-1);
      }
   }
   
   public static void arranjo(){
      int op;
      double[] arranjo = null;
      do{
         op = menuArranjo();
         switch(op){
            case 1:
               System.out.print("Tamanho do arranjo: ");
               int tamanho = leInt();
               arranjo = new double[tamanho];
               for(int i = 0 ; i < arranjo.length ; i++){
                  arranjo[i] = fibonacci(i);
               }
               break;
            case 2:
               if(arranjo != null){
                  arranjo(arranjo);
                  /*int i = 0;
                  int j = arranjo.length-1;
                  double aux;
                  while(i < j){
                     aux = arranjo[i];
                     arranjo[i] = arranjo[j];
                     arranjo[j] = aux;
                     i++;
                     j--;
                  }*/
               }else{
                  System.out.println("Crie um arranjo primeiro!!");
               }
               
               break;
            case 3:
               if(arranjo != null){
                  System.out.print(arranjo[0]);
                  for(int i = 1 ; i < arranjo.length ; i++){
                     System.out.print(" ," + arranjo[i]);
                  }
                  System.out.println("\n");
               }else{
                  System.out.println("Crie um arranjo primeiro!!");
               }
            default:
               break;
         }
      }while(op != 0);
      
   }
   
   public static int fibonacci(int n){
      int fib = 1;
      if(n > 1){
         fib = fibonacci(n-1) + fibonacci(n-2);
      }
      return fib;
   }
   
   public static int menu(){
      int op;
      boolean erro;
      do{
         System.out.print("0 - Sair\n"+
                              "1 - Fibonacci(n)\n"+
                              "2 - Arranjo\n"+
                              "3 - Palindromo\n"+
                              "[0-3]: ");
         op = leInt();
         erro = op < 0 || op > 3;                       
         if(erro)
            System.out.println("Valor Invalido!! Digite um valor valido!! [0-3]\n\n");                
      }while(erro);
         
      return op;
   }
   
   public static int leInt(){
      int inteiro = 0;
      boolean erro = true;
      do{
         try{
            Scanner scanner = new Scanner(System.in);
            inteiro = scanner.nextInt();
            erro = false;
         }
         catch(InputMismatchException inputMismatchException){
            System.out.println("Digite um valor inteiro!!");
         }
      }while(erro);
      
      return inteiro;
   }
 
 }