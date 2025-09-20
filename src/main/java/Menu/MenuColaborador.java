package Menu;

import Controller.AgendamentoController;
import Controller.CatracaController;
import Controller.GerenciarAlunoController;
import Controller.GerenciarEstoqueController;
import Controller.GerenciarFuncionarioController;
import Controller.GerenciarVendaController;
import Model.Academia;
import Questoes.Questoes;
import java.util.Scanner;

public class MenuColaborador {

    public static void menuColaborador(Scanner scanner, Academia academia, GerenciarAlunoController controllerAluno, GerenciarFuncionarioController controllerFuncionario, GerenciarEstoqueController controllerEstoque, AgendamentoController controllerAgendamento, CatracaController controllerCatraca, GerenciarVendaController controllerVenda) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu do Colaborador ---");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Estoque");
            System.out.println("3. Matrículas");
            System.out.println("4. Ponto de Venda");
            System.out.println("5. Registrar Acesso");
            System.out.println("6. Interface Gráfica");
            System.out.println("7. Questões");
            System.out.println("8. Sair e Salvar");
            System.out.print("Escolha uma opção: ");
            
            String entrada = scanner.nextLine();
            int opcao;
            
             try {
                opcao = Integer.parseInt(entrada);  // converter para int
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Por favor, insira um número de 1 a 10.");
                continue;  // Recomeça o loop
            }

            switch (opcao) {
                case 1:
                    System.out.println("Opção 'Gerenciar Alunos' selecionada.");
                    // Chamar método para gerenciar alunos
                    GerenciarAlunos.gerenciarAlunos(scanner, academia, controllerAluno);
                    break;
                case 2:
                    System.out.println("Opção 'Gerenciar Estoque' selecionada.");
                    // Chamar método para gerenciar estoque
                    GerenciarEstoque.gerenciarEstoque(scanner, academia, controllerEstoque);
                    break;
                case 3:
                    System.out.println("Opção 'Matrículas' selecionada.");
                    // Chamar método para gerenciar matrículas
                    GerenciarMatriculas.gerenciarMatriculas(scanner, academia, controllerAgendamento, controllerAluno, controllerVenda);
                    break;
                case 4:
                    System.out.println("Opção 'Ponto de Venda' selecionada.");
                    // Chamar método para ponto de venda
                    GerenciarVenda.gerenciarVenda(scanner, controllerAluno, controllerVenda);
                    break;
                case 5:
                    System.out.println("Opção 'Registrar Acesso' selecionada.");
                    //Registra entradas e saidas
                    GerenciarAcesso.gerenciarAcesso(scanner, controllerCatraca, controllerAluno);
                    break;
                case 6:
                    System.out.println("Opção 'Interface Gráfica' selecionada.");
                    // Chamar método para configurar interface gráfica
                    //eveconfigurarInterfaceGrafica();
                    break;
                case 7:
                    System.out.println("Opção 'Questões' selecionada.");
                    // Chama método para imprimir questões
                    Questoes questoes = new Questoes(academia, controllerAluno, controllerFuncionario, controllerEstoque, controllerAgendamento, controllerCatraca);
                    questoes.imprimirQuestoes();
                case 8:
                    System.out.println("Salvar e Sair");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        System.out.println("Sistema encerrado.");
    }
}
