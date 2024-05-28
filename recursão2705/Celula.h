
typedef struct no {
    int dado;
    struct  no *prox;
}Celula;

void exibir(Celula *lista){
    if (lista){
        cout << lista->dado << endl;
        exibir(lista->prox);

    }
}

Celula *inserir (int valor, Celula *lista){
    if(lista && valor > lista->dado){
        //avançar na lista a procura do lugar ideal para o valor
        lista->prox = inserir(valor, lista->prox);
        return lista;
    }else{
        //preciso alocar memoria e depositar os valore, alem de retornar o elemento criado
        Celula *novo = (Celula *)malloc(sizeof(Celula));
        novo->dado = valor;

        novo->prox = lista;

        return novo;
    }
}

bool contains(int valor, Celula *lista){
    if(lista){
        if(valor == lista ->dado){
            return true;
        }
        return contains(valor, lista->prox);
    }
    return false;
}

int count(Celula *lista){
    if( lista){
        return 1 + count(lista ->prox);
    }
    return 0;
}

int countPar(Celula *lista){
    if(lista){
        if(lista->dado %2 ==0){
            return 1 + countPar(lista ->prox);
        }
        return countPar(lista->prox);
    }
    return 0;
}

Celula *remove(int valor, Celula *lista){
    if(lista){
        if(valor == lista ->dado){
            //cod remoção
            Celula *paraRetorno = lista ->prox;
            free(lista);
            return paraRetorno;
        }
        lista ->prox = remove (valor, lista);
        return lista;
    }
    return NULL;
}

int indexOf(int valor, Celula *lista, int indice){
    if(lista){
        if(valor == lista->dado){
            return 0;
        }
        int resposta = indexOf(valor, lista ->prox);
        if(resposta == -27){
            return -27;
        }
        return resposta + 1;
    } else{
        // valor não localizado
        return -27;
    }
}