package com.hepta.funcionarios.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

public class FuncionarioHibernateTest {
	public static void main(String[] args) {

		// List<Setor> listaSetor = new ArrayList<>();
		// Setor s1 = new Setor(null, "TI");
		// listaSetor.add(s1);
		// Setor s2 = new Setor(null, "MKT");
		// listaSetor.add(s2);
		// List<Setor> listaSetor = new ArrayList<>();

		// for (setorEach: listaSetor) {

		// }

		// Funcionario f1 = new Funcionario(1, " Joao ",s1, 100.0, "joao@tester.com",
		// 20);
		// Funcionario f2 = new Funcionario(1, " Joana ",s1, 200.0, "joaona@tester.com",
		// 25);
		// Funcionario f3 = new Funcionario(1, " Fred ",s1, 800.0, " fred@agency.com",
		// 31);

		// int id = f1.getSetor().getId();

		Funcionario f = new Funcionario();
		Setor s = new Setor();

		s.setId(null);
		s.setNome("TI");

		f.setId(null);
		f.setNome("Felizardo Alves");
		f.setSetor(s); //chave estrangeira
		f.setSalario(1000.0);
		f.setEmail("felizardo@gmail.com");
		f.setIdade(20);

		// System.out.println("ID: "+f1.getId()+" || Nome: "+f1.getNome()+" || Setor:
		// "+f1.getSetor()+" || Salário: "+f1.getSalario()+" || Email: "+f1.getEmail()+"
		// || Idade: "+f1.getIdade());
		// System.out.println("ID: "+f2.getId()+" || Nome: "+f2.getNome()+" || Setor:
		// "+f2.getSetor()+" || Salário: "+f2.getSalario()+" || Email: "+f2.getEmail()+"
		// || Idade: "+f1.getIdade());
		// System.out.println("ID: "+f3.getId()+" || Nome: "+f3.getNome()+" || Setor:
		// "+f3.getSetor()+" || Salário: "+f3.getSalario()+" || Email: "+f3.getEmail()+"
		// || Idade: "+f1.getIdade());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("funcionarios-bd");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(s); //Primeiro o Setor, depois o Funcionário
		em.persist(f);
		// em.persist(f);
		// em.persist(f);

		em.getTransaction().commit();

		System.out.println("Pronto!!");

		// System.out.println("ID: "+f1.getId()+" || Nome: "+f1.getNome()+" || Salário:
		// "+f1.getSalario()+" || Email: "+f1.getEmail()+" || Idade: "+f1.getIdade());
		// System.out.println("ID: "+f2.getId()+" || Nome: "+f2.getNome()+" || Salário:
		// "+f2.getSalario()+" || Email: "+f2.getEmail()+" || Idade: "+f1.getIdade());
		// System.out.println("ID: "+f3.getId()+" || Nome: "+f3.getNome()+" || Salário:
		// "+f3.getSalario()+" || Email: "+f3.getEmail()+" || Idade: "+f1.getIdade());

	}

}

