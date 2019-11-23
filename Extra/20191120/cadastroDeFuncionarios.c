#include <stdio.h>
#include <stdlib.h>

#define t 3

struct Aluno {

	int numMatricula;
	int codSerie;
	int numRecuperacoes;
	float mensalidade;

};

float ValorMensalidade(int codSerie)
{
	float 	valor = 0;
  switch(codSerie){
		case 1:
			valor = 707.37; //1. Maternal: R$ 707.37
			break;
		case 2:
			valor = 750.00;	//2. Jardim I: R$ 750.00
			break;
		case 3:
			valor = 750.00;	//3. Jardim II: R$ 750.00
			break;
		case 4:
			valor = 688.43;	//4. 1o. ano: R$ 688.43
			break;
		case 5:
			valor = 688.43;	//5. 2o. ano: R$ 688.43
			break;
		case 6:
			valor = 688.43;	//6. 3o. ano: R$ 688.43
			break;
		case 7:
			valor = 688.43;	//7. 4o. ano: R$ 688.43
			break;
		case 8:
			valor = 688.43;	//8. 5o. ano: R$ 688.43
			break;
		case 9:
			valor = 694.10;	//9. 6o. ano: R$ 694.10
			break;
		case 10:
			valor = 694.10;	//10. 7o. ano: R$ 694.10
			break;
		case 11:
			valor = 694.10;	//11. 8o. ano: R$ 694.10
			break;
		case 12:
			valor = 694.10;	//12. 9o. ano: R$ 694.10
			break;
		case 13:
			valor = 808.95;	//13. 1o. ano (Ensino Médio): R$ 808.95
			break;
		case 14:
			valor = 808.95;	//14. 2o. ano (Ensino Médio): R$ 808.95
			break;
		case 15:
			valor = 860.29;	//15. 3o. ano (Ensino Médio): R$ 860.29
			break;
		default:
			valor = 0;
			break;
	}
	return 	valor;
}

void lerVet( struct Aluno *p){

	int i;

	for ( i=1; i <= t ; i++){
		printf("Digite o numero de matricula: ");
		scanf("%d",&p->numMatricula);
		
		printf("Digite o codigo da serie: ");
		scanf("%d",&p->codSerie);
		
		printf("Digite o numero de recuperacoes: ");
		scanf("%d",&p->numRecuperacoes);
		
		if(p->codSerie < 4)
		{
			p->mensalidade = ValorMensalidade(p->codSerie);
		}
		else
		{
			p->mensalidade = ValorMensalidade(p->codSerie) * ( 1.0 + (p->numRecuperacoes/10.0));
		}
		
		printf("\n");
		p++;

	}

}

void mostrarVet( struct Aluno *p ){

	int i;

  //Impressao do titulo da lista
  printf("\nMatricula    Novo 	valor\n");
  //Para cada aluno em recuperacao: 

	for ( i=0; i < t; i++ ){    
    //Impressao do numero de matricula
    printf("%9d    ", p->numMatricula);
    //Impressao do novo preço
    printf("R$ %.2f\n", p->mensalidade);
		p++;

	}

}

void trocar (struct Aluno *pv, int x, int y) {

	struct Aluno aux = pv[x];
	pv[x] = pv[y];
	pv[y] = aux; 

}

void bubbleSort( struct Aluno *p){

	int i, j;

	for ( i=t-1; i > 0; i-- ){
		for ( j=0; j < i; j++ ){
			if ( p[j].numMatricula > p[j+1].numMatricula ) // A comparaÃ§Ã£o Ã© pelo membro matricula da struct
				trocar(p, j, j+1);

		}
	}



}

int main(){

	struct Aluno vet[t];
	
	lerVet(vet);/*Le os dados dos alunos*/
	
	bubbleSort(vet);/*Ordena os alunos por numero de matricula*/

	mostrarVet(vet);/*Printa o vetor de Alunos e suas notas e mensalidades*/
	return 0;
}