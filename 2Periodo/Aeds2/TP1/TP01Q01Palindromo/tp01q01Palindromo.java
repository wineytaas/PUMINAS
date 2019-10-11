public class tp01q01Palindromo{
	public static void main(String []args){
		String[] entrada = new String[1000];
      		String linha;
      		int numEntrada = 0;
 
      		//Leitura da entrada padrao
      		do {
         		entrada[numEntrada] = MyIO.readLine();
      		} while (!igual(entrada[numEntrada++],"FIM"));
      		numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
 		//MyIO.println("Valor: "+numEntrada);
      		//Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
      		for(int i = 0; i < numEntrada; i++){
			if(ehPalindromo(entrada[i])){
				MyIO.println("SIM");
			}else{
				MyIO.println("NAO");
			}
      		}
	}
	
	//Testa se as strings sao iguais
	public static boolean igual(String str1, String str2){
		boolean iguais = false;
		//Testa se elas sao iguais em tamanho
		if(str1.length() == str2.length()){
			int count = 0;
			//Testa igualdade entre elementos
			while(str1.length() > count && str1.charAt(count) == str2.charAt(count)){
				count++;
			}

			if(count == str1.length()){
				iguais = true;
			}
		}
		return iguais;
	}
	
	//Testa Palindromo
	public static boolean ehPalindromo(String str){
		boolean palindromo = false;
		int i = 0, j = str.length() - 1;
		//Testa se os elementos sao iguais comecando pelas suas estremidades
		while(i < j && str.charAt(i) == str.charAt(j)){			
			i++;
			j--;
		}
		if(i >= j){
			palindromo = true;
		}
		return palindromo;
	}

}
