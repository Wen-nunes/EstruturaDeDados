package arquivoGrafo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Principal {
    public static void main(String args[]) {
    	Scanner teclado = new Scanner (System.in);
        ArrayList<String> cidades = new ArrayList<>();
        ArrayList<String[]> arestas = new ArrayList<>(); 
        File arquivo = new File("cidades.txt"); 

        if (!arquivo.exists()) {
            try {
                FileWriter escritor = new FileWriter(arquivo);
                escritor.write("Sao Pedro@Santa Maria\n");
                escritor.write("Santa Maria@Agudo\n");
                escritor.write("Agudo@Santa Cruz\n");
                escritor.write("Santa Cruz@Porto Alegre\n");
                escritor.write("Porto Alegre@Lajeado\n");
                escritor.write("Lajeado@Soledade\n");
                escritor.write("Soledade@Cruz Alta\n");
                escritor.write("Cruz Alta@Julio de Castilhos\n");
                escritor.write("Julio de Castilhos@Itaara\n");
                escritor.write("Itaara@Sao Martinho\n");
                escritor.write("Itaara@Santa Maria\n");
                escritor.close();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
                return;
            }
        }

        try {
            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) { 
                String linha = scanner.nextLine();
                String[] partes = linha.split("@"); 
                if (partes.length == 2) { 
                    String origem = partes[0].trim(); 
                    String destino = partes[1].trim();

                    if (!cidades.contains(origem)) {
                        cidades.add(origem);
                    }
                    if (!cidades.contains(destino)) {
                        cidades.add(destino); 
                    }
                    arestas.add(partes); 
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("O arquivo não pôde ser lido: " + e.getMessage());
            return;
        }

        cidades.sort(null); 
        Grafo grafo_rs = new Grafo(cidades);

        for (String[] aresta : arestas) { 
            grafo_rs.inserirArestaSimetrica(aresta[0], aresta[1]);
        }

        grafo_rs.show(); 
        
        System.out.println("Cidade para pesquisar grau: ");
        String cidade = teclado.nextLine();
        System.out.println("Grau da cidade de " + cidade + ": " + grafo_rs.mostrarGrau(cidade));
    }
}