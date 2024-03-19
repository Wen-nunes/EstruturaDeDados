#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

#include "lista.h"

int main() {
    Lista *lista = NULL;
     int qtd = 10;
    srand(time(NULL));
    Lista *lista2 = NULL;
     int qnt2 = 10;
    srand(time(NULL));

    for (; qtd > 0; qtd--) {
        lista = inserir(rand() % 20, lista);
    }
    cout << "Tamanho da lista " << contar(lista) << endl;
    exibir(lista);
    exibir2(lista, lista2);
    exibirDiferentes(lista, lista2);

    for (; qnt2 > 0; qnt2--) {
        lista2 = inserir(rand() % 20, lista2);
    }
    cout << "Tamanho da lista " << contar(lista2) << endl;
    exibir(lista2);
    exibir2(lista, lista2);
    exibirDiferentes(lista, lista2);

    return 1;
}