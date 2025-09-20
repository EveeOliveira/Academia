package aplicacao;

import Controller.AgendamentoController;
import Controller.CatracaController;
import Controller.GerenciarAlunoController;
import Controller.GerenciarEstoqueController;
import Controller.GerenciarFinancaController;
import Controller.GerenciarFuncionarioController;
import Controller.GerenciarVendaController;
import Controller.LoginController;
import Menu.MenuAdministrador;
import Menu.MenuColaborador;
import Model.Academia;
import Model.Sala;
import java.util.Scanner;

public class Sistema {
    private static int quantidadeAlunosPrivate = 0;

    /**
     * Atributos
     */
    protected static int quantidadeAlunosProtected = 0;
    private static int quantidadeProdutos = 0;
    private static int quantidadeClientes = 0;
    private static Sala[] salas = new Sala[]{
        new Sala("Spinning", 30),
        new Sala("Musculação", 30),
        new Sala("Fit Dance", 30),
        new Sala("Pilates", 30),
    };
    
    public static void main(String args[]) {   
        /**
        * Instancia da academia.
        */
        Academia academia = new Academia(); 
        
        /**
        * Controllers do sistema.
        */
        GerenciarAlunoController controllerAluno = new GerenciarAlunoController(academia);
        GerenciarFuncionarioController controllerFuncionario = new GerenciarFuncionarioController(academia);
        GerenciarEstoqueController controllerEstoque = new GerenciarEstoqueController(academia);
        LoginController controllerLogin = new LoginController(academia);
        AgendamentoController controllerAgendamento = new AgendamentoController(academia);
        CatracaController controllerCatraca = new CatracaController(academia);
        GerenciarVendaController controllerVenda = new GerenciarVendaController(academia);
        GerenciarFinancaController controllerFinanca = new GerenciarFinancaController(academia);

        
        try {
            /**
             * Inicializando a quantidade de alunos e produtos
             */
            setQuantidadeAlunosPrivate(academia.getListaAlunos().size());
            setQuantidadeAlunosProtected(academia.getListaAlunos().size());
            setQuantidadeProdutos(academia.getEstoque().size());
            
            Scanner scanner = new Scanner(System.in);           
            System.out.println("Digite seu email:");
            String emailLogin = scanner.nextLine();
            
            System.out.println("Digite sua senha:");
            String senhaLogin = scanner.nextLine();
            
            int loginEfetuado = controllerLogin.efetuarLogin(emailLogin, senhaLogin);
            
            if(loginEfetuado == 1){
                MenuAdministrador.menuAdministrador(scanner, academia, controllerAluno, controllerFuncionario, controllerEstoque, controllerAgendamento, controllerCatraca, controllerVenda, controllerFinanca);
            } else if(loginEfetuado == 0){
                MenuColaborador.menuColaborador(scanner, academia, controllerAluno, controllerFuncionario, controllerEstoque, controllerAgendamento, controllerCatraca, controllerVenda);
            }else{
                System.out.println("Funcionario não encontrado!");
            }   
            
            scanner.close();
            
            
        } finally {
            if (controllerAluno.getAlunoDAO() != null) {
                controllerAluno.getAlunoDAO().salvar(academia.getListaAlunos());
            }
            if (controllerFuncionario.getFuncionarioDAO() != null) {
                controllerFuncionario.getFuncionarioDAO().salvar(academia.getListaFuncionarios());
            }
            if (controllerEstoque.getEstoqueDAO() != null) {
                controllerEstoque.getEstoqueDAO().salvar(academia.getEstoque());
            }
            if (controllerAgendamento.getAgendamentoDAO()!= null) {
                controllerAgendamento.getAgendamentoDAO().salvar(academia.getMatriculasAgendadas());
            }
            if (controllerCatraca.getCatracaDAO()!= null) {
                controllerCatraca.getCatracaDAO().salvar(academia.getCatraca());
            }
            if (controllerVenda.getVendasDAO()!= null) {
                controllerVenda.getVendasDAO().salvar(academia.getVendas());
            }
            if (controllerFinanca.getLancamentoDAO()!= null) {
                controllerFinanca.getLancamentoDAO().salvar(academia.getLancamentos());
            }
            if (controllerFinanca.getCaixaDAO()!= null) {
                controllerFinanca.getCaixaDAO().salvar(academia.getCaixa());
            }
            System.exit(0);
        }       
    }
    
    /**
     * @return the quantidadeAlunosPrivate
     */
    public static int getQuantidadeAlunosPrivate() {
        return quantidadeAlunosPrivate;
    }

    /**
     * @param aQuantidadeAlunosPrivate the quantidadeAlunosPrivate to set
     */
    public static void setQuantidadeAlunosPrivate(int aQuantidadeAlunosPrivate) {
        quantidadeAlunosPrivate = aQuantidadeAlunosPrivate;
    }

    /**
     * @return the quantidadeAlunosProtected
     */
    public static int getQuantidadeAlunosProtected() {
        return quantidadeAlunosProtected;
    }

    /**
     * @param aQuantidadeAlunosProtected the quantidadeAlunosProtected to set
     */
    public static void setQuantidadeAlunosProtected(int aQuantidadeAlunosProtected) {
        quantidadeAlunosProtected = aQuantidadeAlunosProtected;
    }

    /**
     * @return the quantidadeProdutos
     */
    public static int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    /**
     * @param aQuantidadeProdutos the quantidadeProdutos to set
     */
    public static void setQuantidadeProdutos(int aQuantidadeProdutos) {
        quantidadeProdutos = aQuantidadeProdutos;
    }
    
    /**evele
     * @param tipo
     * @return the salas
     */
    public static Sala getSala(String tipo) {
        for(Sala sala : salas){
            if(sala.getTipo().equals(tipo)){
                return sala;
            }
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "Main principal da aplicação";
    }

}
