package Controller;

import Model.Academia;
import Model.DAO.DAO;
import Model.Produto;
import aplicacao.Sistema;
import java.util.ArrayList;

public class GerenciarEstoqueController {
    /**
     * Atributo que contém a lista de produtos.
     */
    private Academia academia;
    
    /**
     * Dao de estoque
     */
    private DAO estoqueDAO;

    /**
     * Construtor de GerenciarEstoqueController
     * @param academia
     */
    public GerenciarEstoqueController(Academia academia) {
        this.academia = academia;
        this.estoqueDAO = new DAO("src\\main\\java\\Model\\DAO\\Estoque.json", Produto.class);
        academia.setEstoque(estoqueDAO.carregar());
    }

    /**
     * Método que adiciona um produto ao estoque.
     * @param produto O produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        academia.getEstoque().add(produto);
        Sistema.setQuantidadeProdutos(Sistema.getQuantidadeProdutos() + 1);
        academia.getCaixa().setSaldo(academia.getCaixa().getSaldo() - (produto.getValorCompra()* produto.getQuantidade()));
    }

    /**
     * Método que remove um produto pelo nome
     * @param nome 
     * @return true se a remoção foi bem-sucedida, false caso contrário.
     */
    public boolean removerProduto(String nome) { 
        boolean remover = academia.getEstoque().removeIf(produto -> produto.getNome().equals(nome));
        if(remover == true){
            Sistema.setQuantidadeProdutos(Sistema.getQuantidadeProdutos() - 1); // Decrementa a quantidade de produtos
            return remover;
        }
        return remover;
    }

    /**
     * Método que edita um produto existente.
     * @param nome 
     * @param produtoAtualizado O produto com as novas informações.
     * @return true se a edição foi bem-sucedida, false caso contrário.
     */
    public boolean editarProduto(String nome, Produto produtoAtualizado) {
        for (int i = 0; i < academia.getEstoque().size(); i++) {
            if (academia.getEstoque().get(i).getNome().equals(nome)) {
                academia.getEstoque().set(i, produtoAtualizado);
                return true; // Retorna true se a edição foi bem-sucedida
            }
        }
        return false; // Retorna false se o produto com o nome não foi encontrado
    }

    /**
     * Método que busca um produto pelo seu nome
     * @param nome
     * @return O produto correspondente ou null se não encontrado.
     */
    public Produto buscarProduto(String nome) {
        for (Produto produto : academia.getEstoque()) {
            if (produto.getNome().equals(nome)) {
                return produto; // Retorna o produto se o nome for igual
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

    /**
     * Método que retorna a lista de produtos.
     * @return A lista de produtos.
     */
    public ArrayList getListaProdutos() {
        return academia.getEstoque();
    }
    
    /**
     * @return the estoqueDAO
     */
    public DAO getEstoqueDAO() {
        return estoqueDAO;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Classe que gerencia estoque";
    }
}
