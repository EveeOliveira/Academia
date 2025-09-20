package Comparator;

import Model.Agendamento;
import java.util.Comparator;

public class ComparatorAgendamento implements Comparator<Agendamento>{

    /**
     * Implementação do compare para Agendamentos
     * @param a1
     * @param a2
     * @return 1 para primeiro obj maior que o segundo/ -1 para segundo obj maior que o primeiro / 0 para objs iguais
     */
    @Override
    public int compare(Agendamento a1, Agendamento a2) {
        return ComparatorString.compare(a1.getId(), a2.getId());
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Comparador de agendamentos";
    }
}
