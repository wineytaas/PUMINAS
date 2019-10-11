import java.util.Scanner;

/*------------------- Lista13 ------------------- Begin*/
public class Lista13{
   public static void main(String[] args){
      int op;
      do{
         escreveMenuPrincipal();
         op = leIntFaixa(0 , 3);
         switch(op){
            case 0:
               System.out.println("Tchau!!");
               break;
            case 1:
               circulo();
               break;
            case 2:
               quadrado();
               break;      
            case 3:
               triangulo();
               break;   
         }
      }while(op != 0);
   }
   
   public static void triangulo(){
      Triangulo t = new Triangulo();
      int op;
      do{
         escreveMenuTriangulo();
         op = leIntFaixa(0,3);
         switch(op){
            case 0:
               break;
            case 1:
               System.out.print("Digite o valor do lado A: ");
               t.setA(leDouble());
               System.out.print("Digite o valor do lado B: ");
               t.setB(leDouble());
               System.out.print("Digite o valor do lado C: ");
               t.setC(leDouble());
               break;
            case 2:
               escrevePerimetro(t);
               break;
            case 3:
               escreveArea(t);
               break;         
         }
      }while(op != 0);
   }
   
   public static void quadrado(){
      Quadrado q = new Quadrado();
      int op;
      do{
         escreveMenuQuadrado();
         op = leIntFaixa(0,3);
         switch(op){
            case 0:
               break;
            case 1:
               System.out.print("Digite o valor do lado: ");
               q.setLado(leDouble());
               break;
            case 2:
               escrevePerimetro(q);
               break;
            case 3:
               escreveArea(q);
               break;         
         }
      }while(op != 0);
   }
   
   public static void circulo(){
      Circulo c = new Circulo();
      int op;
      do{
         escreveMenuCirculo();
         op = leIntFaixa(0,3);
         switch(op){
            case 0:
               break;
            case 1:
               System.out.print("Digite o valor do raio: ");
               c.setRaio(leDouble());
               break;
            case 2:
               escrevePerimetro(c);
               break;
            case 3:
               escreveArea(c);
               break;         
         }
      }while(op != 0);
   }
   
   public static void escreveArea(FigGeometrica f){
      System.out.println("Area: "+ f.area());
   }
   
   public static void escrevePerimetro(FigGeometrica f){
      System.out.println("Perimetro: "+ f.perimetro());
   }
   
   public static void escreveMenuTriangulo(){
      System.out.println(  "0 - Voltar menu principal\n"+
                           "1 - Set Lados\n"+
                           "2 - Perimetro\n"+
                           "3 - Area\n");
   }
   
   public static void escreveMenuQuadrado(){
      System.out.println(  "0 - Voltar menu principal\n"+
                           "1 - Set Lado\n"+
                           "2 - Perimetro\n"+
                           "3 - Area\n");
   }
   
   public static void escreveMenuCirculo(){
      System.out.println(  "0 - Voltar menu principal\n"+
                           "1 - Set Raio\n"+
                           "2 - Perimetro\n"+
                           "3 - Area\n");
   }
   
   public static void escreveMenuPrincipal(){
      System.out.println(  "0 - Sair do programa\n"+
                           "1 - Circulos\n"+
                           "2 - Quadrados\n"+
                           "3 - Triangulos\n");
   }
   
   public static int leInt(){
      Scanner s = new Scanner(System.in);
      return s.nextInt();
   }
   
   public static int leIntFaixa(int min, int max){
      Scanner s = new Scanner(System.in);
      int valor;
      boolean erro;
      do{
         valor = leInt();
         erro = valor < min || valor > max;
         if(erro)
            System.out.println("Digite um valor entre " + min + " - " + max + " ! ");
      }while(erro);
      return valor;
   }
   
   public static double leDouble(){
      Scanner s = new Scanner(System.in);
      return s.nextDouble();
   }
}
/*------------------- Lista13 ------------------- End*/


/*------------------- FigGeometrica ------------------- Begin*/

abstract class FigGeometrica{
   public abstract double perimetro();
   public abstract double area();
}

/*------------------- FigGeometrica ------------------- End*/

/*------------------- Circulo ------------------- Begin*/

class Circulo extends FigGeometrica{
   private double raio;
   
   Circulo(){
      this.setRaio(0);
   }
   
   Circulo(double raio){
      this.setRaio(raio);
   }
   
   public void setRaio(double raio){
      this.raio = raio;
   }
   
   public double getRaio(){
      return this.raio;
   }
   
   public double perimetro(){
      return 2 * Math.PI * this.getRaio();
   }
   
   public double area(){
      return 2 * Math.PI * Math.pow(this.getRaio() , 2);
   }
}

/*------------------- Circulo ------------------- End*/

/*------------------- Quadrado ------------------- Begin*/

class Quadrado extends FigGeometrica{
   private double lado;
   
   Quadrado(){
      this.setLado(0);
   }
   
   Quadrado(double lado){
      this.setLado(lado);
   }
   
   public void setLado(double lado){
      this.lado = lado;
   }
   
   public double getLado(){
      return this.lado;
   }
   
   public double perimetro(){
      return 4 * this.getLado();
   }
   
   public double area(){
      return Math.pow(this.getLado() , 2);
   }
}

/*------------------- Quadrado ------------------- End*/

/*------------------- Triangulo ------------------- Begin*/


class Triangulo extends FigGeometrica{
   private double a;
   private double b;
   private double c;
   
   Triangulo(){
      this.setA(0);
      this.setB(0);
      this.setC(0);
   }
   
   Triangulo(double lado){
      this.setA(lado);
      this.setB(lado);
      this.setC(lado);
   }
   
   public void setTriangulo(double a, double b ,double c){
      this.setA(a);
      this.setB(b);
      this.setC(c);
   }
   
   public void setA(double a){
      this.a = a;
   }
   
   public void setB(double b){
      this.b = b;
   }
   
   public void setC(double c){
      this.c = c;
   }
   
   public double getA(){
      return this.a;
   }
   
   public double getB(){
      return this.b;
   }
   
   public double getC(){
      return this.c;
   }
   
   public double perimetro(){
      return this.getA() + this.getB() + this.getC();
   }
   
   public double area(){
      double p = this.perimetro() / 2 ;
      double a = p * (p - this.getA()) * (p - this.getB()) * (p - this.getC());
      return Math.pow(a , 1/2);
   }
}
/*------------------- Triangulo ------------------- End*/

