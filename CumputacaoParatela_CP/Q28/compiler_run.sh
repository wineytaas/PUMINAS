#!/bin/bash

mpicc pipeline_primo.c -o pipeline_primo 
mpicc pipeline_primo_Resposta.c -o pipeline_primo_Resposta 
mpicc pipeline_primo_Resposta_2.c -o pipeline_primo_Resposta_2 

numProcess=3
numDePrimos=$1

echo " "
echo " "
echo "===================================	pipeline_primo  	==================================="
# time ./pipeline_primo 
echo " "
mpirun -np $numProcess ./pipeline_primo $numDePrimos

echo " "
echo " "
echo "===================================	pipeline_primo_Resposta  	==================================="
# time ./pipeline_primo_Resposta 
echo " "
mpirun -np $numProcess ./pipeline_primo_Resposta $numDePrimos



echo " "
echo " "
echo "===================================	pipeline_primo_Resposta_2  	==================================="
# time ./pipeline_primo_Resposta_2 
echo " "
mpirun -np $numProcess ./pipeline_primo_Resposta_2 $numDePrimos


