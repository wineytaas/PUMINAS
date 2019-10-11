import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

public class P3q1{
   public static void main(String[] args){
      Data data = new Data(29,01,2000);
      data.escreveData();
      System.out.println("Ano "+data.getAno()+" bissexto:  "+data.ehBissexto());
      
      Data data1 = new Data(28,01,1900);
      data.escreveDataMes();
      
      System.out.println(data.ehMaisRecente(data1));
      
      Data data2 = new Data();
           
      data2.leDataTeclado();
      data2.escreveDataMesCompleto();
      
      
      
      //System.out.println(data.recente(data1).getDia()+" / "+data.recente(data1).getMes()+" / "+data.recente(data1).getAno());      
      /*
      while(data.getMes() < 13){
         System.out.println("Mes "+data.getMes()+" : " + data.getMesString());
         System.out.println("Dia valido: "+data.ehDiaValido());
         System.out.println("Mes valido: "+data.ehMesValido());
         System.out.println("Ano valido: "+data.ehAnoValido());
         System.out.println("Data valido: "+data.ehValido());
         data.setMes(data.getMes()+1);
      }
      */
   }
   public static int leInt(){
      Scanner scanner = new Scanner(System.in);
      int inteiro = 0;
      boolean erro = true;
      do{
         try{
            inteiro = scanner.nextInt();
            erro = false;
         }
         catch(InputMismatchException inputMismatchException){
            System.err.print("Valor Invalido! \nDigite um inteiro: ");
            scanner.nextLine();
         }
      }while(erro);
      return inteiro;
   }
   
   public static double leReal(){
      Scanner scanner = new Scanner(System.in);
      double real = 0;
      boolean erro = true;
      do{
         try{
            real = scanner.nextDouble();
            erro = false;
         }
         catch(InputMismatchException inputMismatchException){
            System.err.print("Valor Invalido! \nDigite um real: ");
            scanner.nextLine();
         }
      }while(erro);
      return real;
   }
   
   public static String leString(){
      Scanner scanner = new Scanner(System.in);
      String palavra = "";
      boolean erro = true;
      do{
         try{
            palavra = scanner.nextLine();
            erro = false;
         }
         catch(InputMismatchException inputMismatchException){
            System.err.print("Valor Invalido! \nDigite uma String: ");
            scanner.nextLine();
         }
      }while(erro);
      return palavra;
   }
   
   public static char leCaracter(){
      Scanner scanner = new Scanner(System.in);
      char caracter = ' ';
      boolean erro = true;
      do{
         try{
            caracter = scanner.nextLine().charAt(0);
            erro = false;
         }
         catch(InputMismatchException inputMismatchException){
            System.err.print("Valor Invalido! \nDigite uma caracter: ");
            scanner.nextLine();
         }
      }while(erro);
      return caracter;
   }
}

class Data{
   //Atributos
   private int dia;
   private int mes;
   private int ano;
   
   //Contrutores
   public Data(){
      this.setDia(1);
      this.setMes(1);
      this.setAno(1);
   }
   
   public Data(int dia, int mes, int ano){
      this.setDia(dia);
      this.setMes(mes);
      this.setAno(ano);
   }
   
  //SET GET DIA
   public void setDia(int dia){
      this.dia = dia;
   }
   
   public int getDia(){
      return this.dia;
   }
   
  //SET GET MES
   public void setMes(int mes){
      this.mes = mes;
   }
   
   public int getMes(){
      return this.mes;
   }
   
   public String getMesStringComplite(){
      String[] mes = {"Janeiro","Fevereiro","Marco","Abril","Maio","Junho",
                        "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
      String mensagem = "";
      try{
         mensagem = mes[this.getMes()-1];
      }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
         System.err.println("Mes invalido!!");
      }
      return mensagem;
   }
   
