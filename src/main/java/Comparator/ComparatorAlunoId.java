package Comparator;

import Model.Aluno;
import java.util.Comparator;

public class ComparatorAlunoId implements Comparator<Aluno>{

    /**
     * Implementação do compare para aluno ID
     * @param a1
     * @param a2
     * @return 
     */
    @Override
    public int compare(Aluno a1, Aluno a2) {
        return ComparatorString.compare(a1.getId(), a2.getId());
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Comparador de aluno por Id";
    }
}
