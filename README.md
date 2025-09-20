# Sistema de Gestão de Academia
![Badge de Status](https://img.shields.io/badge/status-concluído-green.svg)

Um sistema de gestão completo para academias, desenvolvido como projeto para a disciplina de Programação Orientada a Objetos. O sistema visa aprimorar a eficiência administrativa e o controle financeiro do negócio. 

## 📝 Sobre o Projeto

Este projeto propõe a implementação de um sistema de gestão para uma academia localizada em um destino turístico (Milho Verde, MG), atendendo tanto a moradores locais quanto a visitantes temporários. O objetivo é oferecer um serviço organizado e adaptado às necessidades de cada cliente, modernizando a gestão e promovendo um melhor controle dos recursos. 

O sistema inclui a administração de aulas, alunos, funcionários, uma lanchonete e uma pequena loja de materiais de academia, além de um robusto controle financeiro. 

## ✨ Funcionalidades Principais

O sistema foi projetado com diversas funcionalidades para otimizar a rotina da academia:

* **Autenticação de Usuários**: Sistema de login seguro para funcionários com diferentes níveis de permissão (Funcionário e Administrador). 
* **Gerenciamento de Agenda**: Permite consultar, reservar, editar e remover horários para as aulas de Spinning, Musculação, Fit Dance e Pilates. 
* **Gestão de Alunos**: Cadastro, edição, remoção e consulta de alunos, com a possibilidade de emitir um perfil detalhado com histórico de aulas, compras e tempo de permanência. 
* **Ponto de Venda (PDV)**: Módulo para lançar vendas de produtos da lanchonete e da loja, atualizando o estoque automaticamente. 
* **Controle de Estoque**: Gerenciamento completo dos produtos da loja, permitindo adicionar, editar e remover itens. 
* **Gestão de Funcionários**: (Acesso de Administrador) Permite cadastrar, editar e remover funcionários do sistema. 
* **Controle Financeiro**: (Acesso de Administrador) Lançamento de despesas e receitas, consulta de movimentações e geração de balanços mensais para um controle financeiro preciso. 
* **Monitoramento de Acesso**: Integração com uma catraca eletrônica para registrar a entrada e saída de clientes, calculando automaticamente o tempo de permanência nas instalações. 

## 🎭 Atores do Sistema

O sistema possui três atores principais com diferentes níveis de interação:

1.  **Funcionário**: Realiza as operações do dia a dia, como gerenciar a agenda, cadastrar alunos, lançar vendas e verificar o estoque. 
2.  **Administrador**: Herda todas as permissões do `Funcionário` e possui acesso a funcionalidades estratégicas, como gerenciar funcionários, controlar as finanças e emitir relatórios detalhados. 
3.  **Catraca**: Um ator externo que interage com o sistema para registrar o horário de entrada e saída dos clientes, automatizando o controle de acesso e tempo de uso. 

## 🛠️ Modelagem e Arquitetura

Todo o sistema foi modelado utilizando técnicas de Programação Orientada a Objetos e diagramas UML para fornecer uma visão detalhada de sua estrutura e funcionamento. 

## 💻 Tecnologias Utilizadas

* **Linguagem de Programação:** `Java`
* **Banco de Dados:** `Json apenas para fins didáticos`

## 👩‍💻 Autora
Este projeto foi desenvolvido por:

Evelen Pinheiro de Oliveira

## 🎓 Contexto Acadêmico
Trabalho apresentado à disciplina de Programação Orientada a Objetos, do curso de Sistemas de informação, na Universidade Federal dos Vales do Jequitinhonha e Mucuri (UFVJM), sob a orientação do Prof. Eduardo Pelli.

