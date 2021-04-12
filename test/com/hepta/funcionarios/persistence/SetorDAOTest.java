package com.hepta.funcionarios.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Setor;

class SetorDAOTest {

	@Test
	void testSalvarSetorNoBanco() throws Exception {
		SetorDAO SetDAO = new SetorDAO();
		Setor s = new Setor();
		
		s.setId(null); // Está como "null" pois as ID's são geradas automaticamente!
	    s.setNome("TestandoDAO");
	    
	    SetDAO.salvarSetorNoBanco(s);
	}

	@Test
	void testAtualizarSetorNoBanco() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletarSetorDoBanco() {
		fail("Not yet implemented");
	}

	@Test
	void testEncontrarSetorNoBanco() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

}
