package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.fail;

//import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;


class FuncionarioServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void CriarFuncionarioESetor() { // Testando a cria��o do Funcion�rio junto ao Setor!
		FuncionarioService funServ = new FuncionarioService();
		SetorService SetServ = new SetorService();

		Funcionario f = new Funcionario();
		Setor s = new Setor();

		s.setId(null); // Est� como "null" pois as ID's s�o geradas automaticamente!
		s.setNome("TI");

		f.setId(null); // ID's gerados automaticamente!
		f.setNome("Felizardo Alves");
		f.setSetor(s); // chave estrangeira
		f.setSalario(1000.0);
		f.setEmail("felizardo@tester.com");
		f.setIdade(20);

		SetServ.CriarSetor(s); // Inserir o Setor primeiro, devido � chave estrangeira na tabela Funcion�rio
		funServ.CriarFuncionario(f);
	}

	@Test
	void CriarFuncionario() {
		FuncionarioService funServ = new FuncionarioService();

		Funcionario f = new Funcionario();
		Setor s = new Setor();

		s.setId(1); // Definir uma ID correspondente ao Setor na tabela "Setor".

		f.setId(null); // ID's gerados automaticamente!
		f.setNome("Maria Silva");
		f.setSetor(s); // chave estrangeira
		f.setSalario(2000.0);
		f.setEmail("maria@tester.com");
		f.setIdade(22);

		funServ.CriarFuncionario(f);
	}

	@Test
	void testListarFuncionarios() { // Analisar Depois*

		FuncionarioService funServ = new FuncionarioService();

		try {

			funServ.ListarFuncionarios(); // retorna "response"

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testEncontrarFuncionario() {

		FuncionarioService funServ = new FuncionarioService();

		try {
			funServ.EncontrarFuncionario(2); // Encontrar 1 funcion�rio pela ID inserida no m�todo ---> retorna
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testFuncionarioUpdate() {
		
		FuncionarioService funServ = new FuncionarioService();

        try {
            FuncionarioDAO funDAO = new FuncionarioDAO();

        	Funcionario funcionarioSelecionado = funDAO.encontrarFuncionarioDAO(2);
        				
            System.out.println(funcionarioSelecionado); //Antes
			
			funcionarioSelecionado.setNome("Joana Pires"); //Nome que entrar� na tabela "Funcion�rio", no lugar de outro cujo registro possui ID = 2
			
			funServ.AtualizarFuncionario(2, funcionarioSelecionado);
			
			System.out.println(funcionarioSelecionado); //Depois
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	void testFuncionarioDelete() {
		FuncionarioService funServ = new FuncionarioService();
		try {
			funServ.DeletarFuncionario(3); //Remove da Tabela 'Funcionario', o registro correspondente � ID inserida na fun��o
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
