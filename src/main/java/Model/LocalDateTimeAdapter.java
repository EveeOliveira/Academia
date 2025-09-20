package Model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Método adaptado para escrever variáveis do tipo LocalDateTime
     * @param jsonWriter
     * @param localDateTime
     * @throws IOException 
     */
    @Override
    public void write(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException {
        if (localDateTime != null) {
            jsonWriter.value(localDateTime.format(formatter)); // Serializa LocalDateTime como String formatada
        } else {
            jsonWriter.nullValue(); // Se o valor for nulo
        }
    }

    /**
     * Método adaptado para ler variáveis do tipo LocalDateTime
     * @param jsonReader
     * @return 
     * @throws IOException 
     */
    @Override
    public LocalDateTime read(JsonReader jsonReader) throws IOException {
        String date = jsonReader.nextString();
        return date.isEmpty() ? null : LocalDateTime.parse(date, formatter); // Desserializa a String para LocalDateTime
    }
}
