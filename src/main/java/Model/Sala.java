package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Sala {
    /**
     * Tipo de aula que será ministrada a aula
     */
    private String tipo;
    
    /**
     * Capacidade total da sala
     */
    private int capacidade;

    /**
     * Construtor de uma sala
     * @param tipo
     * @param capacidade 
     */
    public Sala(String tipo, int capacidade) {
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
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
