package Menu;

import Controller.GerenciarFuncionarioController;
import Model.Academia;
import Model.Funcionario;
import java.util.Scanner;

public class GerenciarFuncionarios {
    public static void gerenciarFuncionarios(Scanner scanner, Academia academia, GerenciarFuncionarioController controller){
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu de Gerenciamento de Funcionários ---");
            System.out.println("1. Ver funcionários cadastrados");
            System.out.println("2. Adicionar novo funcionário");
            System.out.println("3. Editar funcionário");
            System.out.println("4. Remover funcionário");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("LISTA DE FUNCIONÁRIOS CADASTRADOS");
                    System.out.println(academia.getListaFuncionarios());
                    break;
                case 2:
                    System.out.println("Digite os dados do novo funcionário:");

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
                    
                    System.out.print("Usuário: ");
                    String usuario = scanner.nextLine();
                    
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    
                    System.out.print("Salario: ");
                    float salario = scanner.nextFloat();
                    
                    if(controller.buscarFuncionario(cpf) == null){
                        controller.cadastrarFuncionario(new Funcionario(cargo, salario, usuario, senha, nome, sobrenome, cpf, endereco, telefone, email));
                        System.out.println("Funcionário cadastrado com sucesso!");
                    } else{
                        System.out.println("Funcionário já existente!");
                    } 
                    break;
                case 3:
                    System.out.println("Qual o CPF do funcionário que deseja editar?");
                    String cpfAntigo = scanner.nextLine();
                    
                    if(controller.buscarFuncionario(cpfAntigo) != null){
                        System.out.println("Digite os novos dados do funcionário:");

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
                        
                        System.out.print("Usuário: ");
                        String usuarioEditado = scanner.nextLine();

                        System.out.print("Senha: ");
                        String senhaEditado = scanner.nextLine();

                        System.out.print("Cargo: ");
                        String cargoEditado = scanner.nextLine();
                        
                        System.out.print("Salario: ");
                        float salarioEditado = scanner.nextFloat();
                        
                        Funcionario funcionarioAtualizado = new Funcionario(cargoEditado, salarioEditado, usuarioEditado, senhaEditado, nomeEditado, sobrenomeEditado, cpfEditado, enderecoEditado, telefoneEditado, emailEditado);
                        
                        if(controller.editarFuncionario(cpfAntigo, funcionarioAtualizado)){
                            System.out.println("Funcionário editado com sucesso!");
                            System.out.println(controller.buscarFuncionario(funcionarioAtualizado.getCpf()));
                        } else{
                            System.out.println("Não foi possível editar o funcionário!");
                        }
                    } else {
                        System.out.println("Funcionário não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("Qual o CPF do funcionário que deseja remover?");
                    String cpfRemover = scanner.nextLine();
                    if(controller.removeFuncionario(cpfRemover)){
                        System.out.println("Funcionário removido com sucesso!");
                    } else{
                        System.out.println("Não foi possível remover o funcionário!");
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
