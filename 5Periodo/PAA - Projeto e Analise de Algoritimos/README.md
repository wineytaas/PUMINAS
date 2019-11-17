# Trabalho Pratico de PAA
##### Grupo: Wisney Tadeu de Almeida Assis dos Santos e Rafael Alkmim Machado
##### Profesora: Raquel Mini

## Introdução
	Trabalho para testar a eficiencia dos algoritimos do caixeiro viajante.

## Algoritmos
### Força Bruta
1. Arquivos
	1. Graph.h
	2. bruteForce.cpp

2. Como compilar
	1. ``` g++ Graph.h bruteForce.cpp -o bruteForce ```
	
3. Como executar
	1. ``` ./bruteForce $nomeArquivoDeEntradaDeDados ```

### Brand and Bound
1. Arquivos
	1. Graph.h
	2. branchBound.cpp

2. Como compilar
	1. ``` g++ Graph.h branchBound.cpp -o branchBound ```
	
3. Como executar
	1. ``` ./branchBound $nomeArquivoDeEntradaDeDados ```
	
### Programação dinâmica
1. Arquivos
	1. dynamicP.h
	2. dynamicPro.cpp

2. Como compilar
	1. ``` g++ dynamicP.h dynamicPro.cpp -o dynamic ```
	
3. Como executar
	1. ``` ./dynamic $nomeArquivoDeEntradaDeDados ```


### Programação dinâmica
1. Arquivos
	1. Grafo.h
	2. Grafo.cpp
	3. algoritmoGenetico.cpp

2. Como compilar
	1. ```  g++ Grafo.h Grafo.cpp algoritmoGenetico.cpp -o algoritmoGenetico ```
	
3. Como executar
	1. ``` ./algoritmoGenetico $nomeArquivoDeEntradaDeDados ```

##Definições
### Dados de Entrada
	Os dados devem segir o seguinte modelo:
	```
		2
		2 15
		18 123
	```
	A  entrada  deve  ser lida  de  um  arquivo  texto  com  números  inteiros.  O  primeiro  número, n,  é  a quantidade  de  cidades  (indexadas  com  os  números  de  1  a n).  Os  números  seguintes  vêm  em pares  e  representam  as  coordenadas  das  cidades  (X  e  Y).  O  primeiro  par  de  números  são  as coordenadas  da  cidade  1,  o  segundo  par,  da  cidade  2  e  assim  sucessivamente  até  a  cidade n. Considere que 0 ≤ n≤ 100 e que 0 ≤ X,Y ≤ 1000.

## Teste
	Para facilitar os testes dos algoritimos foram criados os __compiler_run[algoritmo].sh__ esse arquivo bash exuculta cada código 10 vezes para um numero determinado de testes especificados por parametro, os testes aumentam o número de cidades de dois em dois. O código cria os dados de entrada caso os mesmo não existam na pasta **DadosEntrata**.
	
