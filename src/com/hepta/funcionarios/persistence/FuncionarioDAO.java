package com.hepta.funcionarios.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioDAO {

	public void save(Funcionario Funcionario) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager(); //do HibernateUtil.java
		try {
			em.getTransaction().begin(); //iniciar transação com o Banco de Dados
			em.persist(Funcionario);
			em.getTransaction().commit(); //confirmar
		} catch (Exception e) {
			em.getTransaction().rollback(); //desfazer em caso de inconsistência
			throw new Exception(e);
		} finally {
			em.close();
		}
	}

	public Funcionario update(Funcionario Funcionario) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Funcionario FuncionarioAtualizado = null;
		try {
			em.getTransaction().begin();
			FuncionarioAtualizado = em.merge(Funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return FuncionarioAtualizado;
	}

	public void delete(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Funcionario Funcionario = em.find(Funcionario.class, id); // "monitorar" entidade, antes de deletar
			em.remove(Funcionario); //remover funcionário
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}

	}

	public Funcionario find(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Funcionario Funcionario = null;
		try {
			Funcionario = em.find(Funcionario.class, id); //buscar 
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return Funcionario;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getAll() throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		List<Funcionario> Funcionarios = new ArrayList<>();
		try {
			Query query = em.createQuery("FROM Funcionario");
			Funcionarios = query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return Funcionarios;
	}

}
