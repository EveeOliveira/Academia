package Controller;

import Model.Academia;
import Model.DAO.DAO;
import Model.Funcionario;

public class GerenciarFuncionarioController {
    /**
     * Atributo da academia
     */
    private Academia academia;
    
    /**
     * Dao de funcionario
     */
    private DAO funcionarioDAO;
    
    /**
     * Construtor de GerenciarFuncionarioController
     * @param academia 
     */
    public GerenciarFuncionarioController(Academia academia){
        this.academia = academia;
        this.funcionarioDAO = new DAO("src\\main\\java\\Model\\DAO\\Funcionarios.json", Funcionario.class);
        academia.setListaFuncionarios(funcionarioDAO.carregar());
    }
    
    /**
     * Método que realiza o cadastro do Funcionário.
     * @param funcionario
     */
    public void cadastrarFuncionario(Funcionario funcionario){
        academia.getListaFuncionarios().add(funcionario);
    }
    
    /**
     * Método que remove funcionário pelo CPF
     * @param cpf
     * @return true para remoção bem-sucedida e false para remoção falha
     */
    public boolean removeFuncionario(String cpf){
        for (Funcionario funcionario : academia.getListaFuncionarios()) {
            if (funcionario.getCpf().equals(cpf)) {
                academia.getListaFuncionarios().remove(funcionario);
                return true; // Remoção bem-sucedida
            }
        }
        return false; // Funcionário não encontrado
    }
    
    /**
     * Método que edita o funcionário
     * @param cpfAntigo
     * @param funcionarioAtualizado
     * @return true se a edição foi bem-sucedida, false caso contrário
     */
    public boolean editarFuncionario(String cpfAntigo, Funcionario funcionarioAtualizado){
        for (Funcionario funcionario : academia.getListaFuncionarios()) {
            if (funcionario.getCpf().equals(cpfAntigo)) {
                funcionario.setCargo(funcionarioAtualizado.getCargo());
                funcionario.setSalario(funcionarioAtualizado.getSalario());
                funcionario.setNome(funcionarioAtualizado.getNome());
                funcionario.setSobrenome(funcionarioAtualizado.getSobrenome());
                funcionario.setCpf(funcionarioAtualizado.getCpf());
                funcionario.setEndereco(funcionarioAtualizado.getEndereco());
                funcionario.setTelefone(funcionarioAtualizado.getTelefone());
                funcionario.setEmail(funcionarioAtualizado.getEmail());
                return true; // Retorna true se a edição foi bem-sucedida
            }
        }
        return false; // Retorna false se o funcionário com o CPF não foi encontrado
    }
    
    /**
     * Método que busca o funcionário pelo seu CPF
     * @param cpf
     * @return Funcionário encontrado ou null se não existir
     */
    public Funcionario buscarFuncionario(String cpf) {
        for (Funcionario funcionario : academia.getListaFuncionarios()) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario; // Retorna o funcionário se o CPF for igual
            }
        }
        return null; // Retorna null se o funcionário não for encontrado
    }
    
    /**
     * @return the funcionarioDAO
     */
    public DAO getFuncionarioDAO() {
        return funcionarioDAO;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Classe que gerencia funcionário";
    }
}
