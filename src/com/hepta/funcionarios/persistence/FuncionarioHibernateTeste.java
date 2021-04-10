package com.hepta.funcionarios.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioHibernateTeste {

	public static void main(String[] args) {
	
		
		
		
		//Funcionario f1 = new Funcionario(1, " Joao ",s1, 100.0, " joao@tester.com", 20);
		//Funcionario f2 = new Funcionario(1, " Joana ",s2, 200.0, " joaona@tester.com", 25);
		//Funcionario f3 = new Funcionario(1, " Fred ",s1, 800.0, " fred@agency.com", 31);

		//Funcionario f1 = new Funcionario(null, " Joao ", 100.0, " joao@tester.com", 20);
		//Funcionario f2 = new Funcionario(null, " Joana ", 200.0, " joaona@tester.com", 25);
		//Funcionario f3 = new Funcionario(null, " Fred ", 800.0, " fred@agency.com", 31);
		
		//System.out.println("ID: "+f1.getId()+" || Nome: "+f1.getNome()+" || Setor: "+f1.getSetor()+" || Salário: "+f1.getSalario()+" || Email: "+f1.getEmail()+" || Idade: "+f1.getIdade());
		//System.out.println("ID: "+f2.getId()+" || Nome: "+f2.getNome()+" || Setor: "+f2.getSetor()+" || Salário: "+f2.getSalario()+" || Email: "+f2.getEmail()+" || Idade: "+f1.getIdade());
		//System.out.println("ID: "+f3.getId()+" || Nome: "+f3.getNome()+" || Setor: "+f3.getSetor()+" || Salário: "+f3.getSalario()+" || Email: "+f3.getEmail()+" || Idade: "+f1.getIdade());
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("funcionarios-bd");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//em.persist(f1);
		//em.persist(f2);
		//em.persist(f3);
		
		em.getTransaction().commit();
		
		System.out.println("Pronto!!");
		
		//System.out.println("ID: "+f1.getId()+" || Nome: "+f1.getNome()+" || Salário: "+f1.getSalario()+" || Email: "+f1.getEmail()+" || Idade: "+f1.getIdade());
		//System.out.println("ID: "+f2.getId()+" || Nome: "+f2.getNome()+" || Salário: "+f2.getSalario()+" || Email: "+f2.getEmail()+" || Idade: "+f1.getIdade());
		//System.out.println("ID: "+f3.getId()+" || Nome: "+f3.getNome()+" || Salário: "+f3.getSalario()+" || Email: "+f3.getEmail()+" || Idade: "+f1.getIdade());
		
		
		
	}
	

}