# Trabalho Pratico de PAA
##### Grupo: Wisney Tadeu de Almeida Assis dos Santos e Rafael Alkmim Machado
##### Profesora: Raquel Mini

## Introdução

	Trabalho para testar a eficiencia dos algoritimos do caixeiro viajante.

## Algoritmos
### Força Bruta

1. Arquivos

	- Graph.h
	- bruteForce.cpp

2. Como compilar

	``` g++ Graph.h bruteForce.cpp -o bruteForce ```
	
3. Como executar

	``` ./bruteForce $nomeArquivoDeEntradaDeDados ```

### Brand and Bound

1. Arquivos

	- Graph.h
	- branchBound.cpp

2. Como compilar

	``` g++ Graph.h branchBound.cpp -o branchBound ```
	
3. Como executar

	``` ./branchBound $nomeArquivoDeEntradaDeDados ```
	
### Programação dinâmica

1. Arquivos

	- dynamicP.h
	- dynamicPro.cpp

2. Como compilar

	``` g++ dynamicP.h dynamicPro.cpp -o dynamic ```
	
3. Como executar

	``` ./dynamic $nomeArquivoDeEntradaDeDados ```


### Programação dinâmica

1. Arquivos

	- Grafo.h
	- Grafo.cpp
	- algoritmoGenetico.cpp

2. Como compilar

	```  g++ Grafo.h Grafo.cpp algoritmoGenetico.cpp -o algoritmoGenetico ```
	
3. Como executar

	``` ./algoritmoGenetico $nomeArquivoDeEntradaDeDados ```

## Definições
### Dados de Entrada

Os dados devem segir o seguinte modelo:
```
	2
	2 15
	18 123
```
A  entrada  deve  ser lida  de  um  arquivo  texto  com  números  inteiros.  O  primeiro  número, n,  é  a quantidade  de  cidades  (indexadas  com  os  números  de  1  a n).  Os  números  seguintes  vêm  em pares  e  representam  as  coordenadas  das  cidades  (X  e  Y).  O  primeiro  par  de  números  são  as coordenadas  da  cidade  1,  o  segundo  par,  da  cidade  2  e  assim  sucessivamente  até  a  cidade n. Considere que 0 ≤ n≤ 100 e que 0 ≤ X,Y ≤ 1000.

## Teste

Com o intuito de facilitar os nossos testes foram criados alguns scripts bash. O primeiro a ser implementado foi o __creatFile.sh__ com o intuito de criar os arquivos de entrada que possuem em sua primeira linha o número de cidades (n) que estão no seu interior e nas n linhas seguintes temos as coordenadas das cidades x e y, para facilitar a identificação dos arquivos criados os seus nomes seguem seguinte padrão __DadosEntrada[n].sh__ . O segunda script bash foi o __compiler_run.sh__ ,esse script execulta um número determinado de testes que seguem a seguinte ordem: executa o primeiro script e posteriormente compila e executa 10 vezes os códigos gerados com os arquivos de entrada criados anteriormente. As saídas são enviadas para dois arquivos um com as saídas dos programas, outro com os tempos de execução de cada um.
	
