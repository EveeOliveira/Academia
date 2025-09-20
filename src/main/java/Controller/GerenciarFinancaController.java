package Controller;

import Model.Academia;
import Model.Caixa;
import Model.DAO.DAO;
import Model.Lancamento;

public class GerenciarFinancaController {
    /**
     * Instancia da academia
     */
    private Academia academia;
    
    /**
     * Instancia do DAO de lancamentos
     */
    private DAO lancamentoDAO;
    
    /**
     * Instancia do DAO do caixa da academia
     */
    private DAO caixaDAO;

    /**
     * Construtor do controller de gerenciamento de finanças
     * @param academia 
     */
    public GerenciarFinancaController(Academia academia) {
        this.academia = academia;
        this.lancamentoDAO = new DAO("src\\main\\java\\Model\\DAO\\Lancamentos.json", Lancamento.class);
        academia.setLancamentos(lancamentoDAO.carregar());
        this.caixaDAO = new DAO("src\\main\\java\\Model\\DAO\\Caixa.json", Caixa.class);
        academia.setCaixa((Caixa) caixaDAO.carregar(Caixa.class));
    }
    
    /**
     * Método para adicionar receita ou despesa
     * @param categoria
     * @param valor
     * @param receita 
     */
    public void adicionarLancamento(String categoria, double valor, boolean receita) {
        Lancamento lancamento = new Lancamento(categoria, valor, receita);
        adicionarLancamento(lancamento);
        imprimirLancamento(lancamento);
    }
    
    /**
     * Método que imprime os lançamentos
     * @param lancamento 
     */
    private void imprimirLancamento(Lancamento lancamento){
        System.out.println("Saldo: " + academia.getCaixa().getSaldo());
        System.out.println("Lançamento realizado: " + lancamento);
    }

    /**
     * @return the financaDAO
     */
    public DAO getLancamentoDAO() {
        return lancamentoDAO;
    }
    
    /**
     * Método que adiciona o lançamento no arraylist de lançamentos
     * @param lancamento 
     */
    public void adicionarLancamento(Lancamento lancamento) {
        academia.getLancamentos().add(lancamento);
        atualizarSaldo(lancamento);
    }

    /**
     * Método que atualiza o saldo
     * @param lancamento 
     */
    private void atualizarSaldo(Lancamento lancamento) {
        double saldo = academia.getCaixa().getSaldo();
        if (lancamento.isReceita()) {
            academia.getCaixa().setSaldo(saldo += lancamento.getValor());
        } else {
            academia.getCaixa().setSaldo(saldo -= lancamento.getValor());
        }
    }

    /**
     * @return the caixaDAO
     */
    public DAO getCaixaDAO() {
        return caixaDAO;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Controller de finanças";
    }
}
