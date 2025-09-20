package Menu;

import Controller.GerenciarFinancaController;
import java.util.Scanner;

public class GerenciarFinancas {
    public static void gerenciarFinancas(Scanner scanner, GerenciarFinancaController controllerFinanca){
        System.out.println("Registrar RECEITAS e DESPESAS");
        System.out.println("Digite a categoria: ");
        String categoria = scanner.nextLine();
        
        System.out.println("Digite o valor: ");
        int valor = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Digite true para receita e false para despesa: ");
        boolean receita = scanner.nextBoolean();
        scanner.nextLine();
        
        controllerFinanca.adicionarLancamento(categoria, valor, receita);
    }
}
