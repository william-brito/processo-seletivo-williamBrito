package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Setor;

class SetorServiceTest {

	@Test
	void testCriarSetor() {
		SetorService SetServ = new SetorService();
		Setor s = new Setor();
		
		s.setId(null); // Está como "null" pois as ID's são geradas automaticamente!
	    s.setNome("Financeiro");
	    
	    SetServ.CriarSetor(s);
	}

	@Test
	void testListarSetores() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizarSetor() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletarSetor() {
		fail("Not yet implemented");
	}

}
