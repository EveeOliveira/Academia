package Questoes;

import Comparator.ComparatorAgendamento;
import Comparator.ComparatorAlunoCpf;
import Comparator.ComparatorAlunoId;
import Controller.AgendamentoController;
import Controller.CatracaController;
import Controller.GerenciarAlunoController;
import Controller.GerenciarEstoqueController;
import Controller.GerenciarFuncionarioController;
import Model.Academia;
import Model.Agendamento;
import Model.Aluno;
import Model.Funcionario;
import Model.Produto;
import aplicacao.Sistema;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Iterator;

public class Questoes {
    Academia academia;
    
    GerenciarAlunoController controllerAluno;
    GerenciarFuncionarioController controllerFuncionario;
    GerenciarEstoqueController controllerEstoque;
    AgendamentoController controllerAgendamento;
    CatracaController controllerCatraca;
    
    /**
     * Construtor de questoes
     * @param academia
     * @param controllerAluno
     * @param controllerFuncionario
     * @param controllerEstoque
     * @param controllerAgendamento
     * @param controllerCatraca
     */
    public Questoes(Academia academia, GerenciarAlunoController controllerAluno, GerenciarFuncionarioController controllerFuncionario, GerenciarEstoqueController controllerEstoque, AgendamentoController controllerAgendamento, CatracaController controllerCatraca){
        this.academia = academia;
        this.controllerAluno = controllerAluno;
        this.controllerFuncionario = controllerFuncionario;
        this.controllerEstoque = controllerEstoque;
        this.controllerAgendamento = controllerAgendamento;
        this.controllerCatraca = controllerCatraca;
    }
    
