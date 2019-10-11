#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
bool abreArquivo(char string[], int tamanho, FILE** arquivo);
void fechaArquivo(FILE* arquivo);

int main(){
        int nc, nl;
        int i, j;
        int tamanho = 13;
        char nomeArquivo[] = "./entrada.in";
        FILE *arquivo;
        
        if(abreArquivo(nomeArquivo, tamanho, &arquivo)){
			printf("Abriu o arquivo com exito!\n");
		}else{
			exit(0);
		}
		
		//n = fgetc(arquivo);
		//fread(&n, sizeof(char),1,arquivo);
		fflush(stdout);
		fscanf(arquivo, "%d", &nc);
		fflush(stdout);
		fscanf(arquivo, "%d", &nl);
		
		printf("NL: %d \n\n", nc);
		printf("NC: %d \n\n", nl);
        
        //CRIA MATRIZ
        int **matriz = (int**) malloc (nl * sizeof(int*));
        for(i = 0 ; i < nl; i++){
			matriz[i] = (int*) malloc (nc * sizeof(int));
        }
        
        //LER DADOS
        for(i = 0; i < nl ; i++){
			for(j = 0; j < nc ; j++){
				//scanf("%d" , &matriz[i][j]);
				//fread(&matriz[i][j], sizeof(int),1,arquivo);
				fflush(stdout); //Limpo o buffer do teclado
				fscanf(arquivo, "%d", &matriz[i][j]); //Leio do arquivo um inteiro e salvo na matriz				
			}
		}
		
		fechaArquivo(arquivo);
		//PRINTAR DADOS
        #pragma omp parallel private(i,j)
        {
                /*for(i = 0; i < nl ; i++){
					for(j = 0; j < nc ; j++){
						printf("%d " , matriz[i][j]);
					}
					printf("\n");
				}*/
				for(i = 0; i < nl ; i++){
					printf("%d\n" , matriz[i][nc-1]);
				}
        }
        
        return 0;
}

bool abreArquivo(char nomeDoArquivo[], int tamanho, FILE** arquivo){
	bool abriu =  false;
	/* Abre o arquivo para leitura e escrita */
    if (( *arquivo = fopen(nomeDoArquivo, "r+")) != NULL) {
        abriu = true;
    }
	return abriu;
}

void fechaArquivo(FILE* arquivo){
		fclose(arquivo);
}