   public String getMesString(){
      String[] mes = {"Jan","Fev","Mar","Abr","Maio","Jun",
                        "Jul","Ago","Set","Out","Nov","Dez"};
      String mensagem = "";
      try{
         mensagem = mes[this.getMes()-1];
      }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
         System.err.println("Mes invalido!!");
      }
      return mensagem;
   }
   
   //SET GET ANO
   public void setAno(int ano){
      this.ano = ano;
   }
   public int getAno(){
      return this.ano;
   }
   
   //Metodo ano Bissexto
   public boolean ehBissexto(){
      boolean bi = false;
      if((ano%4 == 0 && ano%100 != 0) || ano%400 == 0){
         bi = true;
      }
      return bi;
   }
   
   //Data valida
   public boolean ehValido(){
      boolean valida = false;
      
      if(ehAnoValido() && ehMesValido() && ehDiaValido()){
         valida = true;
      }
      
      return valida;
   }
   
   public boolean ehAnoValido(){
      boolean valida = false;
      
      int ano = this.getAno();
      if(ano > 0)
         valida = true;     
      return valida;
   }
   
   public boolean ehMesValido(){
      boolean valida = false;
      
      int mes = this.getMes();
      if(0 < mes && mes < 13)
         valida = true;     
      return valida;
   }
   
   public boolean ehDiaValido(){
      boolean valida = false;
      
      int dia = this.getDia();
      int mes = this.getMes();
      int ano = this.getAno();
      if(dia > 0){
         switch(mes){
            case 1:
               if(dia <= 31)
                  valida = true;
               break;
            case 2:
               if(this.ehBissexto() && dia <= 29){
                  valida = true;
               }else if(!this.ehBissexto() && dia <= 28){
                    valida = true;
               }
               break;
            case 3:
               if(dia <= 31)
                  valida = true;
               break;
            case 4:
               if(dia <= 30)
                  valida = true;
               break;
            case 5:
               if(dia <= 31)
                  valida = true;
               break;
            case 6:
               if(dia <= 30)
                  valida = true;
               break;
            case 7:
               if(dia <= 31)
                  valida = true;
               break;
            case 8:
               if(dia <= 31)
                  valida = true;
               break;
            case 9:
               if(dia <= 30)
                  valida = true;
               break;
            case 10:
               if(dia <= 31)
                  valida = true;
               break;
            case 11:
               if(dia <= 30)
                  valida = true;
               break;
            case 12:
               if(dia <= 31)
                  valida = true;
               break;
            default:
               break;
         }
      }
      
      return valida;
   }
   
   public Data recente(Data data){
      Data recente = this;
      
      if(this.getAno() < data.getAno())
         recente = data;
      else if(this.getAno() == data.getAno() && this.getMes() < data.getMes())
         recente = data;
      else if(this.getAno() == data.getAno() && this.getMes() == data.getMes() && this.getDia() < data.getDia())
         recente = data;
      
      return recente;
   }
   
   public boolean ehMaisRecente(Data data){
      boolean recente = false;
      if(this.recente(data) == this)
         recente = true;
      
      return recente;
   }
   
   public void leDataTeclado(){
      System.out.println("Dia: ");
      this.setDia(leInt());
      System.out.println("Mes[1-12]: ");
      this.setMes(leInt());
      System.out.println("Ano: ");
      this.setAno(leInt());
   }
   
   private static int leInt(){
      Scanner scanner = new Scanner(System.in);
      int inteiro = 0;
      boolean erro = true;
      do{
         try{
            inteiro = scanner.nextInt();
            erro = false;
         }
         catch(InputMismatchException inputMismatchException){
            System.err.print("Valor Invalido! \nDigite um inteiro: ");
            scanner.nextLine();
         }
      }while(erro);
      return inteiro;
   }
   
   public void escreveData(){
      System.out.println(this.getDia()+" / "+this.getMes()+" / "+this.getAno());
   }
   
   public void escreveDataMesCompleto(){
      System.out.println(this.getDia()+" / "+this.getMesStringComplite()+" / "+this.getAno());
   }
   
   public void escreveDataMes(){
      System.out.println(this.getDia()+" / "+this.getMesString()+" / "+this.getAno());
   }
}