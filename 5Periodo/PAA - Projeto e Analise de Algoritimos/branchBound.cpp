#include "Graph.h"
#include "math.h"
#include <iostream>
#include <vector>
#include <iomanip>
#include <time.h>
#define INFINITE 2147483647
using namespace std;
char* FileName;

/*
Calcula a distância entre dois pontos baseada no teorema de Pitágoras
*/
double distEuc(int x, int y, int a, int b) {

	return sqrt(pow(x - a, 2) + pow(y - b, 2));

}//fim distEuc

 /*
 Constrói o grafo, retornando a matriz de adjacencia
 */
Graph construirGrafo() {

	int numCitys; //número de cidades
	double x, y; //coordenadas x e y
	double aux; //auxiliar
	int valor;
	
	/*Inicio de Leitura do Arquivo*/
	FILE *arq;
	// Abre um arquivo TEXTO para LEITURA
	arq = fopen(FileName, "rt");

	fscanf(arq, "%d", &numCitys);	//O o número de cidades do arquivo
	Graph graph(numCitys);			//Cria um grafo com tamanho de numero de cidades
	
	for(int numLinha = 0; numLinha < numCitys; numLinha++) //Le até o final do arquivo
	{
		//Lê x da cidade
		fscanf(arq, "%d", &valor);
		x = (double) valor;
		
		//Lê y da cidade
		fscanf(arq, "%d", &valor);
		y = (double) valor;
		
		//Adiciona as cordenadas ao no
		graph.addCoord(numLinha, x, y);
	}

	fclose(arq);

	for (int i = 0; i < numCitys; i++) {

		for (int j = 0; j < numCitys; j++) {

			if (i != j) {

				aux = distEuc(graph.coord[i][0], graph.coord[i][1], graph.coord[j][0], graph.coord[j][1]);

				graph.addEdge(i, j, aux);

			}//fim if

		}//fim for

	}//fim for

	return graph;


}//fim construirGrafo()

/*
Imprime o trajeto percorrido em em ordem e a distância total percorrida
*/
void printResp(Graph &g, vector<int> &v) {

 double caminhoTotal;

 caminhoTotal = g.adj[v[0]][v[v.size() - 1]];

 for (int i = 0; i < v.size() - 1; i++) {

	 caminhoTotal += g.adj[v[i]][v[i + 1]];

	 cout << v[i] + 1 << " ";

 }//fim for


 cout << v[v.size() - 1] + 1 << endl;

 std::cout << std::fixed << std::setprecision(2);
 std::cout << caminhoTotal << endl;


}//fim printResp()

int main(int nargs, char *args[])
{
	printf("%s\n", args[1]);
	FileName = args[1];
	
	Graph grafo = construirGrafo();
	vector<int> resp;
	resp = grafo.branchBound();
	printResp(grafo, resp);

}
