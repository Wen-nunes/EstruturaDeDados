#include <iostream>
#include <cstdlib>
#include <ctime>


typedef struct no {
    int dado;
    struct no *prox;
} Lista;


void exibir2(Lista *lista, Lista *lista2){
    Lista *p1;
    Lista *p2;
     cout <<"Numeros que estao nas duas listas: "<< endl;
    for (p1 = lista; p1; p1 = p1->prox) {
        for(p2 = lista2; p2; p2 = p2 -> prox){
            if(p1->dado == p2->dado){
                cout << p1->dado << endl;
            }

        }
    }
}
void exibirDiferentes(Lista *lista1, Lista *lista2) {
    Lista *p1;
    Lista *p2;
    bool encontrado;
    cout << "Numeros diferentes nas duas listas: " << endl;
    
    // Percorrer lista1 e comparar com lista2
    for (p1 = lista1; p1; p1 = p1->prox) {
        encontrado = false;
        for (p2 = lista2; p2; p2 = p2->prox) {
            if (p1->dado == p2->dado) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            cout << p1->dado << endl;
        }
    }
    
    // Percorrer lista2 e comparar com lista1
    for (p2 = lista2; p2; p2 = p2->prox) {
        encontrado = false;
        for (p1 = lista1; p1; p1 = p1->prox) {
            if (p2->dado == p1->dado) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            cout << p2->dado << endl;
        }
    }
}


void exibir(Lista *lista){
    Lista *p;
    for (p = lista; p; p = p->prox) {
        cout << p->dado << endl;
    }
}

int contar(Lista *lista){
    Lista *p;
    int qtd = 0;
    for (p = lista; p; p = p->prox) {
        qtd++;
    }
    return qtd;
}

bool localizar(int valor, Lista *lista) {
    Lista *p;
    
    for (p = lista; p; p = p->prox) {
        if (valor == p->dado)
            return true;
    }
    return false;
}

Lista *inserir(int valor, Lista *lista) {
    Lista *novo;
    novo = (Lista*)malloc(sizeof(Lista));

    novo->dado = valor;
    novo->prox = NULL;

    Lista *p, *pR;
    for (pR = NULL, p = lista; p ; pR = p, p = p->prox) {
        if (valor == p->dado) {
            free(novo);
            return lista;
        }
        if (valor < p->dado) {
            break;
        }
    }
    if (p == lista) {
        novo->prox = p;
        return novo;
    }
    if (!p) {
        pR->prox = novo;
        return lista;
    }
    pR->prox = novo;
    novo->prox = p;
    return lista;
}