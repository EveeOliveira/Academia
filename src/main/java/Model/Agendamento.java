package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;
import java.util.UUID;

public class Agendamento {
    private String id;
    private String tipoAula;
    private String tipoMatricula;
    private String status;
    private Aluno aluno;
    private float valor;
    private String instrutor;
    private LocalDateTime dataAula;
    private LocalDateTime dataAgendamento;
    
    /**
     * Construtor de agendamento
     * @param tipoAula
     * @param tipoMatricula
     * @param status
     * @param aluno
     * @param valor
     * @param instrutor
     * @param dataAula 
     */
    public Agendamento(String tipoAula, String tipoMatricula, String status, Aluno aluno, float valor, String instrutor, LocalDateTime dataAula){
        this.id = UUID.randomUUID().toString();
        this.tipoAula = tipoAula;
        this.tipoMatricula = tipoMatricula;
        this.status = status;
        this.aluno = aluno;
        this.valor = valor;
        this.instrutor = instrutor;
        this.dataAula = dataAula;
        this.dataAgendamento = LocalDateTime.now();
    }
    
    /**
     * @return the tipoAula
     */
    public String getTipoAula() {
        return tipoAula;
    }

    /**
     * @return the tipoMatricula
     */
    public String getTipoMatricula() {
        return tipoMatricula;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @return the dataAula
     */
    public LocalDateTime getDataAula() {
        return dataAula;
    }

    /**
     * @return the dataAgendamento
     */
    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
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


