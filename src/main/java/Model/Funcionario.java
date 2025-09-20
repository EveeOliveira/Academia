package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Funcionario extends Usuario {
    private String cargo;
    private float salario;


    /**
     * Constutor padrão da classe Funcionário
     */
    public Funcionario() {
        super();
        this.cargo = "Desconhecido";
        this.salario = 0;
    }
    
    /**
     * Constutor padrão da classe Funcionário
     */
    public Funcionario(String email) {
        super(email);
        this.cargo = "Desconhecido";
        this.salario = 0;
    }
    
    /**
     * Construtor da classe Funcionário
     * @param cargo 
     * @param salario 
     */
    public Funcionario(String cargo, float salario) {
        super();
        this.cargo = cargo;
        this.salario = salario;
    }

    /**
     * Construtor da classe Funcionário
     * @param cargo
     * @param salario
     * @param usuario
     * @param senha
     * @param nome
     * @param sobrenome
     * @param cpf
     * @param endereco
     * @param telefone
     * @param email 
     */
    public Funcionario(String cargo, float salario, String usuario, String senha, String nome, String sobrenome, String cpf, String endereco, String telefone, String email) {
        super(usuario, senha, nome, sobrenome, cpf, endereco, telefone, email);
        this.cargo = cargo;
        this.salario = salario;
    }

    /**
     * Contrutor da classe Funcionário que auxiliar do login
     * @param email
     * @param usuario
     * @param senha 
     */
    public Funcionario(String email, String usuario, String senha){
        super(email, usuario, senha);
    }

    /**
     * Get salário
     * @return salário
     */
    public float getSalario() {
        return salario;
    }

    /**
     * Set salário
     * @param salario 
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    /**
     * Sobrescrita do toString
     * @return Funcionário formatado no modelo JSON
     */
    @Override
    public String toString(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
    
}
