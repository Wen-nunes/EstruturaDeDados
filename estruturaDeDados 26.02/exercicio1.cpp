#include <iostream>
#include <ctime>

using namespace std;

typedef struct nodo {
    int numero;
    struct nodo *prox;
} Celula;

Celula *inserirPilha(int numero, Celula *topo) {
    //alocar
    Celula *novo = (Celula *)malloc(sizeof(Celula));
    //depositar
    novo->numero = numero;
    //engatar
    novo->prox = topo;

    return novo;
}

Celula *removerPilha(Celula *topo) {
	Celula *lixo;

	if (!topo) {
		cout << "Pilha vazia\n" << endl;
		return topo;
	}

	lixo = topo;
	topo = topo->prox; 
	
	free(lixo);

	return topo;
}


void exibirPilha(Celula *topo) {
    if (!topo) return;
    
    for (Celula *i = topo; i != NULL; i = i->prox) {
        cout << i->numero << endl;
    }
}

bool estaContido(int numero, Celula *topo) {
    if (!topo) return 0;
    
    for (Celula *i = topo; i != NULL; i = i->prox) {
        if (numero == i->numero){
            return true;
        }
    }
    return false;
}

int contarPilha(Celula *topo) {
    int quantidade = 0;
    Celula *p;
    for (p = topo; p ; p = p->prox) {
        quantidade++;
    }
    return quantidade;
}


int main() {
    Celula *pilha = NULL;

    int quantidadeNumeros;
    cout << "Quantos numeros quer armazenar na Pilha? ";
    cin >> quantidadeNumeros;
    int numero;

    srand(time(NULL));
    for (; quantidadeNumeros > 0; quantidadeNumeros--){
        numero = rand() % 100;
        if (numero % 2 == 0) {
            pilha = inserirPilha(numero, pilha);
        }
        else {
            pilha = removerPilha(pilha);
        }
    }

    exibirPilha(pilha);
    cout << "Pilha com um total de " << contarPilha(pilha) << " elementos" << endl;

    return 1;
}