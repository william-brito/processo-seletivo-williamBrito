/*package com.hepta.funcionarios.persistence;

import java.util.List;

import javax.ws.rs.core.Response;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.rest.FuncionarioService;
import com.hepta.funcionarios.rest.SetorService;

public class FuncionarioHibernateTest {
	public static void main(String[] args) throws Exception {
		
		//FuncionarioDAO fdao = new FuncionarioDAO();
		
		
		//Teste de inser��o no Banco de Dados - OK
		
		FuncionarioService funServ = new FuncionarioService();
		SetorService SetServ = new SetorService();
		Funcionario f = new Funcionario();
		Setor s = new Setor();
	
		s.setId(null); //ID's gerados automaticamente!
		s.setNome("TI");
		
		f.setId(null); //ID's gerados automaticamente!
		f.setNome("Felizardo Alves");
		f.setSetor(s); //chave estrangeira
		f.setSalario(1000.0);
		f.setEmail("felizardo@gmail.com");
		f.setIdade(20);
		
		//fdao.save(s);	
		SetServ.CriarSetor(s); //Inserir o setor primeiro, devido � chave estrangeira na tabela Funcion�rio
		
		funServ.CriarFuncionario(f);
		//fdao.salvarFuncionarioNoBanco(f);
		
		
		
		//Teste de atualiza��o no Banco de Dados -
		
		
		
		
		
		//deletar
        
		FuncionarioDAO funDAO = new FuncionarioDAO();
		
		//SetorService SetServ = new SetorService();
		
		//Funcionario f = new Funcionario();
		
		//Setor s = new Setor();
	 	//List <Funcionario> fun = funDAO.listarTodosFuncionariosDoBanco();
		
		//Funcionario fun = funDAO.encontrarFuncionarioDAO(14);
		
		//System.out.println(fun);
		
				
		funDAO.deletarFuncionarioDAO(16);
		
		System.out.println(fun);
		
		//for(Funcionario funEach: fun) {
		//	System.out.println(funEach);

		//}
		
				
		//s.setId(4); //ID's gerados automaticamente!
	    //s.setNome("Marketing");
		
		//f.setId(null); //ID's gerados automaticamente!
		
		//f.setSetor(s); //chave estrangeira
		//f.setSalario(1000.0);
		//f.setEmail("felizardo@gmail.com");
		//f.setIdade(20);
		//Funcionario fun = daoo.encontrarFuncionarioNoBanco(2);
		
		//System.out.println(fun);
				
		//f.setNome("Jorge Alves");
				
		//funServ.AtualizarFuncionario(2, f);
		
		
		
		//atualizar
		FuncionarioService funServ = new FuncionarioService();
		
		SetorService SetServ = new SetorService();
		
		Funcionario f = new Funcionario();
		
		Setor s = new Setor();
	 
		
				
		s.setId(4); //ID's gerados automaticamente!
	    s.setNome("Marketing");
		
		f.setId(null); //ID's gerados automaticamente!
		
		f.setSetor(s); //chave estrangeira
		f.setSalario(1000.0);
		f.setEmail("felizardo@gmail.com");
		f.setIdade(20);
		funServ.EncontrarFuncionario(2);
				
		f.setNome("Jorge Alves");
				
		funServ.AtualizarFuncionario(2, f);
		
		
		
		
		//SetServ.CriarSetor(s); //Inserir o setor primeiro, devido � chave estrangeira na tabela Funcion�rio
		
		//funServ.CriarFuncionario(f);
		
		
		*/
		
		
		
		
	/*	
	
	public void save(Funcionario func) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager(); //do HibernateUtil.java
		
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
				
		try {
			em.getTransaction().begin(); //iniciar transa��o com o Banco de Dados
			em.persist(f);
			em.getTransaction().commit(); //confirmar
		} catch (Exception e) {
			em.getTransaction().rollback(); //desfazer em caso de inconsist�ncia
			throw new Exception(e);
		} finally {
			em.close();
		}
			
	
	}
	}

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
		
		//Funcionario f = new Funcionario();
		//Setor s = new Setor();

		//s.setId(null);
		//s.setNome("TI");

		//f.setId(null);
		//f.setNome("Felizardo Alves");
		//f.setSetor(s); //chave estrangeira
		//f.setSalario(1000.0);
		//f.setEmail("felizardo@gmail.com");
		//f.setIdade(20);

		// System.out.println("ID: "+f1.getId()+" || Nome: "+f1.getNome()+" || Setor:
		// "+f1.getSetor()+" || Sal�rio: "+f1.getSalario()+" || Email: "+f1.getEmail()+"
		// || Idade: "+f1.getIdade());
		// System.out.println("ID: "+f2.getId()+" || Nome: "+f2.getNome()+" || Setor:
		// "+f2.getSetor()+" || Sal�rio: "+f2.getSalario()+" || Email: "+f2.getEmail()+"
		// || Idade: "+f1.getIdade());
		// System.out.println("ID: "+f3.getId()+" || Nome: "+f3.getNome()+" || Setor:
		// "+f3.getSetor()+" || Sal�rio: "+f3.getSalario()+" || Email: "+f3.getEmail()+"
		// || Idade: "+f1.getIdade());

		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("funcionarios-bd");
		//EntityManager em = emf.createEntityManager();

		//em.getTransaction().begin();

		//em.persist(s); //Primeiro o Setor, depois o Funcion�rio
		//em.persist(f);
		// em.persist(f);
		// em.persist(f);

		//em.getTransaction().commit();

		//System.out.println("Pronto!!");

		// System.out.println("ID: "+f1.getId()+" || Nome: "+f1.getNome()+" || Sal�rio:
		// "+f1.getSalario()+" || Email: "+f1.getEmail()+" || Idade: "+f1.getIdade());
		// System.out.println("ID: "+f2.getId()+" || Nome: "+f2.getNome()+" || Sal�rio:
		// "+f2.getSalario()+" || Email: "+f2.getEmail()+" || Idade: "+f1.getIdade());
		// System.out.println("ID: "+f3.getId()+" || Nome: "+f3.getNome()+" || Sal�rio:
		// "+f3.getSalario()+" || Email: "+f3.getEmail()+" || Idade: "+f1.getIdade());

	



*/