/*
*  Autor: Wisney Tadeu de Almeida Assis dos Santos
*  Nome do Programa: TrabalhoPratico1
*  Primeira Edição: 08/04/2017
*  Ultima Edição: 10/04/2017
*  Versão: 1.4
*/

import java.util.Scanner;

public class TrabalhoPratico1{
   public static void main(String[] args){
      int op = menu();
      double[] a = new double[0];
      double[] b = new double[0];
      double[] c = new double[0];
      
      while(op != 0){
         switch(op){
            case 1:
               escreveTamanhoArranjos(a,b,c);
               break;
            
            case 2:
               a = inserirReisArrajo(a);
               System.out.println("\n\n");
               break;
            
            case 3:
               b = inserirReisArrajo(b);
               System.out.println("\n\n");
               break;
               
            case 4:
               c = uniaoArranjos(a,b);
               break;
               
            case 5:
               double maiorValor = maior(a);
               System.out.println("\n\nO maior valor do arranjo A : "+maiorValor+"\n\n");
               break;
               
            case 6:
               System.out.println("\n\nMedia B: " + mediaArranjo(b) + "\n\n");
               break;
               
            case 7:
               System.out.println("\n\nExistem " + maioresMediaArranjo(c) + " elementos maiores que a media( "+mediaArranjo(c)+" ) de C \n\n");
               break;
               
            case 8:
               if(ehIgual(a,b)){
                  System.out.println("\n\nArrajo A eh igual ao B\n");
               }else{
                  System.out.println("\n\nArrajo A eh diferente de B\n");
               }
               break;
               
            case 9:
               if(c.length == 0){
                  System.out.println("\n\nNão existem elementos em C\n");
               }else if(elementosPositivos(c)){
                  System.out.println("\n\nTodos os elementos de C sao positivos\n");
               }else{
                  System.out.println("\n\nNem todos os elementos sao positivos\n");
               }
               break;
               
            case 10:
               crecente(c);
               escreveArranjo(c);
               break;
               
            case 11:
               System.out.println("\n\n Soma do elementos de C: "+somaRecursiva(a,0)+" \n");
               break;
               
            case 12:
               if(ehIgualRecursiva(a,b,0)){
                  System.out.println("\n\nArrajo A eh igual ao B\n");
               }else{
                  System.out.println("\n\nArrajo A eh diferente de B\n");
               }
               
               break;
               
            case 13:
               System.out.println("\n\nExistem " + nulosRecursivo(a,0) + " elementos nulos em A \n");
               break;
               
            default:
               System.out.println("Opcao Invalida!");
               break;
         }
         op = menu();
      }
      
   }//fim main
   
   public static int nulosRecursivo(double[] arranjo, int index){
      int nulos;
      
      if(index >= arranjo.length){
         nulos = 0;
      }else if(arranjo[index] == 0){
         nulos = 1 + nulosRecursivo(arranjo , index + 1);
      }else{
         nulos = 0 + nulosRecursivo(arranjo , index + 1);
      }
      
      return nulos;
   }//fim nulosRecursivo
   
   public static boolean ehIgualRecursiva(double[] a , double[] b, int index){
      boolean igual;
      
      if(a.length != b.length){
         igual = false;
      }else if(index >= a.length){
         igual = true;
      }else{
         igual = a[index]==b[index] && ehIgualRecursiva(a , b , index + 1);
      }
      
      return igual;
   }//fim ehIgualRecursiva
   
   public static double somaRecursiva(double[] arranjo, int index){
      double soma;
      if(index >= arranjo.length){
         soma = 0;
      }else{
         soma = arranjo[index] + somaRecursiva(arranjo, index + 1);
      }
      
      return soma;
   }//fim somaRecursiva
   
   public static void crecente(double[] arranjo){
      if(arranjo.length > 1){
         int i , j;
         double auxiliar;
         for(i = 0 ; i < arranjo.length ; i++){
            for(j = i+1 ; j < arranjo.length ; j++){
               if(arranjo[i] > arranjo[j]){
                  auxiliar = arranjo[i];
                  arranjo[i] = arranjo[j];
                  arranjo[j] = auxiliar;
               }
            }
         }
      }
   }
     
   public static void decrecente(double[] arranjo){
      if(arranjo.length > 1){
         int i , j;
         double auxiliar;
         for(i = 0 ; i < arranjo.length ; i++){
            for(j = i+1 ; j < arranjo.length ; j++){
               if(arranjo[i] < arranjo[j]){
                  auxiliar = arranjo[i];
                  arranjo[i] = arranjo[j];
                  arranjo[j] = auxiliar;
               }
            }
         }
      }
   }
   
   public static void escreveArranjo(double[] arranjo){
      for(int i = 0 ; i < arranjo.length ; i++){
         System.out.print(arranjo[i]+" , ");
      }
      System.out.println("\n\n");
   }
   
   public static boolean elementosPositivos(double[] arranjo){
      boolean positivo = true;
      if(arranjo.length == 0){
         positivo = false;
      }else{
         for(int i = 0 ; i < arranjo.length ; i++){
            if(arranjo[i] <= 0)
               positivo = false;
         }
      }
      return positivo;
   }
   
