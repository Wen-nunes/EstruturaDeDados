#include <iostream>
#include <string>
#include <fstream>

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

    Celula* pilha = nullptr;
    char nomeArquivo[100];
   
    cout << "Informe nome do arquivo: " << endl;
    cin >> nomeArquivo;

    ifstream procurador;

    procurador.open(nomeArquivo); // abre o arquivo para leitura
    if (!procurador) {
        cout << "Arquivo nao localizado." << endl;
        exit(0);
    }

    string linha;
    while (!procurador.eof()) {
        getline(procurador, linha);
        pilha = inserirPilha(stoi(linha), pilha);
    }

    procurador.close();

    exibirPilha(pilha);

    return 0;
}