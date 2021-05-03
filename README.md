# Processo Seletivo - HEPTA
## Sobre o objetivo do teste

"O teste foi feito com uma arquitetura bem simples para facilitar o entendimento. É um pequeno sistema para gerenciar os funcionários dos setores. É possível exibir todos os funcionários existentes se os dados forem inseridos manualmente na base de dados."

É preciso que implementar as funcionalidades de **inserir**, **editar** e **deletar** um funcionário.

Foi implementado apenas as classes relacionadas a entidade Funcionario.

## Layout web
![Web 1](https://github.com/william-brito/processo-seletivo-williamBrito/blob/main/preview-set/inicioVersao2.jpg)
![Web 2](https://github.com/william-brito/processo-seletivo-williamBrito/blob/main/preview-set/criarFuncionarioVersao2.jpg)
![Web 3](https://github.com/william-brito/processo-seletivo-williamBrito/blob/main/preview-set/adicionado.jpg)

# Tecnologias utilizadas
## Back end
- Java
- Jersey
- JPA / Hibernate
- Maven
## Front end
- HTML / CSS / JS 
- Vue.Js
- Node.Js
- Bootstrap
- Axios
- Sweetalert2
- Vuelidation

## Implantação em produção
- IDE: Eclipse.
- Back end: Apache Tomcat v9
- Front end web: Node.js
- Banco de dados: Mysql

# Como executar o projeto

## Back end
Pré-requisitos: Java 15, Porta 3000 livre.

```bash

# clonar repositório
git clone https://github.com/william-brito/processo-seletivo-williamBrito

# Iniciar Banco de Dados

# Criar banco de dados com o nome de "funcionarios_prova".
=> CREATE DATABASE funcionarios_prova
=> Senha do banco no arquivo "persistence.xml" igual a "12345"

# Instalar Apache Tomcat v9

# Mudar localhost do Apache Tomcat para porta 3000 
=> No Eclipse, clicar duas vezes sobre o server, e alterar para 3000 no menu "port"

# iniciar projeto (pasta src)
=> O Hibernate se encarregará de criar as tabelas e colunas referentes às Classes: Funcionário e Setor, e as inserirá dentro da Base de Dados "funcionarios_prova"
Criar-se-á, então, no banco de dados "funcionarios_prova" a seguinte estrutura:

create table Funcionario ( 
  ID_FUNCIONARIO 
  integer not null auto_increment, 
  DS_EMAIL varchar(30), 
  NU_IDADE integer, 
  NOME_FUNCIONARIO varchar(100), 
  NU_SALARIO double precision, 
  FK_SETOR integer, primary key (ID_FUNCIONARIO) ) 
engine=InnoDB Hibernate:

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
   
# A fim de se realizar os testes unitários no back end, acessar a pasta "test" e os pacotes onde se encontram os respectivos arquivos:

    "FuncionarioServiceTest.java";
    "FuncionarioDAOTest.java";
    "SetorServiceTest.java";
    "SetorDAOTest.java";

(os testes deverão ser rodados no modo "JUnit")
-A fim de se observar com mais assertividade as adições, alterações e remoções, deve-se testar, de preferência, na seguinte ordem:

1 - FuncionarioServiceTest (Que criará um Setor junto ao funcionário, para testes) 
2 - FuncionariosDAOTest 
3 - SetorDAOTest 
4 - SetorServiceTest

```
## Front end web
Pré-requisitos: node.js 

```bash
# Instalar o seguinte programa:
=> node.js

# Adentrar a pasta do projeto
=> cd front-end-vue

# Preparar cliente: 
=> npm install -g @vue/cli 

# Executar front-end:
=> npm run serve

```
# Autor

William Brito de Oliveira

https://github.com/william-brito

