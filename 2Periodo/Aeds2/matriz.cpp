#include <stdio.h>
#include <stdlib.h>
typedef struct Celula{
    struct Celula dir;
    struct Celula esq;
    struct Celula superior;
    struct Celula inferior
    int elemento
}Celula;

Celula *inicio;
void start(){
    inicio = NULL;
}

void *novaCelula(int elemento){
    Celula *tmp = (Celula*) malloc(1*sizeof(Celula));
    tmp->dir = NULL;
    tmp->esq = NULL;
    tmp->superior = NULL;
    tmp->inferior = NULL;
    tmp->elemento = elemento;
    return tmp;
}

void criaMatriz(int tamanho){
    int i;
    inicio = novaCelula(0);
    Celula *tmp = inicio;
    Celula *aux;
    //CRIAR 3 ponteiros
    for(i = 0; i < tamanho-1; i++){
            aux = tmp;
            for(i = 1; i < tamanho; i++){
                aux->prox = novaCelula(0);
                aux->prox->ant = aux;
                aux = aux->prox;
            }
    }
}

int main(){

}

/* //Matriz comum
int main(){
   int n = 5;
   int** matriz = (int**) malloc(n*sizeof(int*));
   int i, j;
   for(i = 0; i < n ; i++){
      matriz[i] =(int*) malloc(n*sizeof(int));
      for(j = 0; j < n ; j++){
         matriz[i][j] = rand() % 20;
      }
   }

   printf("[\n");
   for(i = 0; i < n ; i++){
      for(j = 0; j < n ; j++){
         printf("%d ",matriz[i][j]);
      }
      printf("\n");
   }
   printf("]\n");
   return 0;
}
*/
