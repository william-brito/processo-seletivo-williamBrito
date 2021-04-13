package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.fail;

//import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;

@TestMethodOrder(OrderAnnotation.class)
class FuncionarioServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Order(1)
	void testCriarFuncionarioESetor() { // Testando a criação do Funcionário junto ao Setor!
		FuncionarioService funServ = new FuncionarioService();
		SetorService SetServ = new SetorService();

		Funcionario f = new Funcionario();
		Setor s = new Setor();

		s.setId(null); // Está como "null" pois as ID's são geradas automaticamente!
		s.setNome("TI");

		f.setId(null); // ID's gerados automaticamente!
		f.setNome("William Brito");
		f.setSetor(s); // chave estrangeira
		f.setSalario(1000.0);
		f.setEmail("william@tester.com");
		f.setIdade(29);

		SetServ.CriarSetor(s); // Inserir o Setor primeiro, devido à chave estrangeira na tabela Funcionário
		funServ.CriarFuncionario(f);
	}

	@Test
	@Order(2)
	void testCriarFuncionario() {
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
	@Order(3)
	void testListarFuncionarios() { // Analisar Depois*

		FuncionarioService funServ = new FuncionarioService();

		try {

			funServ.ListarFuncionarios(); // retorna "response"

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(4)
	void testEncontrarFuncionario() {

		FuncionarioService funServ = new FuncionarioService();

		try {
			funServ.EncontrarFuncionario(2); // Encontrar 1 funcionário pela ID inserida no método ---> retorna

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(5)
	void testAtualizarFuncionario() {

		FuncionarioService funServ = new FuncionarioService();

		try {
			FuncionarioDAO funDAO = new FuncionarioDAO();
			Funcionario funcionarioSelecionado = funDAO.encontrarFuncionarioDAO(2);

			System.out.println(funcionarioSelecionado); // Antes

			funcionarioSelecionado.setNome("Joana Pires"); // Nome que entrará na tabela "Funcionário", no lugar de outro cujo registro possui ID = 2 (de "Maria Silva" vai para "Joana Pires")

			funServ.AtualizarFuncionario(2, funcionarioSelecionado);

			System.out.println(funcionarioSelecionado); // Depois

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(6)
	void testDeletarFuncionario() {
		FuncionarioService funServ = new FuncionarioService();
		try {
			funServ.DeletarFuncionario(1); // Remove da Tabela 'Funcionario', o registro correspondente à ID inserida na função (Nesse caso, o registro com o nome a ID = 1, será deletado)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
