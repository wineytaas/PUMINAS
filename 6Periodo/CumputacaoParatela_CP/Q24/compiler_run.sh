#!/bin/bash

gcc sum_seq.c -o sum_seq
gcc sum_cpu.c -o sum_cpu -fopenmp
gcc -O3 sum_gpu.c -o sum_gpu -fopenmp
nvcc sum_cuda_shared.cu -o sum_cuda_shared
nvcc sum_cuda.cu -o sum_cuda

echo " "
echo " "
echo "===================================	sum_cuda 	==================================="
time ./sum_cuda
echo " "
nvprof --unified-memory-profiling off ./sum_cuda

echo " "
echo " "
echo "===================================	sum_cuda_shared 	==================================="
time ./sum_cuda_shared
echo " "
nvprof --unified-memory-profiling off ./sum_cuda_shared

echo " "
echo " "
echo "===================================	sum_seq 	==================================="
time ./sum_seq

echo " "
echo " "
echo "===================================	sum_cpu 	==================================="
time ./sum_cpu

echo " "
echo " "
echo "===================================	sum_gpu 	==================================="
time ./sum_gpu



