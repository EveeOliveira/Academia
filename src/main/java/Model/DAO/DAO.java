package Model.DAO;

import Model.Agendamento;
import Model.LocalDateTimeAdapter;
import Model.RegistroDeAcesso;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAO<T> {
    /**
     * Instancia do arquivo
     */
    private final String arquivo;
    
    /**
     * Instancia de uma list generia
     */
    private final Type listaGenerica;
    
    /**
     * Instancia do Gson, variável que vai possibilitar deixar o json agradável.
     */
    private final Gson gson;

    /**
     * Construtor do DAO
     */
    public DAO(String arquivo, Class<T> classe) {
        this.arquivo = arquivo;
        this.listaGenerica = TypeToken.getParameterized(List.class, classe).getType();

        // Verifica se a classe é Agendamento para registrar o TypeAdapter específico
        if (classe == Agendamento.class || classe == RegistroDeAcesso.class) {
            this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
        } else {
            this.gson = new GsonBuilder().setPrettyPrinting().create();
        }
    }

    /**
     * Método auxiliar para carregar os dados do JSON para o ArrayList
     * @return lista
     */
    public ArrayList<T> carregar() {
        try (FileReader reader = new FileReader(arquivo)) {
            return gson.fromJson(reader, listaGenerica);
        } catch (IOException e) {
            return new ArrayList<>(); // Retorna lista vazia se houver erro
        }
    }
    
    /**
     * Método auxiliar para carregar os dados do JSON para o ArrayList
     * @param typeOfT
     * @return lista
     */
    public T carregar(Type typeOfT) {
        try (FileReader reader = new FileReader(arquivo)) {
            return gson.fromJson(reader, typeOfT);
        } catch (IOException e) {
            return null; // Retorna lista vazia se houver erro
        }
    }

    /**
     * Método auxiliar que salva os dados no JSON
     * @param dados Lista genérica de objetos para salvar
     */
    public void salvar(ArrayList<T> dados) {
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(dados, writer);
        } catch (IOException e) {
            System.out.println("Erro de gravação no JSON: " + e.getMessage());
        }
    }
    
    /**
     * Método auxiliar que salva os dados no JSON do caixa
     * @param dados Lista genérica de objetos para salvar
     */
    public void salvar(T dados) {
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(dados, writer);
        } catch (IOException e) {
            System.out.println("Erro de gravação no JSON: " + e.getMessage());
        }
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Classe que persiste os dados do sistema no JSON correspondente";
    }
}
