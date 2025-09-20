package Menu;

import Controller.CatracaController;
import Controller.GerenciarAlunoController;
import Model.Aluno;
import java.util.Scanner;

public class GerenciarAcesso {
    public static void gerenciarAcesso(Scanner scanner, CatracaController controllerCatraca, GerenciarAlunoController controllerAluno) {

        System.out.println("Digite o cpf do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = controllerAluno.buscarAluno(cpf);

        if (aluno == null) {
            System.out.println("Aluno não cadastrado no sistema");
            return;
        }

        int acessos = controllerCatraca.auxiliarAcesso(cpf);

        if (acessos == 0) {
            controllerCatraca.registrarEntrada(aluno);
            System.out.println(aluno.getNome() + " entrou na academia!");
            return;
        }

        if (acessos % 2 == 0) {
            controllerCatraca.registrarEntrada(aluno);
            System.out.println(aluno.getNome() + " entrou na academia!");
            return;
        } else {
            controllerCatraca.registrarSaida(aluno);
            System.out.println(aluno.getNome() + " saiu da academia!");
            return;
        }
    }
}
