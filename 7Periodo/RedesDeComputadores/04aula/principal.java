public class principal {
	public static void main(String[] args)
	{
		//Cria o contexto de execu��o
		escrita eThread = new escrita();
		//Ativa a thread
		eThread.start();
	}
}
