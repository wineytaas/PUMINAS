#include <stdio.h>
#include <mpi.h>
#define TAG 1

void main(int argc, char* argv[]) {
  int k, rank;
  double val;
  MPI_Status status;

  MPI_Init(&argc, &argv) ;
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  // MPI_Comm_size(MPI_COMM_WORLD, &numProcs);
  if (rank == 0) {
	printf("Processor 0 sends a message to 1\n");
    val = 3.14;

    // enviar o valor para todos os processos
	MPI_Send(&val, 1, MPI_DOUBLE, 1, TAG, MPI_COMM_WORLD);

  } else {
	printf("Processor 1 receives a message from 0\n");
    // receber o valor enviado
	MPI_Recv(&val, 1, MPI_DOUBLE, 0, TAG, MPI_COMM_WORLD, &status);
    printf("Process receives the value %f\n",val);

  }
  MPI_Finalize();
}