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
		f.setNome("João Cardozo");
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
			Funcionario funcionarioEncontrado = funDAO.encontrarFuncionarioDAO(2); //Encontrar 1 funcionário pela ID inserida no método
			System.out.println(funcionarioEncontrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}


	@Test
	@Order(4)
	void testAtualizarFuncionarioDAO() { //Testando atualização de nome
        FuncionarioDAO funDAO = new FuncionarioDAO();
		
        try {
        	Funcionario funcionarioSelecionado = funDAO.encontrarFuncionarioDAO(3); //ID do funcionário ao qual se deseja atualizar alguma informação
			System.out.println(funcionarioSelecionado); //Antes
			
			funcionarioSelecionado.setNome("Francisca Gomez"); //Nome que entrará na tabela "Funcionário", no lugar de outro cujo registro possui ID = 2 ("João Cardozo" mudará para "Francisca Gomez")
			
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
			funDAO.deletarFuncionarioDAO(2); //Remove da Tabela 'Funcionario', o registro correspondente à ID inserida na função
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
