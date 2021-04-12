package com.hepta.funcionarios.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hepta.funcionarios.entity.Setor;

public class SetorDAO {

	// Salvar o Setor no Banco de Dados
	public void salvarSetorNoBanco(Setor variavelSetorDAO) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager(); // do HibernateUtil.java

		try {
			em.getTransaction().begin(); // iniciar transação com o Banco de Dados
			em.persist(variavelSetorDAO);
			em.getTransaction().commit(); // confirmar
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfazer em caso de inconsistência
			throw new Exception(e);
		} finally {
			em.close();
		}

	}

	// Atualizar o Setor no Banco de Dados
	public Setor atualizarSetorNoBanco(Setor variavelSetorDAO) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Setor SetorAtualizado = null;
		try {
			em.getTransaction().begin();
			SetorAtualizado = em.merge(variavelSetorDAO);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return SetorAtualizado;
	}
	
	//Deletar o Setor do Banco de Dados
	public void deletarSetorDoBanco(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Setor variavelSetorDAO = em.find(Setor.class, id); // "monitorar" entidade, antes de deletar
			em.remove(variavelSetorDAO); //remover funcionário
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}

	}

	//Encontrar o Setor no Banco de Dados
	public Setor encontrarSetorNoBanco(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Setor variavelSetorDAO = null;
		try {
			variavelSetorDAO = em.find(Setor.class, id); //buscar 
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return variavelSetorDAO;
	}

	@SuppressWarnings("unchecked")
	public List<Setor> getAll() throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		List<Setor> variavelSetorDAO = new ArrayList<>();
		try {
			Query query = em.createQuery("FROM Setor");
			variavelSetorDAO = query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return variavelSetorDAO;
	}
		


}
