import java.util.Scanner;

class Triangulo{
   private double ladoA;
   private double ladoB;
   private double ladoC;
   private static int index = 0;
   
   Triangulo(){
      index++;
   }
   
   Triangulo(double ladoA, double ladoB, double ladoC){
      index++;
      this.setLados(ladoA, ladoB, ladoC);
   }
   
   public void setLados(double ladoA, double ladoB, double ladoC){
      this.setLadoA(ladoA);
      this.setLadoB(ladoB);
      this.setLadoC(ladoC);
   
   }
   
   public static int getIndex(){
      return index;
   }
   
   public void setLadoA(double ladoA){
      if(ladoA < 0)
         this.ladoA = 0;
      else 
         this.ladoA = ladoA;
   }//fim setLadoA(double)
   
   public void setLadoB(double ladoB){
      if(ladoB < 0)
         this.ladoB = 0;
      else
         this.ladoB = ladoB;
   }//fim setLadoB(double)
   
   public void setLadoC(double ladoC){
      if(ladoC < 0)
         this.ladoC = 0;
      else
         this.ladoC = ladoC;
   }//fim setLadoC(double)
   
   public double getLadoA(){
      return this.ladoA;
   }//fim double getLadoA()
   
   public double getLadoB(){
      return this.ladoB;
   }//fim double getLadoB()
   
   public double getLadoC(){
      return this.ladoC;
   }//fim double getLadoC()
   
   public void escreveLados(){
      System.out.println("A: "+this.getLadoA());
      System.out.println("B: "+this.getLadoB());
      System.out.println("C: "+this.getLadoC());
   }//fim escreveLados
   
   public double perimetro(){
      double p = this.getLadoA() + this.getLadoB() + this.getLadoC();
      return p ;
   }//fim double perimetro()
   
   /*
   *  1 - Equilátero
   *  2 - Isóscele
   *  3 - Escaleno
   */
   
   public int getTipo(){
      int tipo = 2;
      double a = this.getLadoA();
      double b = this.getLadoB();
      double c = this.getLadoC();
      
      if(a == b){
         if(b == c){
            tipo = 1;
         }
      }else if(b != c){
         tipo = 3;
      }
      
      return tipo;
   }//fim int tipoTriangulo()
   
   public boolean ehIgual(Triangulo t){
      boolean iguais = false;
      double a = this.getLadoA();
      double b = this.getLadoB();
      double c = this.getLadoC();
      if(a == t.getLadoA() &&  b == t.getLadoB() && c == t.getLadoC()){
        iguais = true;
      }else if(a == t.getLadoA() &&  b == t.getLadoC() && c == t.getLadoB()){
         iguais = true;
      }else if(a == t.getLadoB() &&  b == t.getLadoA() && c == t.getLadoC()){
         iguais = true;
      }else if(a == t.getLadoB() &&  b == t.getLadoC() && c == t.getLadoA()){
         iguais = true;
      }else if(a == t.getLadoC() &&  b == t.getLadoA() && c == t.getLadoB()){
         iguais = true;
      }else if(a == t.getLadoC() &&  b == t.getLadoB() && c == t.getLadoA()){
         iguais = true;
      }
      
      return iguais;      
   }
   
   public boolean ehTriangulo(){
      boolean valido = false;
      double a = this.getLadoA();
      double b = this.getLadoB();
      double c = this.getLadoC();
      if(Math.abs(b-c) < a && a < b+c)
         if(Math.abs(a-c) < b && b < a+c)
            if(Math.abs(a-b) < b && b < a+b)
               valido = true;
      return valido;
   }
}

public class lista12{

   public static void main(String[] args){
      Triangulo[] t = new Triangulo[100];
      int op;
      do{
         op = selecionaMenu();
         switch(op){
            case 0:
               System.out.println("\n\nObrigado, por utilizar esse aplicativo!\n\n");
               break;
            case 1:
               System.out.println("\n\n--------------- Criar Triangulo ---------------\n\n");
               criaTriangulo(t);
               break;
            case 2:
               System.out.println("\n\n--------------- Lista Todos os Triangulo ---------------\n\n");
               listaTriangulos(t);
               break;
            case 3:
               System.out.println("\n\n--------------- Contagem de Triangulos Iguais ---------------\n\n");
               System.out.println("Existem "+ qtTriangulosIguais(t) +" triangulos iguais no arrarnjo.");
               break;
            case 4:
               System.out.println("\n\n--------------- Lista Triangulo Pelo Tipo ---------------\n\n");
               listaTriangulosTipo(t);
               break;
            case 5:
               System.out.println("\n\n--------------- Lista Objetos Que Nao Sao Triangulo ---------------\n\n");
               listaNaoTriangulos(t);
               break;
         }
      }while(op != 0);
      
   }
   
