package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;

public class Lancamento {
    private String categoria;
    private double valor;
    private boolean receita;// true se for receita, false se for despesa

    /**
     * Construtor de um lançamento
     * @param categoria
     * @param valor
     * @param receita 
     */
    public Lancamento(String categoria, double valor, boolean receita) {
        this.categoria = categoria;
        this.valor = valor;
        this.receita = receita;
    }

    /**
     * Getter de ategoria
     * @return 
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Getter de valor
     * @return 
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método que retorna se é receita ou não
     * @return 
     */
    public boolean isReceita() {
        return receita;
    }
    
    /**
     * Método adaptado para escrever variáveis do tipo LocalDateTime
     * @param jsonWriter
     * @param localDateTime
     * @throws IOException 
     */
    private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()) // Usando a classe externa
        .setPrettyPrinting() // Para formatação bonita do JSON
        .create();
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString() {
        return gson.toJson(this); // Converte a instância em JSON
    }
}
