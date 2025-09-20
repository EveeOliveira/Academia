package Controller;

import Model.Academia;
import Model.Aluno;
import Model.DAO.DAO;
import Model.Produto;
import Model.Venda;

public class GerenciarVendaController {
    /**
     * Instancia da academia
     */
    private Academia academia;
    
    /**
     * Instancia do DAO de vendas
     */
    private DAO vendasDAO;
    
    /**
     * Construtor do controller de gerenciamento de vendas
     * @param academia 
     */
    public GerenciarVendaController(Academia academia) {
        this.academia = academia;
        this.vendasDAO = new DAO("src\\main\\java\\Model\\DAO\\RelatorioDeVendas.json", Venda.class);    
        academia.setVendas(vendasDAO.carregar());
    }

    /**
     * Método para realizar uma venda de um produto
     * @param nomeProduto
     * @param quantidade
     * @param aluno
     * @return 
     */
    public boolean realizarVenda(String nomeProduto, int quantidade, Aluno aluno) {
        Produto produto = buscarProduto(nomeProduto);
        if (produto != null && produto.getQuantidade() >= quantidade) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
            Venda venda = new Venda(produto, quantidade, aluno);
            academia.getVendas().add(venda);
            gerarExtrato(venda);
            return true;
        } else {
            System.out.println("Estoque insuficiente ou produto não encontrado.");
            return false;
        }
    }

    /**
     * Método auxiliar para buscar produto no estoque
     * @param nomeProduto
     * @return 
     */
    private Produto buscarProduto(String nomeProduto) {
        for (Produto produto : academia.getEstoque()) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }
    
    /**
     * Exibe todas as vendas realizadas
     */
    public void exibirVendas() {
        for (Venda item : academia.getVendas()) {
            System.out.println("Produto: " + item.getProduto().getNome() +
                               ", Quantidade: " + item.getQuantidade() +
                               ", Total: " + (item.getQuantidade() * item.getProduto().getValorVenda()));
        }
    }
  
    /**
     * @return the vendasDAO
     */
    public DAO getVendasDAO() {
        return vendasDAO;
    }
    
    /**
     * Método que gera o extrato de venda de matrículas 
     * @param venda
     */
    public void gerarExtrato(Venda venda){
        System.out.println("---------------------------- EXTRATO ----------------------------");
        System.out.println();
        
        System.out.println("Nome: " + venda.getAluno().getNome());
        System.out.println("CPF: " + venda.getAluno().getCpf());
        System.out.println(venda.getProduto());
        System.out.println("Quantidade: " + venda.getQuantidade());
        System.out.println("Valor total: " + venda.getValorTotal());
        
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        
        
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Classe que gerencia vendas";
    }
}
