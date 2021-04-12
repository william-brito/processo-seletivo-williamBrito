package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

class FuncionarioServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testFuncionarioRead() {

		fail("Not yet implemented");

	}

	@Test
	void testFuncionarioCreate() {
		FuncionarioService funServ = new FuncionarioService();
		SetorService SetServ = new SetorService();

		Funcionario f = new Funcionario();
		Setor s = new Setor();

		s.setId(null); // Est� como "null" pos as ID's s�o geradas automaticamente!
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
	void testFuncionarioUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testFuncionarioDelete() {
		fail("Not yet implemented");
	}

}
