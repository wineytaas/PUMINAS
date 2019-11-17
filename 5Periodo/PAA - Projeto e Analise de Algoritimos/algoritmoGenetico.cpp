/************************************************
 * Projeto de Algoritmos - PUC Minas 15/11/2018
 * @author Matheus Kraisfeld
 * Solucoes para o Problema do Caixeiro Viajante.
 * Metodo Algortimo Genetico.
 ************************************************
 */
#include "Grafo.h"
#include <stdio.h>
#include <limits.h>
#include <iostream>
#include <math.h>
#include <time.h>

using namespace std;
using namespace Graph;
char* FileName;

typedef
   struct coodernadas{
      int cidade;
      double x;
      double y;
   }coord;

/**
 * Parametros: coordenadas das cidades
 * Retorna custo da distancia entre duas cidades
 */
double distanciaDoisPontos(double x1, double x2, double y1, double y2){
   double resp = 0.0;
   double x,y,a_x,a_y;
   x = x2 - x1;
   y = y2 - y1;
   a_x = pow(x,2);
   a_y = pow(y,2);
   resp = sqrt(a_x+a_y);
   return resp;
}

int main(int nargs, char *args[])
{
	printf("%s\n", args[1]);
	FileName = args[1];
	
   int num_vertices,tamanhoPopulacao,geracoes,taxaMutacao,verticeInicial, valor;
   double x,y,peso,tempo;
   
   
   /*Inicio de Leitura do Arquivo*/
	FILE *arq;
	// Abre um arquivo TEXTO para LEITURA
	arq = fopen(FileName, "rt");

	fscanf(arq, "%d", &num_vertices);	//O o número de cidades do arquivo
	coord cidades[num_vertices];
	Grafo* g = new Grafo(num_vertices,false);

	for(int numLinha = 0; numLinha < num_vertices; numLinha++) //Le até o final do arquivo
	{
		cidades[numLinha].cidade = numLinha;
		
		//Lê x da cidade
		fscanf(arq, "%d", &valor);
		cidades[numLinha].x = (double) valor;
		
		//Lê y da cidade
		fscanf(arq, "%d", &valor);
		cidades[numLinha].y = (double) valor;
	}

	fclose(arq);

/* Calcular distancias entre as cidades. */
   for (int i = 0; i < num_vertices; i++){
      for (int j = 0; j < num_vertices; j++){
         peso = distanciaDoisPontos(cidades[i].x,cidades[j].x,cidades[i].y,cidades[j].y);
         g->inserirAresta(i,j,peso);
      }
   }

   
   algoritmoGenetico ag(g,40,100,20,0);

        ag.gerarMenorCusto();

   return 0;
}
