package com.hepta.funcionarios.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioDAO {
	
	
	//Salvar funcion�rio no Banco de Dados
	public void salvarFuncionarioDAO(Funcionario variavelFuncionarioDAO) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager(); //do HibernateUtil.java
				
		try {
			em.getTransaction().begin(); //iniciar transa��o com o Banco de Dados
			em.persist(variavelFuncionarioDAO);
			em.getTransaction().commit(); //confirmar
		} catch (Exception e) {
			em.getTransaction().rollback(); //desfazer em caso de inconsist�ncia
			throw new Exception(e);
		} finally {
			em.close();
		}
			
	}
	
	//Atualizar funcion�rio no Banco de Dados
	public Funcionario atualizarFuncionarioDAO(Funcionario variavelFuncionarioDAO) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Funcionario FuncionarioAtualizado = null;
		try {
			em.getTransaction().begin();
			FuncionarioAtualizado = em.merge(variavelFuncionarioDAO);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return FuncionarioAtualizado;
	}

	//Deletar funcion�rio do Banco de Dados
	public void deletarFuncionarioDAO(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Funcionario variavelFuncionarioDAO = em.find(Funcionario.class, id); // "monitorar" entidade, antes de deletar
			em.remove(variavelFuncionarioDAO); //remover funcion�rio
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}

	}

	//Encontrar 1 funcion�rio no Banco de Dados
	public Funcionario encontrarFuncionarioDAO(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Funcionario variavelFuncionarioDAO = null;
		try {
			variavelFuncionarioDAO = em.find(Funcionario.class, id); //buscar 
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return variavelFuncionarioDAO;
	}

	
	//Listar todos os funcion�rio do Banco de Dados
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarTodosFuncionariosDAO() throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		List<Funcionario> variavelFuncionarioDAO = new ArrayList<>();
		try {
			Query query = em.createQuery("FROM Funcionario");
			variavelFuncionarioDAO = query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return variavelFuncionarioDAO;
	}
		

}
