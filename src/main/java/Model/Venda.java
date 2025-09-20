package Model;

public class Venda {
    /**
     * Produto vendido
     */
    private Produto produto;   // Produto vendido
    
    /**
     * Quantidade do produto vendido
     */
    private int quantidade;    // Quantidade vendida
    
    /**
     * Valot total da compra
     */
    private double valorTotal; // Valor total da venda
    
    /**
     * Aluno que realizou a compra
     */
    private Aluno aluno;

    /**
     * Construtor que calcula o valor total com base no preço do produto e quantidade
     * @param produto
     * @param quantidade 
     */
    public Venda(Produto produto, int quantidade, Aluno aluno) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getValorVenda()* quantidade;
        this.aluno = aluno;
    }

    /**
     * Getters
     * @return 
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Getter de Quantidade
     * @return 
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Getter do valorTotal
     * @return 
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Retorna item no formato Json
     * @return 
     */
    @Override
    public String toString() {
        return "Produto: " + produto.getNome() +
               ", Quantidade: " + quantidade +
               ", Valor Total: R$" + valorTotal +
               ", Aluno: " + getAluno();
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }
}
