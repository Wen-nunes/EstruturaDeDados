using namespace std;
#include<iostream>
#include<ctime>


#include "Celula.h"


int main(){
    Celula *lista = NULL;
    int valor;
    srand (time(NULL));
    for (int i=0; i < 10; i++){
        valor = rand() %50;
        lista = inserir(valor, lista);
    }
    exibir(lista);

    cout << "O tamanho da lista e: " << count(lista) << endl;
    cout << "Digite um valor para a pesquisa: ";
    cin >> valor;
    if(contains(valor, lista)){
        cout << "valor locarilzado e sendo apagado"<< endl;
        lista = remove(valor, lista);
    }
    else{
        cout << "valor nao locarilzado"<< endl;
    }
    cout << "Valor localizado: " << contains(valor, lista) << endl;
    cout << "Total de pares e: " << countPar(lista) << endl;
    cout << "Digite um valor para pesquisar indice: ";
    cin >> valor;
    cout << "O indice e: " << indexOf(valor, lista) << endl;

    return 1;
}