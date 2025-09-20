package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.UUID;

public abstract class Pessoa{
    private String nome;
    private String sobrenome;
    private String cpf;
    private String cpfAnonimizado;
    private String endereco;
    private String telefone;
    private String email;
    private String id;

    /**
     * Construtor padrão da classe Pessoa
     */
    public Pessoa() {
        this.nome = "Desconhecido";
        this.sobrenome = "Desconhecido";
        this.cpf = "Desconhecido";
        this.endereco = "Desconhecido";
        this.telefone = "Desconhecido";
        this.email = "Desconhecido";
        this.cpfAnonimizado = cpf;
        this.id = UUID.randomUUID().toString();
    }
    
    /**
     * Construtor da classe Pessoa
     * @param nome
     * @param sobrenome
     * @param cpf
     * @param endereco
     * @param telefone
     * @param email
     */
    public Pessoa(String nome, String sobrenome, String cpf, String endereco, String telefone, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpfAnonimizado = cpf;
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Construtor da classe Pessoa
     * @param cpf
     */
    public Pessoa(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    
    /**
     * @return the cpf Anonimizado
     */
    public String getCpfAnonimizado() {
        String cpfAnonimizado = "xxx" + getCpf().substring(4, 9) + "xxx";
        return cpfAnonimizado;
    }
    
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter do id
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * Setter do id
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
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
