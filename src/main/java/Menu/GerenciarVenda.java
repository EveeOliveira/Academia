package Menu;

import Controller.GerenciarAlunoController;
import Controller.GerenciarVendaController;
import Model.Aluno;
import java.util.Scanner;

public class GerenciarVenda {
    public static void gerenciarVenda(Scanner scanner, GerenciarAlunoController controllerAluno, GerenciarVendaController controllerVenda) {

        System.out.println("Digite o cpf do aluno: ");
        String cpf = scanner.nextLine();
        
        Aluno aluno = controllerAluno.buscarAluno(cpf);

        if (aluno == null) {
            System.out.println("Aluno não cadastrado no sistema");
            return;
        }
        
        System.out.println("Digite o nome do produto: ");
        String produto = scanner.nextLine();
        
        System.out.println("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        controllerVenda.realizarVenda(produto, quantidade, aluno);
    }
}
