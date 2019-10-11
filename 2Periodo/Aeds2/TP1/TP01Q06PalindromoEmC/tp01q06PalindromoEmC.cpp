#include<stdio.h>
#include<stdlib.h>

//REFERENCIA DAS FUNCOES QUE ESTAO ABAIXO DA MAIN
int stringIguais(char* str1, char* str2);
int tamanhoString(char* str1);
int escreveSimNao(int teste);
int ehPalindromo(char str[]);

int main(){
    int n = 1000;
    char** linha = (char**)calloc(n,sizeof(char*)); // ARRAY DE PONTEIROS VAZIOS DO TIPO CHAR
    char chave[4] = "FIM"; // CHAVE PARA PARAR LEITURA
    int nLinha = 0; //CONTADOR DE LINHAS
    int continuar;
    //Le enquanto for diferente de chave
    do{
        linha[nLinha] = (char*)calloc(n,sizeof(char)); // CRIA UM ARRAY DE CHARS
        scanf("%[^\n]s", linha[nLinha]); //LE STRINGS CONSIDERANDO ESPACOS
        setbuf(stdin, NULL); //LIMPA BUFFER
        //printf("LINHA[%d] :  %s  chave: %s\n", nLinha , linha[nLinha] , chave);
        continuar = !stringIguais(linha[nLinha] , chave);
        if(continuar) nLinha++; //CONTA LINHA SE A STRING LIDA NAO FOR A CHAVE(FIM)
    }while(continuar);

    int i = 0;
    for(i = 0 ; i < nLinha ; i++){
        //printf("linha[%d] : %s ",i,linha[i]);
        escreveSimNao(ehPalindromo(linha[i]));
    }

    free(linha);
    return 0;
}

int ehPalindromo(char str[]){
    int palindromo = 0;
    int inicio = 0;
    int fim = tamanhoString(str) - 1; //REMOVE O \0 DA CONTAGEM
    //TESTA SE O ULTIMO CHAR EH IGUAL AO PRIMEIRO
    while(inicio < fim && str[inicio] == str[fim]){
        inicio++;
        fim--;
    }
    //SE O TESTE ANTERIOR FOI REALIZADO ATE O FIM EH UM PALINDROMO
    if(inicio >= fim){
        palindromo = 1;
    }
    return palindromo;
}

//ESCRESE SIM(TESTE == 1) OU NAO(TESTE == 0)
int escreveSimNao(int teste){
    if(teste){
        printf("SIM\n");
    }else{
        printf("NAO\n");
    }

}

//TESTA SE DOIS ARRANJOS DE CHARS SAO IGUAIS
int stringIguais(char str1[], char str2[]){
    int result = 0;
    int tamanho = tamanhoString(str1);
    //TESTA SE ELES POSSUEM O MESMO TAMANHO
    if( tamanhoString(str1) == tamanhoString(str2)){
        while(tamanho >= 0 && str1[result] == str2[result]){
            tamanho--;
        }
        //SE TODOS OS CHARS SAO IGUAIS
        if(tamanho < 0){
            result = 1;
        }
    }
    return result;
}

int tamanhoString(char str1[]){
    int tamanho = 0;
    while(str1[tamanho] != '\0' && str1 != 0){
        tamanho++;
    }
    return tamanho;
}
