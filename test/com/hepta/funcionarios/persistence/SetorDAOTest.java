package com.hepta.funcionarios.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.hepta.funcionarios.entity.Setor;

@TestMethodOrder(OrderAnnotation.class)
class SetorDAOTest {

	@Test
	@Order(1)
	void testSalvarSetorDAO() throws Exception {
		SetorDAO setDAO = new SetorDAO();
		Setor s = new Setor();

		s.setId(null); // Est� como "null" pois as ID's s�o geradas automaticamente!
		s.setNome("Marketing");

		setDAO.salvarSetorDAO(s);
	}

	@Test
	@Order(2)
	void testListarTodosSetoresDAO() {

		SetorDAO setDAO = new SetorDAO();

		try {
			List<Setor> listaSetores = setDAO.listarTodosSetoresDAO();
			for (Setor setoresForEach : listaSetores) {
				System.out.println(setoresForEach);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(3)
	void testEncontrarSetorDAO() {
		SetorDAO setDAO = new SetorDAO();

		try {
			Setor setorEncontrado = setDAO.encontrarSetorDAO(1); // Encontrar 1 setor pela ID inserida no m�todo
			System.out.println(setorEncontrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(4)
	void testAtualizarSetorDAO() {
		 SetorDAO setDAO = new SetorDAO();
			
	        try {
	        	Setor setorSelecionado = setDAO.encontrarSetorDAO(1); //ID do funcion�rio ao qual se deseja atualizar alguma informa��o
				System.out.println(setorSelecionado); //Antes
				
				setorSelecionado.setNome("Administrativo"); //Nome que entrar� na tabela "Setor", no lugar de outro cujo registro possui ID = 2 (de "TI" vai para "Administrativo")
				
				setDAO.atualizarSetorDAO(setorSelecionado);
				
				System.out.println(setorSelecionado); //Depois
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Test
	@Order(5)
	void testDeletarSetorDAO() { //Falta implementar l�gica para Banco de Dados (Tabela com refer�ncia em outra tabela)
		//SetorDAO setDAO = new SetorDAO();
		try {
			//setDAO.deletarSetorDAO(8); //Remove da Tabela 'Setor', o registro correspondente � ID inserida na fun��o
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
