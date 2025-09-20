package Controller;

import Comparator.ComparatorString;
import Model.Academia;
import Model.Funcionario;

public class LoginController {
    /**
     * Instancia da academia
     */
    Academia academia;
    
    /**
     * Comparador
     */
    ComparatorString comparadorFuncionario;
    
    /**
     * Construtor do controller de login
     * @param academia 
     */
    public LoginController(Academia academia){
        this.academia = academia;
        this.comparadorFuncionario = new ComparatorString();
    }
    
    /**
     * Método que verifica se o usuário existe no banco de dados e permite ou não o acesso ao menu principal
     * @param email
     * @param senha
     * @return 1/Administrador 0/Colaborador -1/Usuário Inválido
     */
    public int efetuarLogin(String email, String senha){        
        for(Funcionario f : academia.getListaFuncionarios()){
            int emailAutenticado = comparadorFuncionario.compare(email, f.getEmail());
            int senhaAutenticada = comparadorFuncionario.compare(senha, f.getSenha());
            
            if (emailAutenticado == 0 && senhaAutenticada == 0){
                if(f.getCargo().equals("Administrador")){
                    return 1;
                } else{
                    return 0;
                }
            }
        }
        return -1;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Classe de Login";
    }
}
