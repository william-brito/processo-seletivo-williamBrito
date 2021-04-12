package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;

class SetorServiceTest {

	@Test
	void testCriarSetor() {
		SetorService setServ = new SetorService();
		Setor s = new Setor();

		s.setId(null); // Est� como "null" pois as ID's s�o geradas automaticamente!
		s.setNome("Financeiro");

		setServ.CriarSetor(s);
	}

	@Test
	void testListarSetores() {
		SetorService setServ = new SetorService();

		try {

			setServ.ListarSetores(); // retorna "response" (Analisar depois)

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testEncontrarSetor() {
		SetorService setServ = new SetorService();

		try {
			setServ.EncontrarSetor(2); // Encontrar 1 setor pela ID inserida no m�todo ---> retorna "response"

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testAtualizarSetor() {
		
		SetorService setServ = new SetorService();

        try {
        	SetorDAO setDAO = new SetorDAO();
        	Setor setorSelecionado = setDAO.encontrarSetorDAO(2);
        				
            System.out.println(setorSelecionado); //Antes
			
            setorSelecionado.setNome("R.H"); //Nome que entrar� na tabela "Setor", no lugar de outro cujo registro possui ID = 2
			
            setServ.AtualizarSetor(2, setorSelecionado);
			
			System.out.println(setorSelecionado); //Depois
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testDeletarSetor() { //Falta implementar l�gica para Banco de Dados (Tabela com refer�ncia em outra tabela)
		//SetorService funDAO = new SetorService();
		try {
			//funDAO.deletarSetor(8); //Remove da Tabela 'Setor', o registro correspondente � ID inserida na fun��o
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
