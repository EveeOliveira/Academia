package Model;

public class Caixa {
    private double saldo;

    /**
     * Getter do saldo
     * @return 
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Setter do saldo
     * @param saldo 
     */
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Abstração de um caixa";
    }
}
