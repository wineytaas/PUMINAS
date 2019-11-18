#include <iostream>
#include <string>
#include <vector>
#include <math.h>
#include <iomanip>
#include <ctime>
#include <random>
#include <time.h>
#define INFINITE 2147483647

using namespace std;

/*
 Classe criada no intuito de armazenar um caminho percorrido no grafo
 */
class Caminho {
public:
    vector<int> vertices;
    double distTotal;

    /*
    Construtor padrão;
    */
    Caminho() {
        distTotal = 0;
    }

    /*
    Adiciona um vertice ao caminho existente
    Se o caminho não estiver vazio, soma-se a distância entre o
    vértice sendo adicionado e o anterior;
    */
    void addVertice(vector<vector<double>*>* adj, int vertice) {
        if (!vertices.empty()) {
            distTotal += adj->at(vertices.back())->at(vertice);
        }
        vertices.push_back(vertice);
    }

    /*
    Adiciona vários vertices ao caminho existente
    */
    void addVertices(vector<vector<double>*>* adj, vector<int> vertices) {
        for (unsigned int i = 0; i < vertices.size(); i++) {
            addVertice(adj, vertices.at(i));
        }
    }

    /*
    Printa o caminho, mudando para que o vértice inicial comece em 1, e não em 0;
    */
    void print() {
        for (unsigned int i = 0; i < (vertices.size() - 1); i++) {
            cout << (vertices.at(i) + 1) << " ";
        }
        cout << endl;
    }
};

/*
Estrutura de dados que abstrai as coordenadas de uma cidade e calcula distância euclidiana;
*/
class Coordenada {
public:

    int x, y;

    /*
    Construtor padrão;
    */
    Coordenada() {
    }

    /*
    Construtor que inicializa os membros
    */
    Coordenada(int x, int y) : x(x), y(y) {
    }

    /*
    Calcula a distância euclidiana entre essa coordenada e uma outra dada;
    */
    double distanciaEuclidiana(Coordenada* c) {
        double deltaX = (c->x - this->x);
        double deltaY = (c->y - this->y);
        double distancia = sqrt(deltaX * deltaX + deltaY * deltaY);
        return distancia;
    }

};

/*
Estrutura de dados que representa um grafo completo bidirecionado * com os vertices representando as coordenadas 
e as arestas representando a distância entre elas;
*/
class Grafo {

private:

    vector<Coordenada*>* cidades; //Vetor que contém os vértices (coordenadas)
    unsigned int n; //armazena o número de vértices
    vector<vector<double>*>* adj; //Matriz adjacência que contêm as distâncias entre os vértices

public:

    /*
    Constrói o grafo baseado nas coordenadas dadas, calculando suas distâncias e armazenando na matriz adjacência;
    */
    Grafo(vector<Coordenada*>* cidades) : cidades(cidades) {
        n = cidades->size();

        this->adj = new vector<vector<double>*>();
        for (unsigned int i = 0; i < n; i++) {
            this->adj->push_back(new vector<double>(n));
            vector<double>* linha = this->adj->back();
            for (unsigned int j = 0; j < n; j++) {
                linha->at(j) = cidades->at(j)->distanciaEuclidiana(cidades->at(i));
            }
        }
    }

    /*
    Destroi o grafo, e cada um de seus componentes;
    */
    ~Grafo() {
        while (!cidades->empty()) {
            Coordenada* c = cidades->back();
            cidades->pop_back();
            delete c;
        }
        delete cidades;
        while (adj->empty()) {
            vector<double>* linha = adj->back();
            adj->pop_back();
            delete linha;
        }
        delete adj;
    }

    /*
    Inicia uma "lookup table" que será usada para o algoritmo de programação dinâmica    
    As linhas da tabela representam o índice do ultimo vértice visitado
    As colunas da tabela representam quais nós foram visitados, através do seu valor
    binário (1 indicando visitado, 0 indicando não visitado). A tabela armazena a menor
    distância que é possível visitar aqueles nós indicado pela coluna, tendo visitado
    por último o nó indicado pela linha. O retorno é uma matriz de double tamanho n x 2^n, com todas as
    posições iniciadas para infinito positivo
    */
    vector<vector<double>*>* initMemo() {
        vector<vector<double>*>* memo = new vector<vector<double>*>();
        memo->reserve(n);

        unsigned int tamanhoColuna = (int) pow(2, n);

        for (unsigned int i = 0; i < n; i++) {
            memo->push_back(new vector<double>());
            memo->back()->reserve(tamanhoColuna);
            for (unsigned int j = 0; j < tamanhoColuna; j++) {
                memo->back()->push_back(INFINITE);
            }
        }

        return memo;
    }

