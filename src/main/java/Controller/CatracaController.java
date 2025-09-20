package Controller;

import Model.Academia;
import Model.Aluno;
import Model.DAO.DAO;
import Model.RegistroDeAcesso;
import java.time.LocalDateTime;

public class CatracaController {
    /**
     * Instancia da academia
     */
    private Academia academia;
    
    /**
     * Instancia do DAO de catraca
     */
    private DAO catracaDAO;
    
    /**
     * Contrutor do controller da catraca
     * @param academia intancia da academia
     */
    public CatracaController(Academia academia){
        this.academia = academia;
        this.catracaDAO = new DAO("src\\main\\java\\Model\\DAO\\Catraca.json", RegistroDeAcesso.class);
        academia.setCatraca(catracaDAO.carregar());
    }
    
    /**
     * Método que registra a entrada do aluno na academia
     * @param aluno instancia de aluno
     */
    public void registrarEntrada(Aluno aluno){
        RegistroDeAcesso entrada = new RegistroDeAcesso(aluno, LocalDateTime.now(), "Entrada");
        academia.getCatraca().add(entrada);
    }
    
    /**
     * Método que registra a saida do aluno na academia
     * @param aluno instancia de aluno
     */
    public void registrarSaida(Aluno aluno){
        RegistroDeAcesso saida = new RegistroDeAcesso(aluno, LocalDateTime.now(), "Saída");
        academia.getCatraca().add(saida);
    }

    /**
     * Método que buca os acessos a catraca pelo cpf do aluno
     * @param cpf identificador de aluno
     * @return registro de acesso
     */
    public RegistroDeAcesso buscarAcesso(String cpf){
        for(RegistroDeAcesso registro : academia.getCatraca()){
            if(registro.getAluno().getCpf().equals(cpf)){
                return registro;
            }
        }
        return null;
    }
    
    /**
     * Método auxilixar que conta a quantidade de acesso por cpf
     * @param cpf
     * @return valor da quantidade de acessos por aluno
     */
    public int auxiliarAcesso(String cpf){
        int acessos = 0;
        for(RegistroDeAcesso registro : academia.getCatraca()){
            if(registro.getAluno().getCpf().equals(cpf)){
                acessos++;
            }
        }
        return acessos;
    }
    
    /**
     * @return the catracaDAO
    */
    public DAO getCatracaDAO() {
        return catracaDAO;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Abstração de uma Catraca";
    } 
}
