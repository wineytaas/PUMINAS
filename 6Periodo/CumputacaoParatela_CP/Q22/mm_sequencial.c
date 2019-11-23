#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

/*
Tempo sequencial: 1m7.160s
Tempo paralelo para multicore: 0m37.202s
==================================================================		GPU time distribute time: 0m48.594s	===============================================================================
==30228== Event result:
Invocations                                Event Name         Min         Max      Avg       Total
Device "GeForce GT 1030 (0)"    Kernel: mm$_omp_fn$0
          1                            warps_launched      154224      154224   154224      154224

==30228== Metric result:
Invocations                               Metric Name                        Metric Description         Min         Max         Avg
Device "GeForce GT 1030 (0)"    Kernel: mm$_omp_fn$0
          1                 warp_execution_efficiency                 Warp Execution Efficiency      98.32%      98.32%      98.32%
============================================================================================================================================================================================
==================================================================		GPU time distribute parallel for time: 0m10.326s	===============================================================================
==30228== Event result:
Invocations                                Event Name         Min         Max      Avg       Total
Device "GeForce GT 1030 (0)"    Kernel: mm$_omp_fn$0
          1                            warps_launched      154224      154224   154224      154224

==30228== Metric result:
Invocations                               Metric Name                        Metric Description         Min         Max         Avg
Device "GeForce GT 1030 (0)"    Kernel: mm$_omp_fn$0
          1                 warp_execution_efficiency                 Warp Execution Efficiency      100.00%     100.00%     100.00%
============================================================================================================================================================================================
==================================================================		GPU time distribute parallel for simd time: 0m6.487s	===============================================================================
==30228== Event result:
Invocations                                Event Name         Min         Max      Avg       Total
Device "GeForce GT 1030 (0)"    Kernel: mm$_omp_fn$0
          1                            warps_launched      154224      154224   154224      154224

==30228== Metric result:
Invocations                               Metric Name                        Metric Description         Min         Max         Avg
Device "GeForce GT 1030 (0)"    Kernel: mm$_omp_fn$0
          1                 warp_execution_efficiency                 Warp Execution Efficiency      86.81%      86.81%      86.81%
============================================================================================================================================================================================
*/

void mm(double* a, double* b, double* c, int width) 
{
  //#pragma omp target map(to:a[0:(width*width)], b[0:(width*width)]) map(from:c[0:(width*width)])
  //#pragma omp teams distribute //parallel for simd
  //#pragma omp parallel for collapse(3)
  for (int i = 0; i < width; i++) {
    for (int j = 0; j < width; j++) {
      double sum = 0;
	  //#pragma omp parallel for reduction(+:sum)
      for (int k = 0; k < width; k++) {
		double x = a[i * width + k];
		double y = b[k * width + j];
		sum += x * y;
      }
      c[i * width + j] = sum;
    }
  }
}

int main()
{
  int width = 2000;
  //int width = 200;
  double *a = (double*) malloc (width * width * sizeof(double));
  double *b = (double*) malloc (width * width * sizeof(double));
  double *c = (double*) malloc (width * width * sizeof(double));

  //#pragma omp parallel for collapse(2)
  for(int i = 0; i < width; i++) {
    for(int j = 0; j < width; j++) {
      a[i*width+j] = i;
      b[i*width+j] = j;
      c[i*width+j] = 0;
    }
  }

  mm(a,b,c,width);

  //  for(int i = 0; i < width; i++) {
  //  for(int j = 0; j < width; j++) {
  //    printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
  //  }
  // }

}
