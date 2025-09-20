package Menu;

import Controller.GerenciarAlunoController;
import Model.Academia;
import Model.Aluno;
import java.util.Scanner;

public class GerenciarAlunos {
    public static void gerenciarAlunos(Scanner scanner, Academia academia, GerenciarAlunoController controller){
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu de Gerenciamento de Alunos ---");
            System.out.println("1. Ver alunos cadastrados");
            System.out.println("2. Adicionar novo aluno");
            System.out.println("3. Editar aluno");
            System.out.println("4. Remover aluno");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("LISTA DE ALUNOS CADASTRADOS");
                    System.out.println(academia.getListaAlunos());
                    break;
                case 2:
                    System.out.println("Digite os dados do novo aluno:");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Sobrenome: ");
                    String sobrenome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Cartão: ");
                    String cartao = scanner.nextLine();
                    
                    if(controller.buscarAluno(cpf) == null){
                        controller.cadastrarAluno(new Aluno(nome, sobrenome, cpf, endereco, telefone, email, cartao));
                        System.out.println("Aluno cadastrado com sucesso!");
                        break;
                    } else{
                        System.out.println("Aluno já existente!");
                    } 
                    break;
                case 3:
                    System.out.println("Qual o cpf do aluno que deseja editar?");
                    String cpfAntigo = scanner.nextLine();
                    
                    if(controller.buscarAluno(cpfAntigo) != null){
                        System.out.println("Digite os dados do aluno:");

                        System.out.print("Nome: ");
                        String nomeEditado = scanner.nextLine();

                        System.out.print("Sobrenome: ");
                        String sobrenomeEditado = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpfEditado = scanner.nextLine();

                        System.out.print("Endereço: ");
                        String enderecoEditado = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefoneEditado = scanner.nextLine();

                        System.out.print("Email: ");
                        String emailEditado = scanner.nextLine();

                        System.out.print("Cartão: ");
                        String cartaoEditado = scanner.nextLine();
                        
                        Aluno alunoAtualizado = new Aluno(nomeEditado, sobrenomeEditado, cpfEditado, enderecoEditado, telefoneEditado, emailEditado, cartaoEditado);
                        
                        if(controller.editarAluno(cpfAntigo, alunoAtualizado)){
                            System.out.println("Aluno editado com sucesso!");
                            System.out.println(alunoAtualizado);
                        } else{
                            System.out.println("Não foi possivel editar o aluno!");
                        }
                        break;
                    } else{
                        System.out.println("Aluno não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("Qual o cpf do aluno que deseja remover?");
                    String cpfRemover = scanner.nextLine();
                    if(controller.removeAluno(cpfRemover)){
                        System.out.println("Aluno removido com sucesso!");
                    } else{
                        System.out.println("Não foi possivel remover o aluno!");
                    }
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
