package Menu;

import Controller.AgendamentoController;
import Controller.GerenciarAlunoController;
import Controller.GerenciarVendaController;
import Model.Academia;
import Model.Aluno;
import java.time.LocalDateTime;
import java.util.Scanner;

public class GerenciarMatriculas {
    public static void gerenciarMatriculas(Scanner scanner, Academia academia, AgendamentoController controller, GerenciarAlunoController controllerAluno, GerenciarVendaController controllerVenda) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu de Gerenciamento de Matrículas ---");
            System.out.println("1. Ver matrículas agendadas");
            System.out.println("2. Verificar vaga");
            System.out.println("3. Adicionar nova matrícula");
            System.out.println("4. Buscar matriculas do aluno");
            System.out.println("5. Confirmar matricula");
            System.out.println("6. Cancelar matricula");
            System.out.println("7. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("LISTA DE MATRÍCULAS AGENDADAS");
                    System.out.println(academia.getMatriculasAgendadas());
                    break;
                case 2:
                    System.out.println("Verificar disponibilidade de vaga:");

                    System.out.print("Tipo de Aula: ");
                    String tipoAulaVerificar = scanner.nextLine();

                    LocalDateTime dataAulaVerificar = controller.solicitarData("aula", scanner);

                    if (controller.verificarVaga(dataAulaVerificar, tipoAulaVerificar)) {
                        System.out.println("Há vagas disponíveis para a aula de " + tipoAulaVerificar + " na data e horário especificados.");
                    } else {
                        System.out.println("Não há vagas disponíveis para a aula de " + tipoAulaVerificar + " na data e horário especificados.");
                    }
                    break;
                case 3:
                    System.out.println("Digite os dados da nova matrícula:");

                    System.out.print("Tipo de Aula: ");
                    String tipoAula = scanner.nextLine();

                    System.out.print("Tipo de Matrícula: ");
                    String tipoMatricula = scanner.nextLine();

                    System.out.print("CPF do Aluno: ");
                    String cpfAluno = scanner.nextLine();
                    Aluno aluno = controllerAluno.buscarAluno(cpfAluno);

                    if (aluno == null) {
                        System.out.println("Aluno não encontrado. Matrícula não pode ser realizada.");
                        break;
                    }

                    System.out.print("Valor: ");
                    float valor = scanner.nextFloat();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.print("Instrutor: ");
                    String instrutor = scanner.nextLine();

                    // Solicitar a data da aula
                    LocalDateTime dataAula = controller.solicitarData("aula", scanner);

                    // Verificar vaga antes de agendar
                    if (controller.verificarVaga(dataAula, tipoAula)) {
                        controller.novoAgendamento(tipoAula, tipoMatricula, aluno, valor, instrutor, dataAula);
                        System.out.println("Matrícula agendada com sucesso!");
                    } else {
                        System.out.println("Não há vagas disponíveis para essa aula no horário especificado.");
                    }
                    break;
                case 4:
                    System.out.println("Qual o CPF do aluno para o qual deseja buscar a matrícula?");
                    String cpfMatriculas = scanner.nextLine();
                    
                    System.out.println("Qual aula deseja buscar?");
                    String tipoAulaBusca = scanner.nextLine();
                    
                    System.out.println(controller.buscarAgendamentos(cpfMatriculas, tipoAulaBusca));
                    break;
                case 5:
                    System.out.println("Digite o nome do aluno que deseja confimar a matricula: ");
                    String nomeConfirmar = scanner.nextLine();
                    
                    System.out.println("Qual é o cpf do aluno: ");
                    String cpfConfirmar = scanner.nextLine();
                    
                    System.out.println("Qual é a aula matriculada: ");
                    String aulaConfirmar = scanner.nextLine();
                                       
                    LocalDateTime dataConfirmar = controller.solicitarData(aulaConfirmar, scanner);
                    
                    if (controller.confirmarAgendamento(nomeConfirmar, aulaConfirmar, dataConfirmar) == true){
                        Aluno alunoConfirmado = controllerAluno.buscarAluno(cpfConfirmar);
                        if (controller.buscarAgendamentos(cpfConfirmar, aulaConfirmar).getTipoMatricula().equals("Mensal")){
                            controllerVenda.realizarVenda(aulaConfirmar, 30, alunoConfirmado);
                            break;
                        }else{
                            controllerVenda.realizarVenda(aulaConfirmar, 1, alunoConfirmado);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do aluno que deseja cancelar a matricula: ");
                    String nomeCancelar = scanner.nextLine();
                    
                    System.out.println("Qual é a aula matriculada: ");
                    String aulaCancelar = scanner.nextLine();
                    
                    LocalDateTime dataCancelar = controller.solicitarData(aulaCancelar, scanner);
                    
                    controller.cancelarAgendamento(nomeCancelar, aulaCancelar, dataCancelar);
                    break;
                case 7:
                    System.out.println("Voltando ao menu principal...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
