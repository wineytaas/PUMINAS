#include <iostream>
#include <vector>
#include <stdio.h>
#include <time.h>
#define INFINITE 2147483647

using namespace std;

/*
Classe grafo utilizada para a execução do Caixeiro Viajante
*/
class Graph {

private:

	int n;	// Número de vértices
	double melhor; // Variável aux usada para forca bruta e branch and boud
	vector<int> rotas; //Variável usada para execução em programação dinâmica
	vector<int> forcaBruta(int a, double res, vector<int>cidades, vector<int> melhorC); //determina o menor caminho Hamiltoniano por forca bruta
	vector<int> branchBound(int a, double res, vector<int>cidades, vector<int> melhorC); //determina o menor caminho Hamiltoniano por branch and bound
	bool isIn(int x, vector<int> v); //retorna se um elemento está no vector

public:

	double **adj;	// matriz de adjacencia
	double **coord;	// coordenadas dos vértices (cidades)
	Graph();		//Construtor
	Graph(int size);// Construtor
	~Graph();		// Destruidor
	int getSize();	//Retorna o valor de n
	void addCoord(int pos, double x, double y); //adiciona coordenadas da cidade
	void addEdge(int x, int y, double wt);	   // Adiciona uma aresta ao grafo
	bool isConnected(int x, int y);			   // Checa se dois vértices est�o conectados
	vector<int> bruteForce();	//determina o menor caminho Hamiltoniano do grafo utilizando forca bruta
	vector<int> branchBound();  //determina o menor caminho Hamiltoniano do grafo utilizando branch and bound
	void printAdj();	//imprime a matriz de adjacencia
	void printCoord();	//imprime matriz de coordenadas

};

/*
Construtor
*/
Graph::Graph(int size) {

	if (size > 1) {

		n = size;

	}//fim if

	else {

		n = 2;

	}//fim else

	adj = new double*[n];
	coord = new double*[n];

	for (int i = 0; i < n; i++) {

		coord[i] = new double[n]; // Aloca espaco de memoria para a matriz de coordenadas
		adj[i] = new double[n];

		for (int j = 0; j < n; j++) {

			adj[i][j] = -1;	// Inicializa os vertices com -1

		}//fim for

		for (int j = 0; j < 2; j++) {

			coord[i][j] = -1; // Inicializa os vertices com -1

		}//fim for


	}//fim for


	this->melhor = INFINITE; //Inicializa a variavel melhor com "infinito"

}//fim construtor()

/*
Construtor
*/
Graph::Graph() {

	n = 0;
	this->melhor = INFINITE;

}//fim construtor()


/*
Destruidor
*/
Graph::~Graph() {

}//fim destruidor()


/*
Returna numero de vertices do grafo
*/
int Graph::getSize() {

	return n;

}//fim getSize()

/*
Adiciona coordenadas do vertices na matriz coor
*/
void Graph::addCoord(int pos, double x, double y) {

	coord[pos][0] = x;
	coord[pos][1] = y;

}//fim addCoord()


/*
Adiciona uma aresta entre dois vertices com determinado peso
*/
void Graph::addEdge(int x, int y, double wt) {

	adj[x][y] = adj[y][x] = wt;

}//fim addEdge()

 /*
Verifica adjacencia entre dois vertices
 */
bool Graph::isConnected(int x, int y) {

	bool res = false;

	if (adj[x][y] >= 0) {

		res = true;

	}//fim if

	return res;

}//fim isConnected()

/*
Determina menor caminho Hamiltoniano através da forca bruta
*/
vector<int> Graph::bruteForce() {

	double tempo;
	vector<int> cidades;
	vector<int> resposta;
	cidades.push_back(0);
	this->melhor = INFINITE;

	resposta = forcaBruta(0, 0, cidades,resposta);

	return resposta;
}//fim bruteForce()

/*
Determina menor caminho Hamiltoniano através da forca bruta
*/
vector<int> Graph::forcaBruta(int a, double res, vector<int>cidades,  vector<int> melhorC) {

	for (int i = 1; i < n; i++) {

		if (!isIn(i, cidades)) {

			res += adj[a][i]; //acumula no caminho total atual
			cidades.push_back(i);

			melhorC = forcaBruta(i, res, cidades, melhorC);

			if (cidades.size() == n && (res + adj[0][cidades[cidades.size() - 1]]) < this->melhor) {

				this->melhor = res + adj[0][cidades[cidades.size() - 1]];
				melhorC = cidades;

			}//fim if

			res -= adj[a][i];
			cidades.pop_back();

		}//fim if

	}//fim for

	return melhorC;

}//fim forcaBruta()

 /*
Determina menor caminho Hamiltoniano através do branch and bound
 */
vector<int> Graph::branchBound() {

  double tempo;
	vector<int> cidades;
	vector<int> resposta;
	cidades.push_back(0);
	this->melhor = INFINITE;

	resposta = branchBound(0, 0, cidades, cidades);

	return resposta;

}//fim branchBound()

 /*
Determina menor caminho Hamiltoniano através do branch and bound
 */
vector<int> Graph::branchBound(int a, double res, vector<int>cidades, vector<int> melhorC) {

	for (int i = 0; i < n; i++) {

		if (!isIn(i, cidades)) {

			res += adj[a][i];
			cidades.push_back(i);

			if(res < this->melhor) {

				melhorC = branchBound(i, res, cidades, melhorC);

				if (cidades.size() == n && (res + adj[0][cidades[cidades.size() - 1]]) < this->melhor) {

					this->melhor = res + adj[0][cidades[cidades.size() - 1]];
					melhorC = cidades;

				}//fim if

			}//fim if

			res -= adj[a][i];
			cidades.pop_back();

		}//fim if

	}//fim for

	return melhorC;

}//fim branchBound()

/*
Retorna se elemento se encontra no vector
*/
bool Graph::isIn(int x, vector<int> v) {

	bool res = false;

	for (int i = 0; i < v.size(); i++) {

		if (v[i] == x) {

			res = true;
			i = v.size();

		}//fim if

	}//fim for

	return res;

}//fim isIn()


/*
Imprimir matriz de adjacencia
*/
void Graph::printAdj() {

	for (int i = 0; i < n; i++) {

		for (int j = 0; j < n; j++) {

			if (isConnected(i, j)) {

				cout << i << " " << j << " " << adj[i][j] << endl;

			}//fim if

		}//fim for

	}//fim for

}//fim printAdj()

 /*
Imprimir matriz de coordenadas
 */
void Graph::printCoord() {

	for (int i = 0; i < n; i++) {

		cout << i << " " << coord[i][0] << " " << coord[i][1] << endl;

	}//fim for

}//fim printCoord()
