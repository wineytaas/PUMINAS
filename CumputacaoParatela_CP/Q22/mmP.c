#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

/**
 * ------------------Tempo em Sequencial-----------------------
 * real	1m55.750s
 *
 * ------------------Tempo em Paralelo CPU---------------------
 * real	1m3.296s
 * Speedup: 1,86
 *
 * ------------------Tempo em Paralelo GPU---------------------
 * distribute:
 *
 *
 * distribute parallel for:
 *
 *
 * distribute parallel for simd:
 *
 * 
 * ------------------Configurações-----------------------------
 * Tempo sequencial   = real    1m8.723s 
 * 
 * 
 * Tempo paralelo     = real    0m27.681s
 * SpeedUp paralelo   = 2,51
 * 
 * 
 * Tempo paralelo GPU (distribute) = real    1m49.646s 
 * SpeedUp paralelo GPU (distribute)   = 0,72
 *  
 * Tempo paralelo GPU (distribute parallel for) = real    0m21.170s 
 * SpeedUp paralelo GPU (distribute parallel for)   = 3,2
 * 
 * Tempo paralelo GPU (distribute parallel for simd) = real    0m5.587s
 * SpeedUp paralelo GPU (distribute parallel for simd)   = 13,6 
 * 
 
 ==20087== NVPROF is profiling process 20087, command: ./mmp
 ==20087== Some kernel(s) will be replayed on device 0 in order to collect all events/metrics.
==20087== Replaying kernel "mm$_omp_fn$0" (done)
==20087== Profiling application: ./mmp
==20087== Profiling result:
==20087== Event result:
Invocations                                Event Name         Min         Max         Avg       Total
Device "GeForce GT 1030 (0)"
    Kernel: mm$_omp_fn$0
          1                            warps_launched          72          72          72          72

==20087== Metric result:
Invocations                               Metric Name                          Metric Description              Min         Max         Avg
Device "GeForce GT 1030 (0)"
    Kernel: mm$_omp_fn$0
          1                         warp_execution_efficiency                 Warp Execution Efficiency      86.81%      86.81%      86.81%

 */

void mm(double* a, double* b, double* c, int width) {  
    int size = width * width;
    #pragma omp target map(to:a[:size]) map(to:b[:size]) map(tofrom:c[:size])  
    //#pragma omp teams distribute parallel for simd      
    #pragma omp teams distribute 
    //#pragma omp teams distribute parallel for 
    //#pragma omp parallel for collapse(3)
    for (int i = 0; i < width; i++) {  
        for (int j = 0; j < width; j++) {
            double   sum = 0;
            for (int k = 0; k < width; k++) {
                double x = a[i * width + k];
                double y = b[k * width + j];
                sum += x * y;
            } 
            c[i * width + j] = sum;
        } 
    }    
}

int main() {
    int width = 2000;
    double *a = (double*) malloc (width * width * sizeof(double));
    double *b = (double*) malloc (width * width * sizeof(double));
    double *c = (double*) malloc (width * width * sizeof(double));

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

