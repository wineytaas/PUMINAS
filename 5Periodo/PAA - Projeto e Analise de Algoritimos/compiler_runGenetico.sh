#!/bin/bash

# final=$(( $1 + 1 ));

# for i in $( seq 2 $final );
arquivoTempos="TimeOutGenetico${1}_Print.out"
arquivoSaidas="outGenetico${1}_Print.out"
numTestes=10

if [ ! -d './DadosEntrada' ]
then 
	mkdir DadosEntrada
fi

echo "" > $arquivoTempos
echo "" > $arquivoSaidas

for i in $( seq 1 $1 );
do
	valor=$(( $i * 2 ))
	nomeArquivo="./DadosEntrada/DadosEntrada${valor}.sh"
	
	./creatFile.sh ${valor} $nomeArquivo
	
	echo "" >> $arquivoTempos; echo "" >> $arquivoSaidas;
	echo "================================  Algoritmo genético (${valor})  ================================" >> $arquivoSaidas;
	echo "================================  Algoritmo genético (${valor})  ================================" >> $arquivoTempos;
	
	g++ Grafo.h Grafo.cpp algoritmoGenetico.cpp -o algoritmoGenetico
	for teste in $( seq 1 $numTestes )
	do
		(time ./algoritmoGenetico $nomeArquivo >> $arquivoSaidas) 2>> $arquivoTempos
	done
	
sed -i '/^user/d' $arquivoTempos 		#Remove as linhas que começam a palavra 'user'
sed -i '/^sys/d' $arquivoTempos 		#Remove as linhas que começam a palavra 'sys'
sed -i '/^$/d' $arquivoTempos			#Remove as linhas em branco
# sed -i 's/m\|s\|real//g' $arquivoTempos	#Altera 'm', 's', 'real' para ''
sed -i 's/s\|real//g' $arquivoTempos	#Altera 's', 'real' para ''
sed -i 's/\t//' $arquivoTempos			#Remove os 5 primeiros caracteres

done

