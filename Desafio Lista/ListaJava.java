package ListaJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ListaJava {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
        ArrayList<List<Integer>> listaGenerica = new ArrayList<>();
        
        System.out.println("Digite quantos elementos possui a lista generica:");
        int generica = teclado.nextInt();
        System.out.println("Digite quantos elementos possui a lista interna:");
        int interna = teclado.nextInt();
        
        Random gerador = new Random();
        int valor;
        for(int i = 0; i < generica; i++) {
            listaGenerica.add(new ArrayList<Integer>());
            for(int j = 0; j < interna; j++) {
                valor = gerador.nextInt(20);
                if (!listaGenerica.get(i).contains(valor)) {
                    listaGenerica.get(i).add(valor);
                    listaGenerica.get(i).sort(null);
                }
            }
        }
        
        for(int i = 0; i < listaGenerica.size(); i++) {
            System.out.println("Exibindo Lista: " + (i + 1));
            for(int j = 0; j < listaGenerica.get(i).size(); j++) {
                System.out.println("Valor " + (j + 1) + ": " + listaGenerica.get(i).get(j));
            }
        }
        
        //
        List<Integer> unicos = new ArrayList<>();
        for (int i = 0; i < listaGenerica.size(); i++) {
            for(int j = 0; j < listaGenerica.get(i).size(); j++) {
                int elementoAtual = listaGenerica.get(i).get(j);
                if (!ElementoRepetido(listaGenerica, elementoAtual)) {
                    unicos.add(elementoAtual); //Add somente quando retorna false no método
                }
            }
        }
        
        System.out.println("Elementos unicos:");
        for (Integer elemento : unicos) {
            System.out.println(elemento);
        }
    }
    
    private static boolean ElementoRepetido(ArrayList<List<Integer>> listaGenerica, int elemento) {
        int contagem = 0;
        for (int i = 0; i < listaGenerica.size(); i++) {
            if (listaGenerica.get(i).contains(elemento)) { // [0,1,2] contains 0,1,2
                contagem++;
                if (contagem > 1) {
                    return true; //Elemento que possui contagem > 1
                }
            }
        }
        return false; //Elemento possui contagem == 1 (Apareceu apenas 1x)
    }

	}


