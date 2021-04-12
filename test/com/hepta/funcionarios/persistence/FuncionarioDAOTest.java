package com.hepta.funcionarios.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

class FuncionarioDAOTest {

	@Test
	void testSalvarFuncionarioNoBanco() {
		FuncionarioDAO funDAO = new FuncionarioDAO();
		

		Funcionario f = new Funcionario();
		Setor s = new Setor();

		s.setId(2); // Definir uma ID correspondente ao Setor na tabela "Setor".
		

		f.setId(null); // ID's gerados automaticamente!
		f.setNome("William Brito");
		f.setSetor(s); // chave estrangeira
		f.setSalario(1000.0);
		f.setEmail("william@tester.com");
		f.setIdade(21);

		try {
			funDAO.salvarFuncionarioNoBanco(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testAtualizarFuncionarioNoBanco() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletarFuncionarioDoBanco() {
		fail("Not yet implemented");
	}

	@Test
	void testEncontrarFuncionarioNoBanco() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

}
