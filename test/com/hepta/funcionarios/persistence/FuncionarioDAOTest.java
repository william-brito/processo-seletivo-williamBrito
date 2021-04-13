package com.hepta.funcionarios.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

@TestMethodOrder(OrderAnnotation.class)
class FuncionarioDAOTest {

	@Test
	@Order(1)
	void testSalvarFuncionarioDAO() {
		FuncionarioDAO funDAO = new FuncionarioDAO();

		Funcionario f = new Funcionario();
		Setor s = new Setor();

		s.setId(1); // Definir uma ID correspondente ao Setor na tabela "Setor".

		f.setId(null); // ID's gerados automaticamente!
		f.setNome("Jo�o Cardozo");
		f.setSetor(s); // chave estrangeira
		f.setSalario(3500.0);
		f.setEmail("joao@tester.com");
		f.setIdade(32);

		try {
			funDAO.salvarFuncionarioDAO(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(2)
	void testListarTodosFuncionariosDAO() {
		FuncionarioDAO funDAO = new FuncionarioDAO();
		
		try {
			List <Funcionario> listaFuncionarios = funDAO.listarTodosFuncionariosDAO();
			for (Funcionario funcionariosForEach : listaFuncionarios) {
				System.out.println(funcionariosForEach);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	@Test
	@Order(3)
	void testEncontrarFuncionarioDAO() {
		FuncionarioDAO funDAO = new FuncionarioDAO();
		
		try {
			Funcionario funcionarioEncontrado = funDAO.encontrarFuncionarioDAO(2); //Encontrar 1 funcion�rio pela ID inserida no m�todo
			System.out.println(funcionarioEncontrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}


	@Test
	@Order(4)
	void testAtualizarFuncionarioDAO() { //Testando atualiza��o de nome
        FuncionarioDAO funDAO = new FuncionarioDAO();
		
        try {
        	Funcionario funcionarioSelecionado = funDAO.encontrarFuncionarioDAO(3); //ID do funcion�rio ao qual se deseja atualizar alguma informa��o
			System.out.println(funcionarioSelecionado); //Antes
			
			funcionarioSelecionado.setNome("Francisca Gomez"); //Nome que entrar� na tabela "Funcion�rio", no lugar de outro cujo registro possui ID = 2 ("Jo�o Cardozo" mudar� para "Francisca Gomez")
			
			funDAO.atualizarFuncionarioDAO(funcionarioSelecionado);
			
			System.out.println(funcionarioSelecionado); //Depois
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	@Test
	@Order(5)
	void testDeletarFuncionarioDAO() {
		FuncionarioDAO funDAO = new FuncionarioDAO();
		try {
			funDAO.deletarFuncionarioDAO(2); //Remove da Tabela 'Funcionario', o registro correspondente � ID inserida na fun��o
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
