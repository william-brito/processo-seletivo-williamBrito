package com.hepta.funcionarios.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Setor;

class SetorDAOTest {

	@Test
	void testSalvarSetorDAO() throws Exception {
		SetorDAO setDAO = new SetorDAO();
		Setor s = new Setor();

		s.setId(null); // Est� como "null" pois as ID's s�o geradas automaticamente!
		s.setNome("Marketing");

		setDAO.salvarSetorDAO(s);
	}

	@Test
	void testListarTodosSetoresDoBanco() {

		SetorDAO setDAO = new SetorDAO();

		try {
			List<Setor> listaSetores = setDAO.listarTodosSetoresDoBanco();
			for (Setor setoresForEach : listaSetores) {
				System.out.println(setoresForEach);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testEncontrarSetorDAO() {
		SetorDAO setDAO = new SetorDAO();

		try {
			Setor setorEncontrado = setDAO.encontrarSetorDAO(2); // Encontrar 1 setor pela ID inserida no m�todo
			System.out.println(setorEncontrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testAtualizarSetorDAO() {
		 SetorDAO setDAO = new SetorDAO();
			
	        try {
	        	Setor setorSelecionado = setDAO.encontrarSetorDAO(2); //ID do funcion�rio ao qual se deseja atualizar alguma informa��o
				System.out.println(setorSelecionado); //Antes
				
				setorSelecionado.setNome("RH"); //Nome que entrar� na tabela "Setor", no lugar de outro cujo registro possui ID = 2
				
				setDAO.atualizarSetorDAO(setorSelecionado);
				
				System.out.println(setorSelecionado); //Depois
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Test
	void testDeletarSetorDAO() { //Falta implementar l�gica para Banco de Dados (Tabela com refer�ncia em outra tabela)
		//SetorDAO setDAO = new SetorDAO();
		try {
			//setDAO.deletarSetorDAO(8); //Remove da Tabela 'Setor', o registro correspondente � ID inserida na fun��o
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
