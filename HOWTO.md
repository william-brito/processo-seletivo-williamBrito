Mais detalhes no: README.md

Observação Inicial: O padrão do projeto no Git foi alterado de 'Master' para 'Main' para se adequar à atualização do GitHub

.:Descrições do Projeto:.

1 - Criar um banco de dados com o nome de "funcionarios_prova": 
- CREATE DATABASE funcionarios_prova;

2 - O Hibernate se encarregará de criar as tabelas e colunas referentes às Classes: Funcionário e Setor, e as inserirá dentro da Base de Dados "funcionarios_prova";
- Criar-se-á no banco de dados "funcionarios_prova" a seguinte estrutura:

create table Funcionario (
       ID_FUNCIONARIO integer not null auto_increment,
        DS_EMAIL varchar(30),
        NU_IDADE integer,
        NOME_FUNCIONARIO varchar(100),
        NU_SALARIO double precision,
        FK_SETOR integer,
        primary key (ID_FUNCIONARIO)
    ) engine=InnoDB
Hibernate: 
    
    create table Setor (
       ID_SETOR integer not null auto_increment,
        NOME_SETOR varchar(30),
        primary key (ID_SETOR)
    ) engine=InnoDB
Hibernate: 
    
    alter table Funcionario 
       add constraint FK2peemlj28pdi3f8sp2ef28hhf 
       foreign key (FK_SETOR) 
       references Setor (ID_SETOR)


3 - A fim de se realizar os testes unitários, acessar a pasta "test" e os pacotes onde se encontram os respectivos arquivos: 
- "FuncionarioServiceTest.java"; 
- "FuncionarioDAOTest.java"; 
- "SetorServiceTest.java"; 
- "SetorDAOTest.java"; 

(os testes deverão ser rodados no modo "JUnit")

4 - A fim de se observar com mais assertividade as adições, alterações e remoções, deve-se testar, de preferência, na seguinte ordem: 

1 - FuncionarioServiceTest (Que criará um Setor junto ao funcionário, para testes)
2 - FuncionariosDAOTest
3 - SetorDAOTest
4 - SetorServiceTest

 Front end web
Pré-requisitos: node.js 

```bash
1-Instalar o seguinte programa:
-node.js

2-Adentrar a pasta do projeto
cd front-end-vue

3-Preparar cliente: 
npm install -g @vue/cli 

4-Executar front-end:
npm run serve

```
# Autor

William Brito de Oliveira

https://github.com/william-brito

