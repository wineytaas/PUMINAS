#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

int main(){
	int n = 4;
	int i;
	int a[n];
	int b[] = {1 , 2, 3, 4};
	int c[] = {1 , 2, 3, 4};
	int *d = (int*) malloc (n * sizeof(int));
	#pragma omp parallel private(i)
	{
		for(i=0; i < n; i++){
			a[i] = b[i] + c[i];
			printf("%d\n",a[i]);
		}
	}
	return 0;
}
