package Menu;

import Controller.GerenciarEstoqueController;
import Model.Academia;
import Model.Produto;
import java.util.Scanner;

public class GerenciarEstoque {
    public static void gerenciarEstoque(Scanner scanner, Academia academia, GerenciarEstoqueController controller) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu de Gerenciamento de Estoque ---");
            System.out.println("1. Ver produtos no estoque");
            System.out.println("2. Adicionar novo produto");
            System.out.println("3. Editar produto");
            System.out.println("4. Remover produto");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("LISTA DE PRODUTOS NO ESTOQUE");
                    System.out.println(academia.getEstoque());
                    break;
                case 2:
                    System.out.println("Digite os dados do novo produto:");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Valor de Compra: ");
                    float valorCompra = scanner.nextFloat();

                    System.out.print("Valor de Venda: ");
                    float valorVenda = scanner.nextFloat();
                    
                    if (controller.buscarProduto(nome) == null) {
                        Produto novoProduto = new Produto(nome, descricao, quantidade, valorCompra, valorVenda);
                        controller.adicionarProduto(novoProduto);
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Esse produto já existente!");
                    }
                    break;
                case 3:
                    System.out.println("Qual o nome do produto que deseja editar?");
                    String nomeAntigo = scanner.nextLine();
                    
                    if (controller.buscarProduto(nomeAntigo) != null) {
                        System.out.println("Digite os novos dados do produto:");

                        System.out.print("Nome: ");
                        String nomeEditado = scanner.nextLine();

                        System.out.print("Descrição: ");
                        String descricaoEditada = scanner.nextLine();

                        System.out.print("Quantidade: ");
                        int quantidadeEditada = scanner.nextInt();

                        System.out.print("Valor de Compra: ");
                        float valorCompraEditada = scanner.nextFloat();

                        System.out.print("Valor de Venda: ");
                        float valorVendaEditada = scanner.nextFloat();

                        Produto produtoAtualizado = new Produto(nomeEditado, descricaoEditada, quantidadeEditada, valorCompraEditada, valorVendaEditada);
                        
                        if (controller.editarProduto(nomeAntigo, produtoAtualizado)) {
                            System.out.println("Produto editado com sucesso!");
                            System.out.println(controller.buscarProduto(produtoAtualizado.getNome()));
                        } else {
                            System.out.println("Não foi possível editar o produto!");
                        }
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("Qual o nome do produto que deseja remover?");
                    String nomeRemover = scanner.nextLine();
                    if (controller.removerProduto(nomeRemover)) {
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Não foi possível remover o produto!");
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
