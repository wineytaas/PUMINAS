#!/bin/bash

# gcc sum_seq.c -o sum_seq
# gcc sum_cpu.c -o sum_cpu -fopenmp
# gcc -O3 scan.c -o scan -fopenmp
# nvcc scan_cuda_fodase.cu -o scan_cuda_fodase
# nvcc scan_cuda.cu -o scan_cuda
mpicc distribute_number.c -o distribute_number
mpicc distribute_number_Resposta.c -o distribute_number_Resposta
mpicc distribute_number_Resposta02.c -o distribute_number_Resposta02

# echo " "
# echo " "
# echo "===================================	scan_cuda 	==================================="
# time ./scan_cuda
# echo " "
# nvprof --unified-memory-profiling off ./scan_cuda

# echo " "
# echo " "
# echo "===================================	scan_cuda_fodase 	==================================="
# time ./scan_cuda_fodase
# echo " "
# nvprof --unified-memory-profiling off ./scan_cuda_fodase

# echo " "
# echo " "
# echo "===================================	sum_seq 	==================================="
# time ./sum_seq

# echo " "
# echo " "
# echo "===================================	sum_cpu 	==================================="
# time ./sum_cpu

# echo " "
# echo " "
# echo "===================================	scan 	==================================="
# time ./scan

numProcess=4

echo " "
echo " "
echo "===================================	distribute_number 	==================================="
# time ./distribute_number
echo " "
mpirun -np $numProcess ./distribute_number

echo " "
echo " "
echo "===================================	distribute_number_Resposta 	==================================="
# time ./distribute_number_Resposta
echo " "
mpirun -np $numProcess ./distribute_number_Resposta



echo " "
echo " "
echo "===================================	distribute_number_Resposta02 	==================================="
# time ./distribute_number_Resposta02
echo " "
mpirun -np $numProcess ./distribute_number_Resposta02


