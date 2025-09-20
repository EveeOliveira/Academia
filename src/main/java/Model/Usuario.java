package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class Usuario extends Pessoa {
    private String usuario;
    private String senha;

    /**
     * Construtor padrão da classe Usuário
     */
    public Usuario() {
        super();
        this.usuario = "Desconhecido";
        this.senha = "Desconhecido";
    }
    
    /**
     * Construtor padrão da classe Usuário
     * @param email
     */
    public Usuario(String email) {
        super(email);
        this.usuario = "Desconhecido";
        this.senha = "Desconhecido";
    }
    
    /**
     * Construtor da classe Usuário
     * @param usuario
     * @param senha
     * @param nome
     * @param sobrenome
     * @param cpf
     * @param endereco
     * @param telefone
     * @param email 
     * @param id 
     */
    public Usuario(String usuario, String senha, String nome, String sobrenome, String cpf, String endereco, String telefone, String email) {
        super(nome, sobrenome, cpf, endereco, telefone, email);
        this.usuario = usuario;
        this.senha = senha;
    }
    
    /**
     * Construtor da classe Usuário, auxiliar no login
     * @param email
     * @param usuario
     * @param senha 
     */
    public Usuario(String email, String usuario, String senha) {
        super(email);
        this.usuario = "Desconhecido";
        this.senha = senha;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param login the usuarios to set
     */
    public void setUsuario(String login) {
        this.usuario = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
