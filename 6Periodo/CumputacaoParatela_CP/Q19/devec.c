#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<omp.h>

/*

devec.c:45:5: note: not vectorized: latch block not empty.
devec.c:29:15: note: not vectorized: control flow in loop.
devec.c:16:1: note: not vectorized: not enough data-refs in basic block.
devec.c:25:20: note: not vectorized: failed to find SLP opportunities in basic block.


*/

int main(void)
{
	int tamanho = 15, aux = 1, i = 1;
	int time[tamanho];
    int b[tamanho];
    int c[tamanho];
	
    

    for (i = 1; i < rand()%tamanho; i++){
        time[i] = b[i] + c[i];
    }

	i = 1;
    while(i < tamanho){
        if(aux%3 == 0){
            time[i] = c[i] * b[i];
            i = i + (aux % i);
            aux = aux + 15;
        }
		else{
            c[i] = time[i];
            aux = aux + 1;
            i = i *(aux-i);
        }
    }
	
	i = 1;
	while(i < tamanho){
        if(time[i]%3 == 0){
            time[i] = c[i] * b[i];	
        }
		else{
            break;
        }
    }

    for (i = 1; i < rand()%tamanho; i++){
        printf("%d", time[i]);
        time[i] = b[i] + c[i];
    }

    return 0;
}