   public static boolean ehIgual(double[] arranjo1, double[] arranjo2){
      boolean igual = true;
      
      if(arranjo1.length != arranjo2.length){
         igual = false;
      }else{
         for(int i = 0 ; i < arranjo1.length ; i++){
            if(arranjo1[i] != arranjo2[i])
               igual = false;
         }
      }
      
      return igual;
   }//fim ehIgual
   
   public static int maioresMediaArranjo(double[] arranjo){
      int maiores = 0;
      double media = mediaArranjo(arranjo);
      
      for(int i = 0; i < arranjo.length ; i++){
         if(ehMaior(arranjo[i],media))
            maiores++;
      }
      
      return maiores;
   }//fim maioresMediaArrajo
   
   public static double mediaArranjo(double[] arranjo){
      double soma = somaElementosArranjo(arranjo);
      double media = 0;
      if(arranjo.length > 0) media = soma / arranjo.length;
      
      return media;
   }//fim mediaArranjo
   
   public static double somaElementosArranjo(double[] arranjo){
      double soma = 0;
      
      for(int i = 0; i < arranjo.length ; i++){
         soma = soma + arranjo[i];
      }
      
      return soma;
   }//fim somaElementosArranjo
   
   public static double maior(double[] arranjo){
      double maior = 0;
      
      for(int i = 0 ; i < arranjo.length ; i++){
         if(ehMaior(arranjo[i],maior)){
            maior = arranjo[i];
         }
      }
      return maior;
   }//fim maior
   
   public static boolean ehMaior(double a , double b){
      boolean maior = a > b;
      return maior;
   }//fim ehMaior
   
   public static double[] uniaoArranjos(double[] a, double[] b){
      double[] uniao = new double[a.length + b.length];
      
      for(int i = 0 ; i < uniao.length ; i++){
         if(i < a.length){
            uniao[i] = a[i];
         }else{
            uniao[i] = b[i-a.length];
         }
      }
      
      return uniao;
   }//fim uniaoArranjos
   
   public static double[] inserirReisArrajo(double[] arranjo){
      int n = leInt("Número de elementos no arranjo: ");
      arranjo = new double[n];
      for(int i = 0 ; i < n ; i++){
         arranjo[i] = leDouble("Digite um real: ");
      }
      
      return arranjo;
      
   }//fim inserirReisArrajo
   
   
   
   public static void escreveTamanhoArranjos(double[] a, double[] b,double[] c){
      int tamanhoA = tamanhoArranjo(a);
      int tamanhoB = tamanhoArranjo(b);
      int tamanhoC = tamanhoArranjo(c);
      
      System.out.println("\n-----------------TAMANHOS---------------\n" + "\nA:" + tamanhoA + "\nB:" + tamanhoB + "\nC:" + tamanhoC+"\n\n");
   }//vim escreveTamanhoArranjos
   
   public static int tamanhoArranjo(double[] x){
      int tamanho = x.length;
      return tamanho;
   }//fim tamanhoArranjo
   
   public static int leInt(int min, int max){
      Scanner s = new Scanner(System.in);
      int valor;
      boolean erro;
      
      do{
         System.out.print("\nDigite um inteiro: ");
         valor = s.nextInt();
         erro = valor < min || valor > max;
         if(erro)
            System.out.println("Valor invvalido! Digite um valor igual ou entre o intervalo "+min+" - "+max);
         
      }while(erro);
      
      return valor;
   }//fim leInt
   
   public static int leInt(String msg){
      Scanner s = new Scanner(System.in);
      int valor;
      boolean erro;
      
      do{
         System.out.print(msg);
         valor = s.nextInt();
         erro = valor < 0;
         if(erro)
            System.out.println("Valor invvalido! Digite um valor maior ou igual a zero!");
         
      }while(erro);
      
      return valor;
   }//fim leInt
   
   public static double leDouble(String msg){
      Scanner s = new Scanner(System.in);
      double valor;
      boolean erro;
      
      do{
         System.out.print(msg);
         valor = s.nextDouble();
         erro = valor < 0;
         if(erro)
            System.out.println("Valor invvalido! Digite um valor maior ou igual a zero!");
         
      }while(erro);
      
      return valor;
   }//fim leDouble
   
   public static int menu(){
      System.out.println("0 Sair\n"+
                        "1 Informar tamanho dos arranjos\n"+
	                     "2 Inserir numeros reais no Arranjo A\n"+
	                     "3 Inserir numeros reais no Arranjo B\n"+
	                     "4 Calcular C: Uniao dos arranjos A e B\n"+
	                     "5 Identificar o maior valor em A\n"+
	                     "6 Calcular a media dos valores de B\n"+
	                     "7 Calcular o numero de elementos de C maiores que a media desse arranjo\n"+
	                     "8 Verificar se A e B sao iguais\n"+
	                     "9 Verificar se os valores de C sao, todos, positivos\n"+
	                     "10 Ordenar os valores de C em ordem crescente, e escrever C\n"+
	                     "11 Calcular a soma dos valores de C de forma recursiva\n"+
	                     "12 Verificar se A e B sao iguais de forma recursiva\n"+
	                     "13 Contar o numero de zeros no arranjo A de forma recursiva\n"
                        );
       return leInt(0,13);
   }//fim menu
}//fim Trabalho Prático