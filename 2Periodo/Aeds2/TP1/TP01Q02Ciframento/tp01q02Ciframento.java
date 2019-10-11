public class tp01q02Ciframento{
	public static void main(String []args){
		String[] entrada = new String[1000];
      		String linha;
      		int numEntrada = 0;
 
      		//Leitura da entrada padrao
      		do {
         		entrada[numEntrada] = MyIO.readLine();
      		} while (!igual(entrada[numEntrada++],"FIM"));
      		numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
 		
      		//Para cada linha de entrada, gerando uma de saida contendo a string codificada
      		for(int i = 0; i < numEntrada; i++){
			MyIO.println(codificarCesar(entrada[i], 3));
      		}
	}
	
	//Testa se as strings sao iguais
	public static boolean igual(String str1, String str2){
		boolean iguais = false;
		//Testa se elas sao iguais em tramanho
		if(str1.length() == str2.length()){
			int count = 0;
			while(str1.length() > count && str1.charAt(count) == str2.charAt(count)){
				count++;
			}
			if(count == str1.length()){
				iguais = true;
			}
		}
		return iguais;
	}
	
	//Codifica a string de acordo com a chave
	public static String codificarCesar(String str, int chave){
		String codificado = "";
		int i = 0;
		while(i < str.length()){			
			codificado += (char)((int)str.charAt(i) + (int)chave);
			i++;
		}
		return codificado;
	}

}
