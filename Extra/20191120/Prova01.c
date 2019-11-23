#include <stdio.h>
#include <stdlib.h>

#define numDeVeiculos 2

struct Veiculo {

	int idVeiculo;
	char placa[100];
	char modelo[100];
	int ano;
	int estado;

};

void alteraEstado(struct Veiculo *p, int codVeiculo, int estado)
{
	int i;
	for ( i=1; i <= numDeVeiculos ; i++){
		if(p->idVeiculo == codVeiculo)
		{
			p->estado = estado;
		}
		p++;
	}
}

void alugar(struct Veiculo *p)
{
	int id;
	printf("Digite o ID  do veiculo:");
	scanf("%d",&id);
	
	alteraEstado(p, id, 1);
}

void devolver(struct Veiculo *p)
{
	int id;
	printf("Digite o ID  do veiculo:");
	scanf("%d",&id);
	
	alteraEstado(p, id, 0);
}

void lerVet( struct Veiculo *p){

	int i;

	for ( i=1; i <= numDeVeiculos ; i++){
		p->idVeiculo = i;
		printf("\n==================%d====================\n", p->idVeiculo);
		printf("Digite a placa do veiculo: ");
		scanf("%s",&p->placa);
		
		printf("Digite o modelo do veiculo: ");
		scanf("%s",&p->modelo);
		
		printf("Digite o ano do veiculo: ");
		scanf("%d",&p->ano);
		
		p->estado = 0;
		
		printf("\n");
		p++;

	}

}

void mostrarVet( struct Veiculo *p ){

	int i;

	for ( i=0; i < numDeVeiculos; i++ ){    
		printf("\n==================%d====================\n", p->idVeiculo);
		printf("Id Veiculo: %d\n", p->idVeiculo);
		printf("Placa:      %s\n", p->placa);
		printf("Modelo:     %s\n", p->modelo);
		printf("Ano:        %d\n", p->ano);
		printf("Estado:     %d\n", p->estado);
		printf("\n======================================\n");
		p++;
	}

}

void trocar (struct Veiculo *pv, int x, int y) {

	struct Veiculo aux = pv[x];
	pv[x] = pv[y];
	pv[y] = aux; 

}

void bubbleSort( struct Veiculo *p){

	int i, j;

	for ( i = numDeVeiculos-1 ; i > 0; i-- ){
		for ( j=0; j < i; j++ ){
			if ( p[j].ano > p[j+1].ano ) // A comparaÃ§Ã£o Ã© pelo membro matricula da struct
				trocar(p, j, j+1);

		}
	}

}

void menu(struct Veiculo *p)
{
	int option;
	
	do{
		printf("\n1. Alugar um veículo\n");
		printf("2. Devolver um veículo\n");
		printf("3. Imprimir as informações de todos os veículo da locadora\n");
		printf("4. Sair do programa\n");
		scanf("%d", &option);
		switch(option)
		{
			case 1:
				alugar(p);
				break;
			case 2:
				devolver(p);
				break;
			case 3:
				mostrarVet(p);
				break;
			default:
			break;
		}
	}while(option != 4);
}

int main(){

	struct Veiculo vet[numDeVeiculos];
	
	lerVet(vet);/*Le os dados dos veiculos*/
	
	menu(vet);
	
	// bubbleSort(vet);/*Ordena os veiculos por numero de matricula*/

	// mostrarVet(vet);/*Printa o vetor de Veiculos e suas notas e mensalidades*/
	return 0;
}