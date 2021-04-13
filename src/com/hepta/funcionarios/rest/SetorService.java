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

import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;

public class SetorService {

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private SetorDAO dao;

	public SetorService() {
		dao = new SetorDAO();
	}

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * Adiciona novo Setor
	 * 
	 * @param Funcionario: Novo Setor
	 * @return response 200 (OK) - Conseguiu adicionar
	 */
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) // post => consumir/receber JSON
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response CriarSetor(Setor variavelSetor) {
		try {
			dao.salvarSetorDAO(variavelSetor);

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao tentar inserir o setor!").build();
		}

		return Response.status(Status.OK).build();
	}

	/**
	 * Lista todos os Setores
	 * 
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response ListarSetores() {
		List<Setor> variavelSetor = new ArrayList<>();
		try {
			variavelSetor = dao.listarTodosSetoresDAO();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar os Setores!").build();
		}

		GenericEntity<List<Setor>> entity = new GenericEntity<List<Setor>>(variavelSetor) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	/**
	 * Encontrar 1 Setor
	 * 
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response EncontrarSetor(@PathParam("id") Integer id) {
		try {
			dao.encontrarSetorDAO(id);

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao tentar encontrar o Setor!").build();
		}

		return Response.status(Status.OK).build();
	}

	/**
	 * Atualiza um Setor
	 * 
	 * @param id:          id do Setor
	 * @param Funcionario: Setor atualizado
	 * @return response 200 (OK) - Conseguiu atualizar
	 */
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON) // put => consumir/receber JSON
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response AtualizarSetor(@PathParam("id") Integer id, Setor variavelSetor) {
		try {
			dao.atualizarSetorDAO(variavelSetor);

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao tentar atualizar o Setor!").build();
		}

		return Response.status(Status.OK).build();
	}

	/**
	 * Remove um Setor
	 * 
	 * @param id: id do Setor
	 * @return response 200 (OK) - Conseguiu remover
	 */
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response deletarSetor(@PathParam("id") Integer id) {
		try {
			dao.deletarSetorDAO(id);

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao tentar remover o Setor!").build();
		}

		return Response.status(Status.OK).build();
	}

}
