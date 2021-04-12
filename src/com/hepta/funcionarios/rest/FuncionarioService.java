package com.hepta.funcionarios.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.persistence.FuncionarioDAO;

@Path("/funcionarios")
public class FuncionarioService {

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private FuncionarioDAO dao;

	public FuncionarioService() {
		dao = new FuncionarioDAO();
	}

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * Adiciona novo Funcionario
	 * 
	 * @param Funcionario: Novo Funcionario
	 * @return response 200 (OK) - Conseguiu adicionar
	 */
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) //post => consumir/receber JSON
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response CriarFuncionario(Funcionario variavelFuncionario) {
		//variavelFuncionario  = new Funcionario();
		try {
			 dao.salvarFuncionarioDAO(variavelFuncionario);
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao tentar inserir o funcionário!").build();
		}
		
		return Response.status(Status.OK).build();
	}
	
	

	/**
	 * Lista todos os Funcionarios
	 * 
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response ListarFuncionarios() {
		List<Funcionario> variavelFuncionario = new ArrayList<>();
		try {
			variavelFuncionario = dao.listarTodosFuncionariosDAO();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar os Funcionarios!").build();
		}

		GenericEntity<List<Funcionario>> entity = new GenericEntity<List<Funcionario>>(variavelFuncionario) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	
	/**
	 * Encontrar 1 Funcionario
	 * 
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response EncontrarFuncionario(@PathParam("id") Integer id) {
		 
		try {
			 dao.encontrarFuncionarioDAO(id);
			 //Funcionario fun = dao.encontrarFuncionarioNoBanco(2);
	            //System.out.println("func = " + fun);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao tentar encontrar o Funcionário!").build();
		}

			
		return Response.status(Status.OK).build();
	}
	
	

	/**
	 * Atualiza um Funcionario
	 * 
	 * @param id:          id do Funcionario
	 * @param Funcionario: Funcionario atualizado
	 * @return response 200 (OK) - Conseguiu atualizar
	 */
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON) //put => consumir/receber JSON
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response AtualizarFuncionario(@PathParam("id") Integer id, Funcionario variavelFuncionario) {
		//variavelFuncionario  = new Funcionario();
		try {
			 //dao.encontrarFuncionarioNoBanco(id);
			 //dao.encontrarFuncionarioDAO(id).setNome("teste");
			 dao.atualizarFuncionarioDAO(variavelFuncionario);
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao tentar atualizar o funcionário!").build();
		}
		
		return Response.status(Status.OK).build();
	}
	

	/**
	 * Remove um Funcionario
	 * 
	 * @param id: id do Funcionario
	 * @return response 200 (OK) - Conseguiu remover
	 */
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response DeletarFuncionario(@PathParam("id") Integer id) {
		try {
			 dao.deletarFuncionarioDAO(id);
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao tentar remover o funcionário!").build();
		}
		
		return Response.status(Status.OK).build();
	}
	
	

}
