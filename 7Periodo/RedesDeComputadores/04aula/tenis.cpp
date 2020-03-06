#include <stdio.h>      /* printf, scanf, puts, NULL */
#include <omp.h>

int main()
{
    bool time = 1;
    int jogadas = 7;
	#pragma omp parallel sections shared(time, jogadas)
    {
        //Jogador 1
        #pragma omp section
        {
            while(jogadas > 0){
                #pragma omp critical
                {
                    if(time == 1){
                        printf("Time 1 - Jogador 1\n");
                        time = 0;
                        jogadas--;
                    }
                }
            }
        }

        //Jogador 2
        #pragma omp section
        {
            while(jogadas > 0){
                #pragma omp critical
                {
                    if(time == 1){
                        printf("Time 1 - Jogador 2\n");
                        time = 0;
                        jogadas--;
                    }
                }
            }
        }

        //Jogador 3
        #pragma omp section
        {
            while(jogadas > 0){
                #pragma omp critical
                {
                    if(time == 0){
                        printf("Time 2 - Jogador 3\n");
                        time = 1;
                        jogadas--;
                    }
                }
            }
        }
        
        //Jogador 4
        #pragma omp section
        {
            while(jogadas > 0){
                #pragma omp critical
                {
                    if(time == 0){
                        printf("Time 2 - Jogador 4\n");
                        time = 1;
                        jogadas--;
                    }
                }
            }
        }
    }
	return 1;
}