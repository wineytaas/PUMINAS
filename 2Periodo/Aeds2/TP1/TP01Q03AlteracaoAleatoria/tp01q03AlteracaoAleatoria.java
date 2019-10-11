import java.util.Random;

public class tp01q03AlteracaoAleatoria{
	public static void main(String []args){
		String[] entrada = new String[1000];
      		String linha;
      		int numEntrada = 0;
		Random gerador = new Random();
 		gerador.setSeed(4);
      		//Leitura da entrada padrao
      		do {
         		entrada[numEntrada] = MyIO.readLine();
      		} while (!igual(entrada[numEntrada++],"FIM"));
      		numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
 		
      		//Para cada linha de entrada, gerando uma de saida contendo a string codificada
      		for(int i = 0; i < numEntrada; i++){
			//MyIO.println(entrada[i]);
			//MyIO.println(trocarLetras(entrada[i], 'a' , 'W'));
			char c1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
			char c2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
			//MyIO.println(c1+" "+c2+" "+trocarLetras(entrada[i], c1 , c2 ));
			MyIO.println(trocarLetras(entrada[i], c1 , c2 ));
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
	
	//Codifica substituir letras
	public static String trocarLetras(String str, char chave , char alteracao){
		String modificada = "";
		int i = 0;
		while(i < str.length()){
			if(str.charAt(i) == chave){
				modificada += alteracao;
			}else{
				modificada += str.charAt(i);
			}
			i++;
		}
		return modificada;
	}

}
