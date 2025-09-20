package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;

public class RegistroDeAcesso {
    /**
     * Aluno que realizou o acesso
     */
    private Aluno aluno;
    
    /**
     * Horario do acesso
     */
    private LocalDateTime dataHora;
    
    /**
     * Se foi um entrada ou saída
     */
    private String tipo;
    
    /**
     * Construtor de um registro de acesso
     * @param aluno
     * @param dataHora
     * @param tipo 
     */
    public RegistroDeAcesso(Aluno aluno, LocalDateTime dataHora, String tipo) {
        this.aluno = aluno;
        this.dataHora = dataHora;
        this.tipo = tipo;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Método que faz o tratamento da variável do tipo LocalDateTime
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
