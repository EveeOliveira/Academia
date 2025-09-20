package Comparator;

public class ComparatorString{  
    
    /**
     * Implementação do compare para Strings no geral
     * @param obj1
     * @param obj2
     * @return 1 para primeiro obj maior que o segundo/ -1 para segundo obj maior que o primeiro / 0 para objs iguais
     */
    public static int compare(String obj1, String obj2) {
        
        for(int i = 0; i < Math.min(obj1.length(), obj2.length()); i++){
            char o1 =  obj1.charAt(i);
            char o2 = obj2.charAt(i);
            
            if(o1 < o2){
                return -1;
            }
            else if(o1 > o2){
                return 1;
            }           
        }
        
        /**
         * Se os caracteres forem iguais até o último caractere da menor string essa é a verificação de tamanho entre eles
         */
        if (obj1.length() < obj2.length()) {
            return -1;
        } else if (obj1.length() > obj2.length()) {
            return 1;
        }

        /**
         * As strings são iguais
         */
        return 0;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Implementação do comparator por String, comparador que auxiliam outros";
    }
}
