#!/bin/bash

nomeArquivo="DadosEntrada.in"
valor=1000


if [ "${#}" = "0" ]
then
	echo " $0 [numeroDeCidades] [NomeArquivo] "
elif [ "${#}" = "2" ]
then
	nomeArquivo=$2
fi

if [ ! -f $nomeArquivo ];
then
	echo "${1}" > $nomeArquivo

	for i in $( seq 1 $1);
	do
		random1=$(( $RANDOM % $valor ));
		random2=$(( $RANDOM % $valor ));
		echo "${random1} ${random2} " >> $nomeArquivo 
	done
fi