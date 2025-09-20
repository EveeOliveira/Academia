package Model;

import java.util.ArrayList;

public class Academia{

    private ArrayList<Funcionario> listaDeFuncionarios;
    private ArrayList<Aluno> listaDeAlunos;
    private ArrayList<Produto> estoque;
    private ArrayList<Agendamento> matriculasAgendadas;
    private ArrayList<RegistroDeAcesso> catraca;
    private ArrayList<Venda> vendas;
    private Caixa caixa;
    private ArrayList<Lancamento> lancamentos;

    /**
     * Get lista de funcionários
     * @return lista de funcionários
     */
    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaDeFuncionarios;
    }

    /**
     * Set lista de funcionários
     * @param listaFuncionario array list de funcionarios 
     */
    public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionario) {
        this.listaDeFuncionarios = listaFuncionario;
    }

    /**
     * Get lista de Alunos
     * @return listaDeAlunos
     */
    public ArrayList<Aluno> getListaAlunos() {
        return listaDeAlunos;
    }

    /**
     * Set lista de alunos
     * @param listaDeAlunos arraylist de alunos
     */
    public void setListaAlunos(ArrayList<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
    
    /**
     * Getter de estoque
     * @return the estoque
     */
    public ArrayList<Produto> getEstoque() {
        return estoque;
    }
    
    /**
     * Set Estoque
     * @param listaDeProdutos arraylist de produtos
     */
    public void setEstoque (ArrayList<Produto> listaDeProdutos){
        this.estoque = listaDeProdutos;
    }
        
    /**
     * Getter de matriculas agendadas
     * @return the matriculasAgendadas
     */
    public ArrayList<Agendamento> getMatriculasAgendadas() {
        return matriculasAgendadas;
    }

    /**
     * @param matriculasAgendadas the matriculasAgendadas to set
     */
    public void setMatriculasAgendadas(ArrayList<Agendamento> matriculasAgendadas) {
        this.matriculasAgendadas = matriculasAgendadas;
    }
    
    /**
     * Getter de catraca
     * @return the catraca
     */
    public ArrayList<RegistroDeAcesso> getCatraca() {
        return catraca;
    }
      
    /**
     * Setter de catraca
     * @param catraca the catraca to set
     */
    public void setCatraca(ArrayList<RegistroDeAcesso> catraca) {
        this.catraca = catraca;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Abstração de uma Academia";
    }

    /**
     * Getter de Vendas
     * @return the vendas
     */
    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    /**
     * Setter de vendas
     * @param vendas the vendas to set
     */
    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }

    /**
     * Getter do caixa
     * @return the caixa
     */
    public Caixa getCaixa() {
        return caixa;
    }
    
    /**
     * Get lançamento
     * @return lançamento
     */
    public ArrayList<Lancamento> getLancamentos() {
        return lancamentos;
    }

    /**
     * Set lançamento
     * @param lancamentos the lancamentos to set
     */
    public void setLancamentos(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    /**
     * Set caixa
     * @param caixa the caixa to set
     */
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
}