    private void Questao1(){
        System.out.println("Questão 1 - Implementação das classes do diagrama de classes");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao2(){
        System.out.println("Questão 2 - Colaboradores e Administradores podem acessar o sistema");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao3(){
        System.out.println();
        System.out.println("Questão 3 - Sobrescrever o método toString() de todas as classes implementadas");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao4(){
        System.out.println();
        System.out.println("Questão 4 - Utilizar a palavra-chave super para implementar os construtores das subclasses");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao5(){
        System.out.println();
        System.out.println("Questão 5 - O sistema deverá armazenar de forma estática as informações das 4 salas da academia");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao6(){
        System.out.println();
        System.out.println("Questão 6 - Deve ser possível cadastrar os colaboradores no sistema, alterar ou editar seus atributos");
        System.out.println();
        // Teste de Cadastro
        System.out.println("Teste - Cadastro de Funcionário:");
        Funcionario funcionario1 = new Funcionario("Colaborador", 3000.0f, "usuario1", "senha1", "Carlos", "Pereira", "12345678901", "Rua X", "987654321", "carlos@email.com");
        controllerFuncionario.cadastrarFuncionario(funcionario1);
        System.out.println("Funcionários cadastrados: " + academia.getListaFuncionarios());

        // Teste de Busca
        System.out.println("\nTeste - Busca de Funcionário:");
        Funcionario encontrado = controllerFuncionario.buscarFuncionario("12345678901");
        System.out.println("Funcionário encontrado: " + (encontrado != null ? encontrado : "Nenhum funcionário encontrado."));

        // Teste de Edição
        System.out.println("\nTeste - Edição de Funcionário:");
        Funcionario funcionarioAtualizado = new Funcionario("Colaborador", 3500.0f, "usuario1", "senha1", "Carlos", "Pereira", "12345678901", "Rua Y", "987654321", "carlos@email.com");
        boolean editado = controllerFuncionario.editarFuncionario("12345678901", funcionarioAtualizado);
        System.out.println("Edição realizada: " + editado);
        System.out.println("Funcionário após edição: " + controllerFuncionario.buscarFuncionario("12345678901"));

        // Teste de Remoção
        System.out.println("\nTeste - Remoção de Funcionário:");
        boolean removido = controllerFuncionario.removeFuncionario("12345678901");
        System.out.println("Funcionário removido: " + removido);
        System.out.println("Funcionários após remoção: " + academia.getListaFuncionarios());

        // Tentativa de busca após remoção
        System.out.println("\nTeste - Busca após Remoção:");
        Funcionario encontradoAposRemocao = controllerFuncionario.buscarFuncionario("12345678901");
        System.out.println("Funcionário encontrado: " + (encontradoAposRemocao != null ? encontradoAposRemocao : "Nenhum funcionário encontrado."));
        System.out.println("----------------------------------------------------------------------");
    }
    
    private void Questao7(){
        System.out.println();
        System.out.println("Questão 7 - Cadastrar, alterar ou excluir clientes");
        System.out.println();
        // Teste 1: Cadastro de aluno
        Aluno aluno1 = new Aluno("João", "Silva", "12345678900", "Rua A", "123456789", "joao@email.com", "1111-2222-3333-4444");
        controllerAluno.cadastrarAluno(aluno1);
        System.out.println("Teste 1 - Cadastro de Aluno:");
        System.out.println("Lista de alunos após cadastro: " + academia.getListaAlunos());

        // Teste 2: Remover aluno pelo CPF
        System.out.println("\nTeste 2 - Remover Aluno:");
        boolean removido = controllerAluno.removeAluno("12345678900");
        System.out.println("Aluno removido: " + removido);
        System.out.println("Lista de alunos após remoção: " + academia.getListaAlunos());

        // Teste 3: Editar aluno
        Aluno aluno2 = new Aluno("Maria", "Oliveira", "98765432100", "Rua B", "987654321", "maria@email.com", "5555-6666-7777-8888");
        controllerAluno.cadastrarAluno(aluno2);

        Aluno alunoAtualizado = new Aluno("Maria Clara", "Oliveira", "98765432100", "Rua C", "999888777", "maria.clara@email.com", "5555-6666-7777-8888");
        boolean editado = controllerAluno.editarAluno("98765432100", alunoAtualizado);
        System.out.println("\nTeste 3 - Editar Aluno:");
        System.out.println("Aluno editado: " + editado);
        System.out.println("Dados do aluno após edição: " + controllerAluno.buscarAluno("98765432100"));

        // Teste 4: Buscar aluno pelo CPF
        System.out.println("\nTeste 4 - Buscar Aluno:");
        Aluno alunoBuscado = controllerAluno.buscarAluno("98765432100");
        if (alunoBuscado != null) {
            System.out.println("Aluno encontrado: " + alunoBuscado);
        } else {
            System.out.println("Aluno não encontrado.");
        }

        // Teste 5: Tentar buscar aluno inexistente
        System.out.println("\nTeste 5 - Buscar Aluno Inexistente:");
        Aluno alunoNaoExistente = controllerAluno.buscarAluno("00000000000");
        if (alunoNaoExistente != null) {
            System.out.println("Aluno encontrado: " + alunoNaoExistente);
        } else {
            System.out.println("Aluno não encontrado.");
        }        
        System.out.println("----------------------------------------------------------------------");
        
    }
    
    private void Questao8(){
        System.out.println();
        System.out.println("Questão 8 - Verificar e imprimir dados das vendas de diárias e mensalidades e dados dos clientes;");
        System.out.println();
        System.out.println("Buscando agendamento do " + academia.getListaAlunos().get(1).getNome());
        controllerAgendamento.buscarAgendamentos(academia.getListaAlunos().get(1).getCpf(), "Spinning"); 
        LocalDateTime dataAula = LocalDateTime.of(2024, 10, 07, 15, 30);
        Agendamento agendamento = new Agendamento(
            "Fit Dance",
            "Mensal",
            "A confirmar",
            academia.getListaAlunos().get(2),
            100.0f,
            "Marcia",
            dataAula // Ano, mês, dia, horas e minutos da data da aula
        );

        System.out.println(academia.getMatriculasAgendadas());

        if(controllerAgendamento.verificarVaga(agendamento.getDataAula(), agendamento.getTipoAula())){
            controllerAgendamento.novoAgendamento(agendamento);
        }
        System.out.println("----------------------------------------------------------------------");      
    }
    
    private void Questao9(){
        System.out.println();
        System.out.println("Questão 9 - As reservas, ações da catraca e os clientes devem ser salvos de forma dinâmica no sistema.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao10(){
        System.out.println();
        System.out.println("Questão 10 - Cada venda efetuada vai gerar um extrato que deverá ser impresso e salvo junto com a informação do cliente que fez o agendamento.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao11(){
        System.out.println();
        System.out.println("Questão 11 - Criar duas variaveis de classe (static) que irao armazenar quantas instancias foram criadas dos tipos Cliente dentro da classe Sistema usando duas soluções diferentes:");
        System.out.println();
        System.out.println("Quantidade na variável private:");
        System.out.println(Sistema.getQuantidadeAlunosPrivate());
        System.out.println();
        System.out.println("Quantidade na variável private");
        System.out.println(Sistema.getQuantidadeAlunosProtected());
        System.out.println();
        Aluno aluno1 = new Aluno("Laura", "Souza", "12345678550", "Rua A", "123456789", "joao@email.com", "1111-2222-3333-4444");
        controllerAluno.cadastrarAluno(aluno1);
        System.out.println("Novo cadastro!");
        System.out.println("aluno1");
        System.out.println();
        System.out.println("Quantidade na variável private:");
        System.out.println(Sistema.getQuantidadeAlunosPrivate());
        System.out.println("Quantidade na variável private");
        System.out.println(Sistema.getQuantidadeAlunosProtected());
        System.out.println();
        System.out.println("Removendo aluno");
        controllerAluno.removeAluno("12345678550");
        System.out.println("Quantidade na variável private:");
        System.out.println(Sistema.getQuantidadeAlunosPrivate());
        System.out.println("Quantidade na variável private");
        System.out.println(Sistema.getQuantidadeAlunosProtected());
        System.out.println("----------------------------------------------------------------------");
        
    }
    
    private void Questao12(){
        System.out.println();
        System.out.println("Questao 12 - Criar um método de classe para classe Sistema que deverá retornar quantas instâncias foram criadas dos tipos Cliente e Produtos da loja");
        System.out.println();
        System.out.println("Quantdade de produtos no sistema");
        System.out.println(Sistema.getQuantidadeProdutos());
        System.out.println("---------------------------------------------------");
        System.out.println("Instanciando novo produto");
        Produto produto1 = new Produto("Produto B", "Descrição do Produto B", 10, 5.0f, 10.0f);
        controllerEstoque.adicionarProduto(produto1);
        System.out.println(Sistema.getQuantidadeProdutos());
        System.out.println("---------------------------------------------------");
        System.out.println("Removendo produto");
        controllerEstoque.removerProduto("Produto B");
        System.out.println(Sistema.getQuantidadeProdutos());
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao13(){
        System.out.println();
        System.out.println("Questão 13 - Implementar a interface Comparator para as classes Agendamento e Cliente e fazer comparações por diferentes atributos.");
        System.out.println("LISTA DE ALUNOS SEM ORDENAÇÃO");
        System.out.println(academia.getListaAlunos());
        Collections.sort(academia.getListaAlunos(), new ComparatorAlunoCpf());
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("LISTA DE ALUNOS ORDENADA");
        System.out.println(academia.getListaAlunos());

        System.out.println("LISTA DE AGENDAMENTOS SEM ORDENAÇÃO");
        System.out.println(academia.getMatriculasAgendadas());
        Collections.sort(academia.getMatriculasAgendadas(), new ComparatorAgendamento());
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("LISTA DE AGENDAMENTOS ORDENADA");
        System.out.println(academia.getMatriculasAgendadas());
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao14(){
        System.out.println();
        System.out.println("Questão 14 - Salve e recupere todas as informações dos Clientes, Agendamentos, Produtos, RelatóriosdeVendas, Colaboradores e Estoque em um arquivo de texto. Utilizem classes já prontas na internet que trabalhem com o formato json. Ao manipular um arquivo utilize os conceitos aprendidos em aula para alocar e desalocar recursos com segurança.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao15(){
        System.out.println();
        System.out.println("Questão 15 - Gerar um JavaDoc de todo o seu projeto");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao152(){
        System.out.println();
        System.out.println("Questão 15.2 - Instaciar um iterator para a arraylist de pessoas/funcionario/cliente");
        System.out.println();
        Iterator<Funcionario> iterator = academia.getListaFuncionarios().iterator(); // Obtem o Iterator
            System.out.println("INTARATOR");

            while (iterator.hasNext()) { 
                Funcionario funcionario = iterator.next(); // Pega o próximo elemento
                if (funcionario != null) { 
                    System.out.println(funcionario);
                }
            }
            
            System.out.println();
            System.out.println("FOREACH");
            for(Funcionario funcionario : academia.getListaFuncionarios()){
                if(funcionario != null){
                    System.out.println(funcionario);
                }
            }
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao16(){
        System.out.println();
        System.out.println("Questão 16 - Apresentar no main testes do comparator implementado.");
        System.out.println("LISTA DE ALUNOS SEM ORDENAÇÃO");
        System.out.println(academia.getListaAlunos());
        Collections.sort(academia.getListaAlunos(), new ComparatorAlunoCpf());
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("LISTA DE ALUNOS ORDENADA POR CPF");
        System.out.println(academia.getListaAlunos());
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        Collections.sort(academia.getListaAlunos(), new ComparatorAlunoId());
        System.out.println("LISTA DE ALUNOS ORDENADA POR ID");
        System.out.println(academia.getListaAlunos());
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    private void Questao17(){
        System.out.println();
        System.out.println("Questão 17 - Find clientes");
        Aluno find = controllerAluno.find("98765432100");
        System.out.println(find);


        Collections.sort(academia.getListaAlunos(), new ComparatorAlunoCpf());
        int index = Collections.binarySearch(academia.getListaAlunos(), new Aluno("98765432100"), new ComparatorAlunoCpf());
        System.out.println(academia.getListaAlunos().get(index));
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
    }
    
    public void imprimirQuestoes(){
        Questao1();
        Questao2();
        Questao3();
        Questao4();
        Questao5();
        Questao6();
        Questao7();
        Questao8();
        Questao9();
        Questao10();
        Questao11();
        Questao12();
        Questao13();
        Questao14();
        Questao15();
        Questao152();
        Questao16();
        Questao17();
    }
}
