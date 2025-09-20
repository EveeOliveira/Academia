package Controller;

import Comparator.ComparatorAlunoCpf;
import Model.Academia;
import Model.Aluno;
import Model.DAO.DAO;
import aplicacao.Sistema;
import java.util.Iterator;

public class GerenciarAlunoController {
    /**
     * Instancia da academia
     */
    private Academia academia;
    
    /**
     * Dao de aluno
     */
    private DAO alunoDAO;
    
    /**
     * Construtor de GerenciarAlunoController
     * @param academia 
     */
    public GerenciarAlunoController(Academia academia){
        this.academia = academia;
        this.alunoDAO = new DAO("src\\main\\java\\Model\\DAO\\Alunos.json", Aluno.class);
        academia.setListaAlunos(alunoDAO.carregar());
    }
    
    /**
     * Método que realiza o cadastro do Aluno.
     * @param aluno
     */
    public void cadastrarAluno(Aluno aluno){
        academia.getListaAlunos().add(aluno);
        Sistema.setQuantidadeAlunosPrivate(Sistema.getQuantidadeAlunosPrivate()+1);
        Sistema.setQuantidadeAlunosProtected(Sistema.getQuantidadeAlunosProtected()+1);        
    }
    
    /**
     * Método que remove aluno pelo cpf
     * @param cpf
     * @return tru para remoção bem sucedida e false para remoção falha
     */            
    public boolean removeAluno(String cpf){
        boolean remover = academia.getListaAlunos().removeIf(aluno -> aluno.getCpf().equals(cpf));
        if(remover == true){
            Sistema.setQuantidadeAlunosPrivate(Sistema.getQuantidadeAlunosPrivate()-1);
            Sistema.setQuantidadeAlunosProtected(Sistema.getQuantidadeAlunosProtected()-1);
            return remover;
        }
        return remover;    
    }
    
    /**
     * Método que edita o aluno
     * @param cpfAntigo
     * @param alunoAtualizado
     * @return
     */
    public boolean editarAluno(String cpfAntigo, Aluno alunoAtualizado){
        for (Aluno aluno : academia.getListaAlunos()) {
            if (aluno.getCpf().equals(cpfAntigo)) {
                aluno.setNome(alunoAtualizado.getNome());
                aluno.setSobrenome(alunoAtualizado.getSobrenome());
                aluno.setCpf(alunoAtualizado.getCpf());
                aluno.setEndereco(alunoAtualizado.getEndereco());
                aluno.setTelefone(alunoAtualizado.getTelefone());
                aluno.setEmail(alunoAtualizado.getEmail());
                aluno.setCartao(alunoAtualizado.getCartao());
                return true; // Retorna true se a edição foi bem-sucedida
            }
        }
        return false; // Retorna false se o aluno com o CPF não foi encontrado
    }
    
    /**
     * Método que busca o aluno pelo seu Cpf
     * @param cpf
     * @return Aluno
     */
    public Aluno buscarAluno(String cpf) {
        for (Aluno aluno : academia.getListaAlunos()) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno; // Retorna o aluno se o CPF for igual
            }
        }
        return null; // Retorna null se o aluno não for encontrado
    }
    
    /**
     * Implementação do find, método que busca alunos por cpf
     * @param cpf
     * @return 
     */
    public Aluno find(String cpf){
        Iterator<Aluno> iterator = academia.getListaAlunos().iterator();
        ComparatorAlunoCpf comparator = new ComparatorAlunoCpf();
        
        while(iterator.hasNext()){
            Aluno aux = iterator.next();
            
            if(comparator.compare(aux, new Aluno(cpf)) == 0){
                return aux;
            }
        }  
        return null;
    }
    
    /**
    * @return the alunoDAO
    */
    public DAO getAlunoDAO() {
        return alunoDAO;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Classe que gerencia aluno";
    }
}