   public static int selecionaMenu(){
      menu();
      
      return leIntFaixa(0,5);
   }
   
   public static void menu(){
      System.out.println("\n\n0 - Sair do programa\n"+
                           "1 - Criar um triângulo\n"+
                           "2 - Listar triangulos \n"+
                           "3 - Triângulos iguais \n"+
                           "4 - Listar os triângulos de um determinado tipo\n"+
                           "5 - Verificar inconsistências \n");
   }
   
   public static void criaTriangulo(Triangulo[] t){
      int index = Triangulo.getIndex();
      if(index >= 100){
         System.out.println("Lista de Triangulos esta tatalmente preenchida!");
      }else{
         t[index] = new Triangulo(leLado('A'), leLado('B'), leLado('C'));  
      }
      
   
   }
   
   public static void listaTriangulos(Triangulo[] t){
      for(int i = 0 ; i < Triangulo.getIndex(); i++){
         System.out.println("Triangulo "+(i+1)+" : ");
         escreveLados(t[i]);
         escrevePerimetro(t[i]);
      }
   }
   
   public static void listaNaoTriangulos(Triangulo[] t){
      for(int i = 0 ; i < Triangulo.getIndex() ; i++){
         if(!t[i].ehTriangulo()){
            escreveLados(t[i]);
         }
      }
   }//listaNaoTriangulos(t)
   
   public static void listaTriangulosTipo(Triangulo[] t){
      escreveTipoTriangulo(0);
      int tipo = leIntFaixa(1,3);
      
      for(int i = 0 ; i < Triangulo.getIndex() ; i++){
         if(t[i].getTipo() == tipo){
            escreveLados(t[i]);
         }
      }
   }//listaTriangulosTipo(t)
   
   public static void escreveTipoTriangulo(int op){
      switch(op){
         case 0:
            System.out.println("1 - Equilatero");
            System.out.println("2 - Isoscele");
            System.out.println("3 - Escaleno");
            break;
         case 1:
            System.out.println("Equilatero");
            break;
         case 2:
            System.out.println("Isoscele");
            break;
         case 3:
            System.out.println("Escaleno");
            break;
      }
   }
   
   public static void escrevePerimetro(Triangulo t){
      System.out.println("Perimetro: "+t.perimetro());
   }
   
   public static void escreveLados(Triangulo t){
      System.out.print(" A: "+t.getLadoA());
      System.out.print(" B: "+t.getLadoB());
      System.out.println(" C: "+t.getLadoC());
   }
   
   public static int qtTriangulosIguais(Triangulo[] t){
      int count = 0;
      int index = Triangulo.getIndex();
      
      int i = 0;
      int j = index - 1;
      while(i < index){
         j = index - 1;
         while(j > i){
            if(t[i].ehIgual(t[j])){
               count++;
            }
            j--;
         }
         i++;
      }
      return count;
   }//fim qtTriangulosIguais(t)
   
     
   public static void leLados(Triangulo t){
      double a  = leLado('A');
      double b  = leLado('B');
      double c  = leLado('C');      
      t.setLados(a,b,c);
   }
   
   public static double leLado(char msg){
      double lado;
      boolean erro;
      do{
         System.out.println("Digite o valor do lado "+msg+" :");
         lado = leDouble();
         erro = lado <= 0;
         if(erro){
            System.out.println("Digite um valor para o lado "+msg+" maior que zero!");
         }
      }while(erro);

      return lado;
   }
   
   public static double leDouble(){
      Scanner s  = new Scanner(System.in);
      double lado;
      
      lado = s.nextDouble();
      
      return lado;
   }
   
   public static int leInt(){
      Scanner s  = new Scanner(System.in);
      int lado;
      
      lado = s.nextInt();
      
      return lado;
   }
   
   public static int leIntFaixa(int min, int max){
      boolean erro;
      int valor;
      do{
         valor = leInt();
         erro = valor < min || valor > max;
         if(erro)System.out.println("Valor Invalido! Digite um valor entre "+min+" e "+max+"  .");
      }while(erro);
      
      return valor;
   }
   
   public static void saoIguais(Triangulo t0, Triangulo t1){
      if(t0.ehIgual(t1)){
            System.out.println("Os triangulos sao iguais!");
      }else{
            System.out.println("Os triangulos sao diferentes!");
      }
      
   }
   
   public static void comparaTriangulos(Triangulo[] t){
      System.out.println("Escolha quais os triangulos deseja comparar[1-5]: ");
      System.out.println("Triangulo A: ");
      int a = leIntFaixa(1,5);
      System.out.println("Triangulo B: ");
      int b = leIntFaixa(1,5);
      saoIguais(t[a-1],t[b-1]);                    
   }
   
   
}