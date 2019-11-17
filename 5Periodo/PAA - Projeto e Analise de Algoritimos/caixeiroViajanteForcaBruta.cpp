
# include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

#define MAX 10000

char* FileName;

typedef struct
{
    float x, y;
    int used;
} Point;

Point p[MAX];
int numCitys; //Número de pessoas a serem resgatadas (Vertices)

void prim()
{
    int i, j;

    int tot; /* auxiliar com a quantidade de vértices presentes na árvore a ser construída */
    int smallp; /* Vertice candidato a próximo menor lado */

    float len;/* Tamanho do lado a ser avaliado, potencial candidato a mínimo. */
    float small;/* Tamanho do lado candidato a mínimo */
    float minLen;/* Tamanho da árvore geradora mínima */

    tot = p[0].used = 1;/* Começamos com p[0], mas poderia ser qqlr vértice */
	printf("1\t");
    while(tot < numCitys)
    {
        small = -1.0;

        for(i = 0; i < numCitys ; i++)  //Percorre todos os vertices
        {
            if(p[i].used) //Verifica se o vertice não está na arvore, ou seja, se ele não foi espandido
            {
                for(j = 0; j < numCitys; j++) //Pecorre todos os vertices e vai espandido os mesmos
                {
                    if(!p[j].used)
                    {
                        len = sqrt(pow(p[i].x - p[j].x, 2) + pow(p[i].y - p[j].y, 2)); //Calcula a distância entre dois pontos
                        //printf("(%d) -> (%d) - len = %.2f\n", (i+1),(j+1),len);
                        if(small == -1.0 || len < small)
                        {
                            small = len;
                            smallp = j;
                        }
                    }
                }
            }
        }
        minLen += small;
        p[smallp].used = 1;
		printf(" --> %d\t", smallp + 1);
        tot++;
    }
    printf("\n %.2f\n", minLen / 100);
}

void readData()
{
  FILE *arq;
  // Abre um arquivo TEXTO para LEITURA
  arq = fopen(FileName, "rt");
  
  if (arq == NULL)  // Se houve erro na abertura
  {
    printf("Problemas na abertura do arquivo\n");
  }
  else if(!feof(arq))//Le se diferente de fim do arquivo
  {
	fscanf(arq, "%d", &numCitys);
	
	int valor;
	for(int numLinha = 0; numLinha < numCitys; numLinha++) //Le até o final do arquivo
	{
		//Lê x da cidade
		fscanf(arq, "%d", &valor);
		p[numLinha].x = valor;
		
		//Lê y da cidade
		fscanf(arq, "%d", &valor);
		p[numLinha].y = valor;
	}
  }

  fclose(arq);
}

int main(int nargs, char *args[])
{
	printf("%s\n", args[1]);
	FileName = args[1];
	
	readData();
	
	prim();
	
	// cleanMatriz();
	
    return 0;
}