    /*
    Preenche a tabela com as distâncias entre o nó inicial a cada um dos demais, isto é, os subproblemas de tamanho 2.
    */
    void configuraMemo(vector<vector<double>*>* memo, unsigned int inicio) {
        for (unsigned int i = 0; i < n; i++) {
            if (i != inicio) {
                memo->at(i)->at(1 << inicio | 1 << i) = adj->at(inicio)->at(i);
            }
        }
    }

    /*
    Método recursivo de suporte a geração de combinações
    */
    void combinacoes(unsigned int combinacao, unsigned int at,
            unsigned int r, unsigned int n, vector<int>* comb) {
        if (r == 0) {
            comb->push_back(combinacao);
        } else {
            for (unsigned int i = at; i < n; i++) {
                combinacao |= (1 << i);
                combinacoes(combinacao, i + 1, r - 1, n, comb);
                combinacao &= ~(1 << i);
            }
        }
    }

    /*
    Gera todas as combinações de números de n bits com r bits 1 e o restante 0.
    */
    vector<int>* combinacoes(unsigned int r, unsigned int n) {
        vector<int>* comb = new vector<int>();
        combinacoes(0, 0, r, n, comb);
        return comb;
    }

    /*
    Verifica se o iésimo bit de "combinação" é 1
    */
    bool pertence(int i, int combinacao) {
        return ((1 << i) & combinacao) != 0;
    }

    /*
    Preenche a tabela de programação dinâmica para subproblemas de tamanho 3 em diante
    */
    void resolve(vector<vector<double>*>* memo, unsigned int inicio) {
        for (unsigned int r = 3; r <= n; r++) {
            vector<int>* comb = combinacoes(r, n);
            for (unsigned int i = 0; i < comb->size(); i++) {
                int combinacao = comb->at(i);
                if (pertence(inicio, combinacao)) {

                    for (unsigned int proximo = 0; proximo < n; proximo++) {
                        int estado = combinacao ^ (1 << proximo);
                        double menorDist = INFINITE;

                        for (unsigned int ultimo = 0; ultimo < n; ultimo++) { 
                            if (ultimo != inicio 
                                && ultimo != proximo 
                                    && pertence(ultimo, combinacao)) {                                
                                double novaDist = memo->at(ultimo)->at(estado)
                                        + adj->at(ultimo)->at(proximo);
                                if (novaDist < menorDist) {
                                    menorDist = novaDist;
                                }
                            }
                        }
                        memo->at(proximo)->at(combinacao) = menorDist;
                    }

                };
            }
            delete comb;
        }
    }

    /*
    Processa a tabela para encontrar a solução ótima
    */
    Caminho encontrarSolucaoOtima(vector<vector<double>*>* memo, unsigned int inicio) {
        int ultimoIndice = inicio;
        int estado = (1 << n) - 1;
        vector<int> caminho(n + 1);

        for (unsigned int i = n - 1; i >= 1; i--) {
            int indice = -1;
            for (unsigned int j = 0; j < n; j++) {
                if (j != inicio && pertence(j, estado)) {
                    if (indice == -1) {
                        indice = j;
                    }
                    double distAnterior = memo->at(indice)->at(estado)
                            + adj->at(indice)->at(ultimoIndice);
                    double novaDist = memo->at(j)->at(estado)
                            + adj->at(j)->at(ultimoIndice);
                    if (novaDist < distAnterior) {
                        indice = j;
                    }
                }
            }
            caminho.at(i) = indice;
            estado ^= (1 << indice);
            ultimoIndice = indice;
        }
        caminho.at(0) = caminho.at(n) = inicio;

        Caminho c;
        c.addVertices(adj, caminho);
        return c;
    }

