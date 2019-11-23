#include <stdio.h> 
#include <stdlib.h> /*para usar o malloc*/




void creatIntMatriz(int *ptr, int tamanho)
{
	ptr = (int*)malloc(tamanho * sizeof(int));	// Dynamically allocate memory using malloc() 
	if (ptr == NULL) { 
		printf("Memory not allocated.\n"); 
		exit(0); 
	} 
}

void creatFloatMatriz(float *ptr, int tamanho)
{
	ptr = (float*)malloc(tamanho * sizeof(float));	// Dynamically allocate memory using malloc() 
	if (ptr == NULL) { 
		printf("Memory not allocated.\n"); 
		exit(0); 
	} 
}

void iniciateDatas(float *ValorMensalidade)
{
	creatFloatMatriz(ValorMensalidade , 16);
	ValorMensalidade[1] = 707.37; 	//1. Maternal: R$ 707.37
	ValorMensalidade[2] = 750.00;	//2. Jardim I: R$ 750.00
	ValorMensalidade[3] = 750.00;	//3. Jardim II: R$ 750.00
	ValorMensalidade[4] = 688.43;	//4. 1o. ano: R$ 688.43
	ValorMensalidade[5] = 688.43;	//5. 2o. ano: R$ 688.43
	ValorMensalidade[6] = 688.43;	//6. 3o. ano: R$ 688.43
	ValorMensalidade[7] = 688.43;	//7. 4o. ano: R$ 688.43
	ValorMensalidade[8] = 688.43;	//8. 5o. ano: R$ 688.43
	ValorMensalidade[9] = 694.10;	//9. 6o. ano: R$ 694.10
	ValorMensalidade[10] = 694.10;	//10. 7o. ano: R$ 694.10
	ValorMensalidade[11] = 694.10;	//11. 8o. ano: R$ 694.10
	ValorMensalidade[12] = 694.10;	//12. 9o. ano: R$ 694.10
	ValorMensalidade[13] = 808.95;	//13. 1o. ano (Ensino Médio): R$ 808.95
	ValorMensalidade[14] = 808.95;	//14. 2o. ano (Ensino Médio): R$ 808.95
	ValorMensalidade[15] = 860.29;	//15. 3o. ano (Ensino Médio): R$ 860.29
}

int main() 
{ 
	int i;
  float *ValorMensalidade;
	iniciateDatas(ValorMensalidade);
	for(i = 1 ; i < 16 ; i++)
	{
		printf("[%d] = %.2f\n", i , ValorMensalidade[i]);
	}
} 
