package com.hepta.funcionarios.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

class FuncionarioDAOTest {

	@Test
	void testSalvarFuncionarioDAO() {
		FuncionarioDAO funDAO = new FuncionarioDAO();

		Funcionario f = new Funcionario();
		Setor s = new Setor();

		s.setId(1); // Definir uma ID correspondente ao Setor na tabela "Setor".

		f.setId(null); // ID's gerados automaticamente!
		f.setNome("William Brito");
		f.setSetor(s); // chave estrangeira
		f.setSalario(1000.0);
		f.setEmail("william@tester.com");
		f.setIdade(21);

		try {
			funDAO.salvarFuncionarioDAO(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
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
	void testEncontrarFuncionarioDAO() {
		FuncionarioDAO funDAO = new FuncionarioDAO();
		
		try {
			Funcionario funcionarioEncontrado = funDAO.encontrarFuncionarioDAO(2); //Encontrar 1 funcionário pela ID inserida no método
			System.out.println(funcionarioEncontrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}


	@Test
	void testAtualizarFuncionarioDAO() { //Testando atualização de nome
        FuncionarioDAO funDAO = new FuncionarioDAO();
		
        try {
        	Funcionario funcionarioSelecionado = funDAO.encontrarFuncionarioDAO(2); //ID do funcionário ao qual se deseja atualizar alguma informação
			System.out.println(funcionarioSelecionado); //Antes
			
			funcionarioSelecionado.setNome("Lorena Gomez"); //Nome que entrará na tabela "Funcionário", no lugar de outro cujo registro possui ID = 2
			
			funDAO.atualizarFuncionarioDAO(funcionarioSelecionado);
			
			System.out.println(funcionarioSelecionado); //Depois
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	@Test
	void testDeletarFuncionarioDAO() {
		FuncionarioDAO funDAO = new FuncionarioDAO();
		try {
			funDAO.deletarFuncionarioDAO(4); //Remove da Tabela 'Funcionario', o registro correspondente à ID inserida na função
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
