import java.util.Scanner;

class Triangulo{
   private double ladoA;
   private double ladoB;
   private double ladoC;
   
   public void setLados(double ladoA, double ladoB, double ladoC){
      this.setLadoA(ladoA);
      this.setLadoB(ladoB);
      this.setLadoC(ladoC);
   
   }
   
   public void setLadoA(double ladoA){
      this.ladoA = ladoA;
   }//fim setLadoA(double)
   
   public void setLadoB(double ladoB){
      this.ladoB = ladoB;
   }//fim setLadoB(double)
   
   public void setLadoC(double ladoC){
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
   
   public int tipoTriangulo(){
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
}

public class Q2Principal{

   public static void main(String[] args){
      Triangulo[] t = new Triangulo[5];
     
      t[0] = new Triangulo();
      //leLados(t[0]);
      t[0].setLadoA(3);
      t[0].setLadoB(3);
      t[0].setLadoC(3);
      escrevePerimetro(t[0]);
      escreveTipoTriangulo(t[0]);
      
      t[1] = new Triangulo();
      //leLados(t[1]);
      t[1].setLados(1,3,3);
      escrevePerimetro(t[1]);
      escreveTipoTriangulo(t[1]);      
      t[2] = new Triangulo();
      //leLados(t[2]);
      t[2].setLados(3,4,5);
      escrevePerimetro(t[2]);
      escreveTipoTriangulo(t[2]);
      
      t[3] = new Triangulo();
      //leLados(t[3]);
      t[3].setLados(3,4,5);
      escrevePerimetro(t[3]);
      escreveTipoTriangulo(t[3]);
      
      t[4] = new Triangulo();
      //leLados(t[4]);
      t[4].setLados(3,4,5);
      escrevePerimetro(t[4]);
      escreveTipoTriangulo(t[4]);
      
      comparaTriangulos(t);
   }
   
   public static void escreveTipoTriangulo(Triangulo t){
      switch(t.tipoTriangulo()){
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
      System.out.println("O perimetro do triangulo eh: "+t.perimetro());
   }
   
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
      //System.out.println(a+"    "+(a-1));
      //System.out.println(b+"    "+(b-1));
      saoIguais(t[a-1],t[b-1]);                    
   }
   
   
}