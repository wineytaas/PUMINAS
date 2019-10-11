/* ----------  LISTA 10 ----------
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Data de inicio:      01/05/2017
*  Data ultima edição:  01/05/2017   
*  Versão: 1.0
*  
*/
import java.util.Scanner;

public class Q1RelacaoDeAmizade{
   public static void main(String[] args){
      int[][] amizades = new int[100][100];
      String[] nomes = new String[100];
      int opcao;
      int numeroDePessoas = 0;
      do{
         opcao = menu();
         switch(opcao){
            case 0:
               break;
            case 1:
               numeroDePessoas = cadastrasRelacoes(amizades,nomes);
               //escreveMatrix(amizades,numeroDePessoas);
               break;
            case 2:
               relacoesPessoas(amizades,nomes,numeroDePessoas);
               break;
            case 3:
               contaRelacoesPessoas(amizades,nomes,numeroDePessoas);
               break;
            case 4:
               amizadePessoaComElaMesma(amizades,numeroDePessoas);
               break;
         }
      }while(opcao != 0);
            
   }//fim main
   
   /*
   *  Argumento: Nenhum
   *  Saida: Opção selecionada no menu
   */
   public static int menu(){
      int op;
      Scanner s = new Scanner(System.in);
      boolean erro;
      
      System.out.println(
         "\n\n0 - Sair\n"+
         "1 - Cadastrar as relacoes de amizades\n"+
         "2 - Pesquisar quais as relacoes de amizade de uma pessoa\n"+
         "3 - Pesquisar o numero de relacoes de amizade de uma pessoa\n"+
         "4 - Verificar se ha a seguinte anomalia: uma relacao de amizade de uma pessoa com ela mesma\n"
         );
         op = leInt(0,4);
      
      return op;
   }//fim menu()
   
   /*
   *  Argumento: Relação de amizade , nomes
   *  Saida: numero de pessoas
   */
   public static int cadastrasRelacoes(int[][] amizade , String[] nomes){
      Scanner s = new Scanner(System.in);
      int n;
      char r;
      boolean erro;
      // le o numero de pessoas
      System.out.println("Digite o número de pessoa[0-100]:");
      n=leInt(0,100);
      
      //preenche relação de amizade entre pessoas
      for(int i = 0; i < n ; i++){
         System.out.println("Digite o nome da pessoa n "+i+" : ");
         nomes[i] = s.next();
         for(int j = 0; j < i ; j++){
            do{
               System.out.println("Exite amizade entre "+nomes[i]+" e "+nomes[j]+"[s/n]: ");
               r  = s.next().charAt(0);
               erro = r != 's' && r != 'S' && r != 'n' && r != 'N';
               if(erro)System.out.println("Opção Invalida!");
            }while(erro);
            
            if(r == 's' || r == 'S'){
               amizade[i][j]= 1;
               amizade[j][i]= 1;
            }else{
               amizade[i][j]= 0;
               amizade[j][i]= 0;
            }
         }//fim for(j)
      }//fim for(i)     
      return n;
   }//fim cadastrasRelacoes(int amizade[][] , int nomes[])
   
   
   public static boolean escreveMatrix(int[][] a, int n){
      boolean fez;
      fez = true;
            
      for(int i = 0; i < n ; i++){
         System.out.print(a[i][0]);
         for(int j = 1 ; j < n; j++){
           System.out.print(", "+a[i][j]);
         }
         System.out.println(" ");
      }
      
      System.out.println("\n\n ");
      return fez;
   }//fim escreveMatrix
   
   public static boolean listaPessoas(String[] a, int n){
      boolean fez;
      fez = true;
            
      for(int i = 0; i < n ; i++){
         System.out.println(i+" - " + a[i]);
      }      
      
      return fez;
   }//fim listaPessoas
   
   public static void relacoesPessoas(int[][] amizades, String[] nomes , int numeroDePessoas){
      int pessoa;
      Scanner s = new Scanner(System.in);
      
      if(numeroDePessoas == 0){
         System.out.println("Relações vazias!");
      }else{
         //Seleciona pessoa
         do{
            listaPessoas(nomes,numeroDePessoas);
            pessoa = s.nextInt();
         }while(pessoa < 0 || pessoa > numeroDePessoas);
         relacoesPessoa(amizades,nomes ,pessoa, numeroDePessoas);
      }
      System.out.println("\n\n ");
      
   }//fim relacoesPessoa(amizades,nomes)
   
   
   public static void relacoesPessoa(int[][] amizades, String[] nomes , int pessoa, int numeroDePessoas){
      for(int j = 0 ; j < numeroDePessoas; j++){
         if(amizades[pessoa][j] == 1)
         System.out.print(nomes[j]+",");
      }
   }//fim relacoesPessoa(amizades, nomes , pessoa)
   
   
   public static void contaRelacoesPessoas(int[][] amizades, String[] nomes , int numeroDePessoas){
      int pessoa;
      Scanner s = new Scanner(System.in);
      
      if(numeroDePessoas == 0){
         System.out.println("Relações vazias!");
      }else{
         //Seleciona pessoa
         do{
            listaPessoas(nomes,numeroDePessoas);
            pessoa = s.nextInt();
         }while(pessoa < 0 || pessoa > numeroDePessoas);
         System.out.println(nomes[pessoa]+" tem "+contaRelacoesPessoa(amizades,nomes ,pessoa,numeroDePessoas)+" relacoes de amizade.");
      }
      
      
   }//fim contaRelacoesPessoas(amizades,nomes)
   
   
   public static int contaRelacoesPessoa(int[][] amizades, String[] nomes , int pessoa,int numeroDePessoas ){
      int relacao = 0;
      for(int j = 0 ; j < pessoa; j++){
         if(amizades[pessoa][j] == 1)
         relacao++;
      }
      
      return relacao;
   }//fim contaRelacoesPessoa(amizades, nomes , pessoa, numeroDePessoas)

   public static boolean amizadePessoaComElaMesma(int[][] amizades, int numeroDePessoas){
      boolean exite = false;
      int i = 0;
      while(amizades[i][i] == 0 && i < numeroDePessoas){
         i++;
      }
      
      return exite;
   }//fim amizadePessoaComElaMesma(amizades,numeroDePessoas)

   public static int leInt(){
      int valor;
      Scanner s = new Scanner(System.in);
      valor = s.nextInt();
      
      return valor;
   }//fim leInt
   
   public static int leInt(int min, int max){
      boolean erro;
      int valor;
      do{
         valor = leInt();
         erro = valor < min || valor > max;
         if(erro) System.out.println("Valor invalido! Digite um valor maior ou igual a "+ min +" e menor ou igual a "+max+"!");
      }while(erro);
      
      return valor;
   }//fim leInt(min,max)
   
}//fim ArranjoBidimencional