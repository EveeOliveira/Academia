package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Aluno extends Pessoa{
    private String cartao;

    /**
     * Construtor da classe Aluno
     * @param nome
     * @param sobrenome
     * @param cpf
     * @param endereco
     * @param telefone
     * @param email
     * @param cartao 
     */
    public Aluno(String nome, String sobrenome, String cpf, String endereco, String telefone, String email, String cartao) {
        super(nome, sobrenome, cpf, endereco, telefone, email);
        this.cartao = cartao;
    }
    
    /**
     * Construtor alternativo para aluno
     * @param cpf 
     */
    public Aluno(String cpf){
        super(cpf);
    }

    /**
     * Get cartão
     * @return cartao
     */
    public String getCartao() {
        return cartao;
    }

    /**
     * Set cartão
     * @param cartao 
     */
    public void setCartao(String cartao) {
        this.cartao = cartao;
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
