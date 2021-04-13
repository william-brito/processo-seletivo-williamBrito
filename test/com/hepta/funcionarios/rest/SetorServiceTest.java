package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;

@TestMethodOrder(OrderAnnotation.class)
class SetorServiceTest {

	@Test
	@Order(1)
	void testCriarSetor() {
		SetorService setServ = new SetorService();
		Setor s = new Setor();

		s.setId(null); // Está como "null" pois as ID's são geradas automaticamente!
		s.setNome("Financeiro");

		setServ.CriarSetor(s);
	}

	@Test
	@Order(2)
	void testListarSetores() {
		SetorService setServ = new SetorService();

		try {

			setServ.ListarSetores(); // retorna "response" (Analisar depois)

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(3)
	void testEncontrarSetor() {
		SetorService setServ = new SetorService();

		try {
			setServ.EncontrarSetor(2); // Encontrar 1 setor pela ID inserida no método ---> retorna "response"

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(4)
	void testAtualizarSetor() {
		
		SetorService setServ = new SetorService();

        try {
        	SetorDAO setDAO = new SetorDAO();
        	Setor setorSelecionado = setDAO.encontrarSetorDAO(2);
        				
            System.out.println(setorSelecionado); //Antes
			
            setorSelecionado.setNome("R.H"); //Nome que entrará na tabela "Setor", no lugar de outro cujo registro possui ID = 2
			
            setServ.AtualizarSetor(2, setorSelecionado);
			
			System.out.println(setorSelecionado); //Depois
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(5)
	void testDeletarSetor() { //Falta implementar lógica para Banco de Dados (Tabela com referência em outra tabela)
		//SetorService funDAO = new SetorService();
		try {
			//funDAO.deletarSetor(8); //Remove da Tabela 'Setor', o registro correspondente à ID inserida na função
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
