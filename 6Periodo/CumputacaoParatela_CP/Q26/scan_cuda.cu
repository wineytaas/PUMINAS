#include <stdio.h>
#include <stdlib.h>


/* ===================================     scan_cuda.cu       ===================================

a[39999999] = 799999980000000.000000

real    0m2.485s
user    0m1.233s
sys     0m1.130s

==27669== NVPROF is profiling process 27669, command: ./scan_cuda

a[39999999] = 799999980000000.000000
==27669== Profiling application: ./scan_cuda
==27669== Profiling result:
Time(%)      Time     Calls       Avg       Min       Max  Name
 51.51%  464.14ms         2  232.07ms  452.72us  463.69ms  [CUDA memcpy HtoD]
 41.72%  375.87ms         2  187.94ms  362.41us  375.51ms  [CUDA memcpy DtoH]
  5.10%  45.915ms         1  45.915ms  45.915ms  45.915ms  scan_cuda(double*, double*, int)
  1.68%  15.118ms         1  15.118ms  15.118ms  15.118ms  add_cuda(double*, double*, int)

==27669== API calls:
Time(%)      Time     Calls       Avg       Min       Max  Name
 77.63%  902.05ms         4  225.51ms  94.699us  463.95ms  cudaMemcpy
 22.23%  258.28ms         2  129.14ms  8.6740us  258.27ms  cudaMalloc
  0.06%  717.03us         2  358.52us  40.549us  676.49us  cudaFree
  0.04%  483.83us        90  5.3750us     292ns  205.79us  cuDeviceGetAttribute
  0.02%  255.32us         2  127.66us  33.083us  222.24us  cudaLaunch
  0.01%  92.437us         1  92.437us  92.437us  92.437us  cuDeviceTotalMem
  0.01%  65.884us         1  65.884us  65.884us  65.884us  cuDeviceGetName
  0.00%  13.031us         6  2.1710us     360ns  9.7500us  cudaSetupArgument
  0.00%  6.7530us         2  3.3760us  1.4020us  5.3510us  cudaConfigureCall
  0.00%  2.7420us         2  1.3710us     990ns  1.7520us  cuDeviceGetCount
  0.00%  1.1170us         2     558ns     499ns     618ns  cuDeviceGet
  
===================================     scan.c    ===================================
a[39999999] = 799999980000000.000000

real    0m0.511s
user    0m0.216s
sys     0m0.287s

*/

__global__ void scan_cuda(double* a, double *s, int width) {
  int t = threadIdx.x;
  int b = blockIdx.x*blockDim.x;
  double fodase;

  __shared__ double p[1024];
	
  if(b + t < width) {
    p[t] = a[t+b];
  }
  __syncthreads();

  for(int i = 1; i < blockDim.x; i = i * 2) {
    if (t >= i){
	  fodase = p[t] + p[t-i];
	}
	__syncthreads();
	if (t >= i){
      p[t] = fodase;
	}
	__syncthreads();
  }
  if (b + t < width){
    a[t+b] = p[t];
  }
  if (t == blockDim.x-1){
    s[blockIdx.x+1] = a[t+b];
  }
} 

__global__ void add_cuda(double *a, double *s, int width) {
  int t = threadIdx.x;
  int b = blockIdx.x*blockDim.x;

  if (b + t < width) {
    a[b+t] += s[blockIdx.x];
  }
}

int main()
{
  int width = 40000000;
  int size = width * sizeof(double);

  int block_size = 1024;
  int num_blocks = (width-1)/block_size+1;
  int s_size = (num_blocks * sizeof(double));  
 
  double *a = (double*) malloc (size);
  double *s = (double*) malloc (s_size);

  for(int i = 0; i < width; i++)
    a[i] = i;

  double *d_a, *d_s;
  
  // alocar vetores "a" e "s" no device
	cudaMalloc((void**) &d_a, size);
	cudaMalloc((void**) &d_s, s_size);

  // copiar vetor "a" para o device
	cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);

  // definição do número de blocos e threads (dimGrid e dimBlock)
	dim3 dimGrid(num_blocks, 1, 1);
	dim3 dimBlock(block_size, 1, 1);

  // chamada do kernel scan
	scan_cuda <<<dimGrid,dimBlock>>>(d_a, d_s, width);
  
  // copiar vetor "s" para o host
	cudaMemcpy(s, d_s, s_size, cudaMemcpyDeviceToHost); 

  // scan no host (já implementado)
  s[0] = 0;
  for (int i = 1; i < num_blocks; i++)
    s[i] += s[i-1];
 
  // copiar vetor "s" para o device
	cudaMemcpy(d_s, s, s_size, cudaMemcpyHostToDevice);

  // chamada do kernel da soma
	add_cuda <<<dimGrid,dimBlock>>>(d_a, d_s, width);
  
  // copiar o vetor "a" para o host
	cudaMemcpy(a, d_a, size, cudaMemcpyDeviceToHost);

  printf("\na[%d] = %f\n",width-1,a[width-1]);
  
  cudaFree(d_a);
  cudaFree(d_s);
}