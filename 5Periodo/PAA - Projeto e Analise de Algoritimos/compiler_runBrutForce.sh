#!/bin/bash

# final=$(( $1 + 1 ));

# for i in $( seq 2 $final );
arquivoTempos="TimeOutBrutForce${1}_Print.out"
arquivoSaidas="outBrutForce${1}_Print.out"
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
	echo "================================  Brute Force (${valor})  ================================" >> $arquivoSaidas;
	echo "================================  Brute Force (${valor})  ================================" >> $arquivoTempos;
	
	g++ Graph.h bruteForce.cpp -o bruteForce
	for teste in $( seq 1 $numTestes )
	do
		(time ./bruteForce $nomeArquivo >> $arquivoSaidas) 2>> $arquivoTempos
	done
	
sed -i '/^user/d' $arquivoTempos 		#Remove as linhas que começam a palavra 'user'
sed -i '/^sys/d' $arquivoTempos 		#Remove as linhas que começam a palavra 'sys'
sed -i '/^$/d' $arquivoTempos			#Remove as linhas em branco
# sed -i 's/m\|s\|real//g' $arquivoTempos	#Altera 'm', 's', 'real' para ''
sed -i 's/s\|real//g' $arquivoTempos	#Altera 's', 'real' para ''
sed -i 's/\t//' $arquivoTempos			#Remove os 5 primeiros caracteres

done

