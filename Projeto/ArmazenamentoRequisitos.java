import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ArmazenamentoRequisitos {

    public static void salvarRequisitosEmArquivo(List<Requisito> requisitos, String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Requisito requisito : requisitos) {
                if (requisito instanceof RequisitoNaoFuncional) {
                    RequisitoNaoFuncional reqNaoFuncional = (RequisitoNaoFuncional) requisito;
                    writer.println("Tipo: Requisito Não Funcional");
                    writer.println("Nome: " + reqNaoFuncional.nome);
                    writer.println("Descrição: " + reqNaoFuncional.descricao);
                    writer.println("Categoria: " + reqNaoFuncional.categoria);
                } else {
                    writer.println("Tipo: Requisito Funcional");
                    writer.println("Nome: " + requisito.nome);
                    writer.println("Descrição: " + requisito.descricao);
                    writer.println("Prioridade: " + requisito.prioridade);
                }
                writer.println();  // linha vazia para separar os requisitos
            }
            System.out.println("Requisitos salvos com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar requisitos no arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Código para capturar os requisitos...
        Scanner scanner = new Scanner(System.in);
        List<Requisito> requisitos = new ArrayList<>();
        
        while (true) {
            System.out.println("1 - Requisito Funcional");
            System.out.println("2 - Requisito Não Funcional");
            System.out.println("0 - Sair");
            System.out.print("Escolha o tipo de requisito: ");
            int opcao = scanner.nextInt();
            
            if (opcao == 0) {
                break;
            }
            
            scanner.nextLine();  // Limpar o buffer do teclado
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();
            
            if (opcao == 1) {
                System.out.print("Prioridade: ");
                String prioridade = scanner.nextLine();
                requisitos.add(new Requisito(nome, descricao, prioridade));
            } else if (opcao == 2) {
                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();
                requisitos.add(new RequisitoNaoFuncional(nome, descricao, categoria));
            }
            
            System.out.println("Requisito adicionado com sucesso!\n");
        }
        
        // Exibir os requisitos adicionados
        System.out.println("Requisitos adicionados:");
        for (Requisito requisito : requisitos) {
            System.out.println("Nome: " + requisito.nome);
            System.out.println("Descrição: " + requisito.descricao);
            
            if (requisito instanceof RequisitoNaoFuncional) {
                RequisitoNaoFuncional reqNaoFuncional = (RequisitoNaoFuncional) requisito;
                System.out.println("Categoria: " + reqNaoFuncional.categoria);
            } else {
                System.out.println("Prioridade: " + requisito.prioridade);
            }
            
            System.out.println();
        }
        
        scanner.close();
        // Após capturar os requisitos, chame o método para salvá-los em um arquivo
        salvarRequisitosEmArquivo(requisitos, "requisitos.txt");
    }
}