    /*
    Desaloca o espaço da tabela 
    */
    void deleteMemo(vector<vector<double>*>* memo) {
        while (!memo->empty()) {
            vector<double>* linha = memo->back();
            memo->pop_back();
            delete linha;
        }
        delete memo;
    }

public:

    /*
    Trata o problema do caixeiro viajante com programação dinâmica
    */
    Caminho pcv(int inicio) {
        Caminho caminho;
        for(int i = 0; i < 10; i++){

            double tempo;
            vector<vector<double>*>* memo = initMemo();
            configuraMemo(memo, inicio);
            resolve(memo, inicio);
            caminho = encontrarSolucaoOtima(memo, inicio);
            deleteMemo(memo);
        }//fim for
        return caminho;
    }

};

/*
Verifica se o vetor cidades contém uma coordenada com o x e y dados;
*/
bool contem(vector<Coordenada*>* cidades, int x, int y) {
    bool contem = false;
    for (unsigned int i = 0; i < cidades->size() && !contem; i++) {
        if (cidades->at(i)->x == x && cidades->at(i)->y == y) {
            contem = true;
        }
    }
    return contem;
}

/*
Gera um caso de teste aleatório dado um tamanho n e um intervalo para as coordenadas
*/
vector<Coordenada*>* geraCaso(int n, int min, int max) {
    std::random_device rd;
    std::mt19937 eng(rd());
    std::uniform_int_distribution<> distr(min, max);

    vector<Coordenada*>* cidades = new vector<Coordenada*>();
    cidades->reserve(n);

    int x, y;
    for (int i = 0; i < n; i++) {
        x = distr(eng);
        y = distr(eng);
        while (contem(cidades, x, y)) {
            x = distr(eng);
            y = distr(eng);
        }
        Coordenada* c = new Coordenada(x, y);
        cidades->push_back(c);

        c->x = x;
        c->y = y;
    }

    return cidades;
}

/*
Executa o PCV com tamanhos variando de 7 a 11, com 30 repetições cada, e imprime o tempo médio; 
*/
void cronometrando() {
    cout << setprecision(3) << fixed;
    int repeticoes = 15;
    for (int n = 2; n <= 1; n++) {
        cout << "Tamanho: " << n << endl;
        cout << "Testes (tempo em segundos): " << endl;

        double somaTempo = 0;
        vector<double> amostra;
        amostra.reserve(n);

        for (int j = 1; j <= repeticoes; j++) {
            clock_t begin = clock();

            vector<Coordenada*>* cidades = geraCaso(n, 0, 100);
            Grafo* grafo = new Grafo(cidades);

            Caminho c = grafo->pcv(0);

            clock_t end = clock();
            double tempo = double(end - begin) / CLOCKS_PER_SEC;
            somaTempo += tempo;

            cout << tempo << endl;

            amostra.push_back(tempo);

            delete grafo;
        }
        double media = somaTempo / repeticoes;

        double varianca = 0;
        for (int i = 0; i < repeticoes; i++) {
            varianca += (amostra.at(i) - media) * (amostra.at(i) - media);
        }
        varianca /= (repeticoes - 1);
        double desvioPadrao = sqrt(varianca);

        double margemDeErro = 1.96 * (desvioPadrao / sqrt(n));
        double icInferior = media - margemDeErro;
        double icSuperior = media + margemDeErro;

        cout << "Duracao media: " << media << " segundos" << endl;
        cout << "Desvio padrao: " << desvioPadrao << endl;
        cout << "Intervalo de Confiança 95%: " << icInferior << " a " << icSuperior << endl;

        cout << endl;
    }
}

/*
Processa as entradas de acordo com o especificado e trata com força bruta; 
*/
void dynamicProgramming() {
    cout << setprecision(2) << fixed;

    unsigned int n;
    cin >> n;

    vector<Coordenada*>* cidades = new vector<Coordenada*>();
    cidades->reserve(n);

    for (unsigned i = 0; i < n; i++) {
        Coordenada* c = new Coordenada();
        cin >> c->x;
        cin >> c->y;

        cidades->push_back(c);
    }

    Grafo* grafo = new Grafo(cidades);

    Caminho caminho = grafo->pcv(0);
    caminho.print();
    cout << caminho.distTotal << endl;
}
