package Controller;

import Model.Academia;
import Model.Agendamento;
import Model.Aluno;
import Model.DAO.DAO;
import aplicacao.Sistema;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AgendamentoController {
    /**
     * Instancia da academia
     */
    private Academia academia;
    
    /**
     * Instancia do DAO de agendamentos
     */
    private DAO agendamentoDAO;
    
    /**
     * Construtor da classe AgendamentoController
     * @param academia 
     */
    public AgendamentoController(Academia academia){
        this.academia = academia;
        this.agendamentoDAO = new DAO("src\\main\\java\\Model\\DAO\\Agendamentos.json", Agendamento.class);
        academia.setMatriculasAgendadas(agendamentoDAO.carregar());
    }
    
    /**
     * Método que verifica se a vaga
     * @param dataAula
     * @param tipoAula
     * @return true se tem vaga, false se não houver vaga
    */
    public boolean verificarVaga(LocalDateTime dataAula, String tipoAula){
        for (Agendamento agendamentos : academia.getMatriculasAgendadas()) {
            if (agendamentos.getDataAula().equals(dataAula)) {
                if(Sistema.getSala(tipoAula).getCapacidade() > 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            } 
        }
        return false;
    } 
    
    /**
     * Método que cria um novo agendamento passando parêmetros separados 
     * @param tipoAula
     * @param tipoMatricula
     * @param aluno
     * @param valor
     * @param instrutor
     * @param dataAula
     */
    public void novoAgendamento(String tipoAula, String tipoMatricula, Aluno aluno, float valor, String instrutor, LocalDateTime dataAula){
        Agendamento agendamento = new Agendamento(tipoAula, tipoMatricula, "A confirmar", aluno, valor, instrutor, dataAula);
        academia.getMatriculasAgendadas().add(agendamento);
        int capacidade = Sistema.getSala(agendamento.getTipoAula()).getCapacidade();
        capacidade = capacidade - 1;
        Sistema.getSala(agendamento.getTipoAula()).setCapacidade(capacidade);
    }
    
    /**
     * Método que cria um novo agendamento passando agendamento
     * @param agendamento
     */
    public void novoAgendamento(Agendamento agendamento){
        academia.getMatriculasAgendadas().add(agendamento);
        int capacidade = Sistema.getSala(agendamento.getTipoAula()).getCapacidade();
        capacidade = capacidade - 1;
        Sistema.getSala(agendamento.getTipoAula()).setCapacidade(capacidade);
    }
    
    /**
     * Método que busca os agendamentos por aluno
     * @param cpf 
     * @param tipoAula 
     * @return  
     */
    public Agendamento buscarAgendamentos(String cpf, String tipoAula){
        for(Agendamento agendamentos : academia.getMatriculasAgendadas()){
            if(agendamentos.getAluno().getCpf().equals(cpf) && agendamentos.getTipoAula().equals(tipoAula)){
                return agendamentos;
            }
        }
        return null;
    }
    
    /**
     * Método que gera o extrato de venda de matrículas
     * @param agendamento 
     */
    public void gerarExtrato(Agendamento agendamento){
        System.out.println("---------------------------- EXTRATO ----------------------------");
        System.out.println();
        
        System.out.println("Aluno: " + agendamento.getAluno().getNome() + " " + agendamento.getAluno().getSobrenome());
        System.out.println("Email: " + agendamento.getAluno().getEmail());
        
        System.out.println();
        System.out.println("Agendamento Aula: " + agendamento.getTipoAula());
        System.out.println("Valor: R$" + agendamento.getValor());
        
        System.out.println("-----------------------------------------------------------------");
        
        System.out.println();
        
        
    }
    
    
    /**
     * Método que remove o agendamento
     * @param aluno
     * @param tipoAula
     * @param dataAula
     */
    public void cancelarAgendamento(String nome, String tipoAula, LocalDateTime dataAula){
        for(Agendamento agendamentos : academia.getMatriculasAgendadas()){
            if(agendamentos.getAluno().getNome().equals(nome) && agendamentos.getTipoAula().equals(tipoAula) && agendamentos.getDataAula().equals(dataAula)){
                academia.getMatriculasAgendadas().remove(agendamentos);
            }
        }
    }
    
    /**
     * Método que solicita datas para os agendamentos
     * @param tipoData 
     * @param scanner
     * @return 
     */
    public LocalDateTime solicitarData(String tipoData, Scanner scanner) {
        System.out.println("Digite a data da " + tipoData + ":");

        System.out.print("Ano (AAAA): ");
        int ano = scanner.nextInt();

        System.out.print("Mês (MM): ");
        int mes = scanner.nextInt();

        System.out.print("Dia (DD): ");
        int dia = scanner.nextInt();

        System.out.print("Hora (HH): ");
        int hora = scanner.nextInt();

        System.out.print("Minutos (MM): ");
        int minutos = scanner.nextInt();

        // Limpar o buffer do scanner após as entradas numéricas
        scanner.nextLine();

        // Retornar o LocalDateTime criado a partir dos valores inseridos
        return LocalDateTime.of(ano, mes, dia, hora, minutos);
    }
    
    /**
     * Método para confirmação dos agendamentos
     * @param nome do aluno
     * @param tipoAula agendada
     * @param dataAula agendada
     */
    public boolean confirmarAgendamento(String nome, String tipoAula, LocalDateTime dataAula){
        int index = 0;
        for(Agendamento agendamentos : academia.getMatriculasAgendadas()){
            System.out.println(agendamentos.getDataAula());
            System.out.println(nome);
            System.out.println(tipoAula);
            if(agendamentos.getAluno().getNome().equals(nome) && agendamentos.getTipoAula().equals(tipoAula) && agendamentos.getDataAula().equals(dataAula)){
                academia.getMatriculasAgendadas().get(index).setStatus("Confirmado");
                System.out.println("Matricula confirmada!");
                return true;
            }
            index++;
        }
        System.out.println("Não foi possível confirmar a Matricula!");
        return false;
    }
    
    /**
     * @return the agendamentoDAO
     */
    public DAO getAgendamentoDAO() {
        return agendamentoDAO;
    }
    
    /**
     * Método to string
     * @return texto que representa o objeto
     */
    @Override
    public String toString(){
        return "Classe controller de agendamento";
    }
}
