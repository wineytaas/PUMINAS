import java.util.Scanner;

/*------------------- Lista14 ------------------- Begin*/
public class Lista14{
   public static void main(String[] args){
      int op , i;
      Triangulo[] t = new Triangulo[100];
      Quadrado[] q = new Quadrado[100];
      Circulo[] c = new Circulo[100];
      
      do{
         escreveMenuPrincipal();
         op = leIntFaixa(0 , 5);
         switch(op){
            case 0:
               System.out.println("Tchau!!");
               break;
            case 1:
               i = Circulo.getQuant();
               if(i+1 < 100){
                  c[i] = new Circulo();
                  circulo(c[i]);
               }
               //System.out.println("C: "+Circulo.getQuant());
               break;
            case 2:
               i = Quadrado.getQuant();
               if(i+1 < 100){
                  q[i] = new Quadrado();
                  quadrado(q[i]);
               }
               //System.out.println("Q: "+Quadrado.getQuant());
               break;      
            case 3:
               i = Triangulo.getQuant();
               if(i+1 < 100){
                  t[i] = new Triangulo();
                  triangulo(t[i]);
               }
               //System.out.println("T: "+Triangulo.getQuant());
               break;
            case 4:
               System.out.println("---------------------------Perimetros de Circulos---------------------------");
               escrevePerimetros(c);
               System.out.println("---------------------------Perimetros de Quadardos---------------------------");
               escrevePerimetros(q);
               System.out.println("---------------------------Perimetros de Triangulos---------------------------");
               escrevePerimetros(t);
               break;
            case 5:
               System.out.println("---------------------------Area de Circulos---------------------------");
               escreveAreas(c);
               System.out.println("---------------------------Area de Quadardos---------------------------");
               escreveAreas(q);
               System.out.println("---------------------------Area de Triangulos---------------------------");
               escreveAreas(t);
               break;      
         }
         System.out.println("\n\n\n");

      }while(op != 0);
   }
   
   public static void triangulo(Triangulo t){
      
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
   
   public static void quadrado(Quadrado q){
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
   
   public static void circulo(Circulo c){
      
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
   
   public static void escreveAreas(Circulo[] c){
      for(int i = 0; i < Circulo.getQuant() ; i++){
         System.out.print("["+i+"] ");
         c[i].escreveArea();  
      }
   }
   
   public static void escreveAreas(Quadrado[] q){
      for(int i = 0; i < Quadrado.getQuant() ; i++){
         System.out.print("["+i+"] ");
         q[i].escreveArea();  
      }
   }
   
   public static void escreveAreas(Triangulo[] t){
      for(int i = 0; i < Triangulo.getQuant() ; i++){
         System.out.print("["+i+"] ");
         t[i].escreveArea();  
      }
   }
   
   public static void escrevePerimetro(FigGeometrica f){
      System.out.println("Perimetro: "+ f.perimetro());
   }
   
   public static void escrevePerimetros(Circulo[] c){
      for(int i = 0; i < Circulo.getQuant() ; i++){
         System.out.print("["+i+"] ");
         c[i].escrevePerimetro();  
      }
   }
   
   public static void escrevePerimetros(Quadrado[] q){
      for(int i = 0; i < Quadrado.getQuant() ; i++){
         System.out.print("["+i+"] ");
         q[i].escrevePerimetro();  
      }
   }
   
   public static void escrevePerimetros(Triangulo[] t){
      for(int i = 0; i < Triangulo.getQuant() ; i++){
         System.out.print("["+i+"] ");
         t[i].escrevePerimetro();  
      }
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
                           "3 - Triangulos\n"+
                           "4 - Escrever perimetro de todas as figuras geometricas\n"+
                           "5 - Escrever area de todas as figuras geometricas\n");
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
   
   public void escrevePerimetro(){
      System.out.println("Perimetro: " + this.perimetro());
   }
   
   public void escreveArea(){
      System.out.println("Area: " + this.area());
   }
}

/*------------------- FigGeometrica ------------------- End*/

/*------------------- Circulo ------------------- Begin*/

class Circulo extends FigGeometrica{
   private double raio;
   private static int quant = 0;
   
   Circulo(){
      this.setRaio(0);
      Circulo.quant++;
   }
   
   Circulo(double raio){
      this.setRaio(raio);
      Circulo.quant++;
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
      return Math.PI * Math.pow(this.getRaio() , 2);
   }
   
   public static int getQuant(){
      return Circulo.quant;
   }

}

/*------------------- Circulo ------------------- End*/

/*------------------- Quadrado ------------------- Begin*/

class Quadrado extends FigGeometrica{
   private double lado;
   private static int quant = 0;
   
   Quadrado(){
      this.setLado(0);
      Quadrado.quant++;
   }
   
   Quadrado(double lado){
      this.setLado(lado);
      Quadrado.quant++;
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
   
   public static int getQuant(){
      return Quadrado.quant;
   }
}

/*------------------- Quadrado ------------------- End*/

/*------------------- Triangulo ------------------- Begin*/


class Triangulo extends FigGeometrica{
   private double a;
   private double b;
   private double c;
   private static int quant = 0;
   
   Triangulo(){
      this.setA(0);
      this.setB(0);
      this.setC(0);
      Triangulo.quant++;
   }
   
   Triangulo(double lado){
      this.setA(lado);
      this.setB(lado);
      this.setC(lado);
      Triangulo.quant++;
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
   
   public static int getQuant(){
      return Triangulo.quant;
   }
}
/*------------------- Triangulo ------------------- End*/

