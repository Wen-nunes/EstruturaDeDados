package desafio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;


public class Principal {
	
	
	public static void listaNomes (ArrayList<Atleta> lista) {
		if(!lista.isEmpty()) {
			lista.sort((a1, a2) ->((String)a1.getNome()).compareTo(a2.getNome()));
				for(Atleta item : lista) {
					System.out.println(item);
				}
		}
		else {
			System.out.println("Nenhum atleta cadastrado");
		}
			
	}
	
	public static void listaPontuacao(ArrayList<Atleta> lista){
		if(!lista.isEmpty()) {
			lista.sort((a2, a1)->((String)a1.getPontuacao()).compareTo(a2.getPontuacao()));
			for(Atleta pontos : lista) {
				System.out.println(pontos);
			}
		}
		else {
			System.out.println("Nenhum atleta encontrado!");
		}
	}
	
	public static void cadastrar (HashSet<Atleta> hashAtleta, Atleta jogador, String nome, String apelido, String fone,String dataDeNascimento, String pontuacao ) {
		System.out.println("CADASTRADO!!");
		jogador = new Atleta (nome, apelido, fone, dataDeNascimento, pontuacao);
		if(!hashAtleta.add(jogador)) {
			System.out.println("Atleta ja cadastrado");
		}
	}
	
	public static void procurarNome (HashSet<Atleta> hashAtleta, String nome) {
	    boolean encontrado = false;
	    for (Atleta jogador : hashAtleta) {
	        if (jogador.getNome().equals(nome)) {
	            encontrado = true;
	            System.out.println(nome + " encontrado!");
	            break; 
	        }
	    }
	    if (!encontrado) {
	        System.out.println("Atleta nao encontrado.");
	    }
	}


	public static void procurarApelido (HashSet<Atleta> hashAtleta, String Apelido) {
		 boolean encontrado = false;
		    for (Atleta jogador : hashAtleta) {
		        if (jogador.getApelido().equals(Apelido)) {
		            encontrado = true;
		            System.out.println(Apelido + " encontrado!");
		            break; 
		        }
		    }
		    	if (!encontrado) {
		        System.out.println("Atleta nao encontrado.");
		    }
		}
	
	public static void removerNome (HashSet<Atleta> hashAtleta, String nome) {
		boolean removido = false;
		for (Atleta jogador : hashAtleta) {
				if (jogador.getNome().equals(nome)) {
					hashAtleta.remove(jogador);
					removido = true;
					System.out.println("Atleta removido: "+jogador);
					break;
				}
				if (!removido) {
					System.out.println("Atleta nao encontrado.");
				}
			}
		}
	
	public static void removerApelido (HashSet<Atleta> hashAtleta, String apelido) {
		boolean removido = false;
		for (Atleta jogador : hashAtleta) {
			if (jogador.getApelido().equals(apelido)) {
				hashAtleta.remove(jogador);
				removido = true;
				System.out.println("Atleta removido: "+jogador);
				break;
			}
			if (!removido) {
				System.out.println("Atleta nao encontrado!");
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashSet<Atleta> hashAtleta = new HashSet<Atleta>();
		ArrayList<Atleta> lista = new ArrayList<Atleta>();
		Atleta jogador = new Atleta();
		
		int op;
		int opInt;
		String nome, apelido, fone, dataDeNascimento, pontuacao;
		String procuraNome, procuraApelido, removeNome, removeApelido;
		
		do {
			System.out.println("\nMENU \n");
			System.out.println("1- Listar Atleta (Nome ou pontuacao)");
			System.out.println("2- Cadastrar Atleta");
			System.out.println("3- Procurar Atleta (nome ou apelido)");
			System.out.println("4- Remover atleta (nome ou apelido)\n");
			op = sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			case 1:
				System.out.println("Deseja listar por 1- nome ou 2- pontuacao ");
				opInt = sc.nextInt();
				sc.nextLine();
				lista.clear();
				
				if (opInt==1) {
					 lista.addAll(hashAtleta);
				     listaNomes(lista);
				}
				if(opInt==2) {
					lista.addAll(hashAtleta);
					listaPontuacao(lista);
				}
			break;
				
			case 2:
				System.out.println("PREENCHA O CADASTRO DO ATLETA: ");
				System.out.println("Digite o nome: ");
				nome = sc.nextLine();
				System.out.println("Digite o apelido: ");
				apelido = sc.nextLine();
				System.out.println("Digite o fone: ");
				fone = sc.nextLine();
				System.out.println("Digite o Data de Nascimento: ");
				dataDeNascimento = sc.nextLine();
				System.out.println("Digite a Pontuacao: ");
				pontuacao = sc.nextLine();
				cadastrar (hashAtleta, jogador, nome, apelido, fone, dataDeNascimento,pontuacao);
			
				break;
				
				
			case 3:
				System.out.println("Deseja procurar por 1- Nome ou 2- Apelido ");
				opInt = sc.nextInt();
				sc.nextLine();
				
				if (opInt==1) {
					System.out.println("Digite o Nome a ser procurado: ");
					procuraNome = sc.nextLine();
					procurarNome (hashAtleta, procuraNome);
				}
				
				if (opInt==2) {
					System.out.println("Digite o Apelido a ser procurado: ");
					procuraApelido = sc.nextLine();
					procurarApelido (hashAtleta, procuraApelido);
				}
				
				break;
				
			case 4:
				System.out.println("Deseja remover por 1- Nome ou 2- Apelido ");
				opInt = sc.nextInt();
				sc.nextLine();
				
				if (opInt==1) {
					System.out.println("Digite o Nome a ser removido: ");
					removeNome = sc.nextLine();
					removerNome (hashAtleta, removeNome);
				}
				
				if (opInt==2) {
					System.out.println("Digite o Apelido a ser removido: ");
					removeApelido = sc.nextLine();
					removerApelido (hashAtleta, removeApelido);
				}
				break;
				
			default: 
				System.out.println("Opcao invalida, Digite novamente!");
			}
			
		}while (true);
	}
		

	}


