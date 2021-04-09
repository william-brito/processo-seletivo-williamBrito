package com.hepta.funcionarios.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioDAO {
	
	

	public void save(Funcionario func) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager(); //do HibernateUtil.java
		//func = new Funcionario();
		
		//func.setNome("tester");
		//func.setSetor(new Setor());
	    //func.setSalario(4.000);
		//func.setEmail("teste@teste");
		//func.setIdade(30);
		
		try {
			em.getTransaction().begin(); //iniciar transação com o Banco de Dados
			em.persist(func);
			em.getTransaction().commit(); //confirmar
		} catch (Exception e) {
			em.getTransaction().rollback(); //desfazer em caso de inconsistência
			throw new Exception(e);
		} finally {
			em.close();
		}
			
	}

	public Funcionario update(Funcionario func) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Funcionario FuncionarioAtualizado = null;
		try {
			em.getTransaction().begin();
			FuncionarioAtualizado = em.merge(func);
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
			Funcionario func = em.find(Funcionario.class, id); // "monitorar" entidade, antes de deletar
			em.remove(func); //remover funcionário
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
		Funcionario func = null;
		try {
			func = em.find(Funcionario.class, id); //buscar 
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return func;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getAll() throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		List<Funcionario> func = new ArrayList<>();
		try {
			Query query = em.createQuery("FROM Funcionario");
			func = query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return func;
	}


}
