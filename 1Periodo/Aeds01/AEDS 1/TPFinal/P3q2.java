import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

public class P3q2{
   public static void main(String[] args){
      Funcionario[] funcionarios = new Funcionario[30];
      for(int i = 0 ; i < funcionarios.length ; i++){
         funcionarios[i] = new Funcionario();
         funcionarios[i].setCpf(funcionarios[i].getCpf()-i);
      }
      //String nome, int Cpf, Data dataNascimento, Data dataAdmissao, double salario
      String nome = "Wisney Tadeu de Almeida Assis dos Santos";      
      long cpf = Long.parseUnsignedLong("11122233344");
      Data dataNascimento = new Data(24,01,1996);
      Data dataAdmissao = new Data(20,02,2017);
      double salario = 1000.02;
      funcionarios[0] = new Funcionario(nome, cpf, dataNascimento, dataAdmissao, salario);
      
      //funcionarios[1].leFuncionarioTeclado();
      
      /*for(int i = 0 ; i < funcionarios.length ; i++){
         System.out.println("------------Funcionario "+i+" ------------");
         funcionarios[i].escreveAtributos();
      }
      */
      cpf = Long.parseUnsignedLong("11122233315");;
      int id = Funcionario.pesquisaCpf(funcionarios, cpf);
      System.out.println("\n------------Funcionario "+id+" "+cpf+" ------------");
      if(id != -1)
         funcionarios[id].escreveAtributos();
      
      
      
   }
}


class Funcionario{
   //Atributos
   private String nome;
   private long cpf;
   private Data dataNascimento;
   private Data dataAdmissao;
   private double salario;
   
   //Contrutores
   public Funcionario(){
      this.setNome("");
      this.setCpf(Long.parseUnsignedLong("11122233344"));
      this.setDataNascimento(new Data());
      this.setDataAdmissao(new Data());
      this.setSalario(0.0);
   }
   
   public Funcionario(String nome, long Cpf, Data dataNascimento, Data dataAdmissao, double salario){
      this.setNome(nome);
      this.setCpf(Cpf);
      this.setDataNascimento(dataNascimento);
      this.setDataAdmissao(dataAdmissao);
      this.setSalario(salario);
   }
   
   //Metodos de pesquisa
   public static void pesquisaNome(Funcionario[] funcionarios, String nome){
      for(int i = 0 ; i < funcionarios.length ; i++){
         //System.out.println("\n------------------- Funcionario "+i+"   "+(nome.toUpperCase() == funcionarios[i].getNome().toUpperCase())+"  _"+funcionarios[i].getNome().toUpperCase()+"_ _"+nome.toUpperCase()+"_ -------------------\n");
         if(funcionarios[i].getNome().toUpperCase().equals(nome.toUpperCase())){
                        System.out.println("\n------------------- Funcionario "+i+" -------------------\n");
                        funcionarios[i].escreveAtributos();
         }
      }
   }
   
   public static int pesquisaCpf(Funcionario[] funcionarios, long cpf){
      int id = -1;
      Funcionario.ordenaFuncionariosCpf(funcionarios);
      int in = 0;
      int end = funcionarios.length;
      int teste = end -((end-in) / 2); 
      
      while((end - in) > 1 && funcionarios[teste].getCpf() != cpf){
         if(funcionarios[teste].getCpf() > cpf){
            end = teste;
         }else{
            in = teste;  
         }
         teste = end -((end-in) / 2);
      }
      //System.out.println("in: "+in+" \nend: "+ end +" \n(end-in) / 2 : "+ (end-in) / 2 +" \nfincuinario["+teste+"]:  "+funcionarios[teste].getCpf());
      if((end - in) > 1 )
         id = teste;
      else if(end == 1 ){
         teste = 0;
         if(funcionarios[teste].getCpf() == cpf)
            id = teste;
            
      }
      //System.out.println("fincuinario["+teste+"]:  "+funcionarios[teste].getCpf());
      return id;
   }
   
   //Ordenar Arranjo de Funcionarios
   public static void ordenaFuncionariosCpf(Funcionario[] funcionario){
      for(int i = 0 ; i < funcionario.length ; i++){
         for(int j = (1+i) ; j < funcionario.length ; j++){
              if(funcionario[i].getCpf() > funcionario[j].getCpf()){
                  Funcionario f = funcionario[j];
                  funcionario[j] = funcionario[i];
                  funcionario[i] = f;
              }
         }
      }
   }
   
   //SET GET STRING NOME
   public void setNome(String nome){
      this.nome = nome;
   }
   
   public String getNome(){
      return this.nome;
   }
   
   //SET GET long CPF
   public void setCpf(long cpf){
      String l1Str = Long.toUnsignedString(cpf);
      this.cpf = Long.parseUnsignedLong(l1Str);
   }
   
   public long getCpf(){
      return this.cpf;
   }
   
   //SET GET Data dataNascimento
   public void setDataNascimento(Data dataNascimento){
      this.dataNascimento = dataNascimento;
   }
   
   public Data getDataNascimento(){
      return this.dataNascimento;
   }
   
   //SET GET Data dataAdmissao
   public void setDataAdmissao(Data dataAdmissao){
      this.dataAdmissao = dataAdmissao;
   }
   
   public Data getDataAdmissao(){
      return this.dataAdmissao;
   }
   
   //SET GET double salario
   public void setSalario(double salario){
      this.salario = salario;
   }
   
   public double getSalario(){
      return this.salario;
   }
   
   //Salrio Maior que parametro
   public boolean ehMaior(double salario){
      return this.salario > salario;
   }
   
   
   //Leitura funcionario pelo teclado
   public void leFuncionarioTeclado(){
      Data data = new Data();
      boolean erro = true;
      
      System.out.println("Digite o nome do funcionario: ");
      this.setNome(leString());
      System.out.println("Digite o cpf do funcionario[11122233344](somente numeros): ");
      this.setCpf(leLong());
      
      System.out.println("Digite a data de nascimento do funcionario: ");
      do{
         data.leDataTeclado();
         erro = !data.ehValido();            
         if(erro)
            System.out.print("Data invalida! \nDigite uma data valida: ");
      }while(erro);
      this.setDataNascimento(data);
      
      System.out.println("Digite a data de admissao do funcionario: ");
      do{
         data.leDataTeclado();
         erro = !data.ehValido();
         if(erro)
            System.out.print("Data invalida! \nDigite uma data valida: ");
      }while(erro);
      this.setDataAdmissao(data);
      
      System.out.println("Digite o salario do funcionario: ");
      this.setSalario(leReal());
   }
   
   //Escreve Atributos dos Funcionario no monitor
   public void escreveAtributos(){
      System.out.println(this.getNome());
      System.out.println(this.getCpf());
      this.getDataNascimento().escreveData();
      this.getDataAdmissao().escreveData();
      System.out.println(this.getSalario());
   }
   
   private static long leLong(){
      Scanner scanner = new Scanner(System.in);
      long inteiro = 0;
      boolean erro = true;
      do{
         try{
            inteiro = scanner.nextLong();
            erro = false;
         }
         catch(InputMismatchException inputMismatchException){
            System.err.print("Valor Invalido! \nDigite um inteiro: ");
            scanner.nextLine();
         }
      }while(erro);
      return inteiro;
   }
   
   private static double leReal(){
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
   
   private static String leString(){
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
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
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
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
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