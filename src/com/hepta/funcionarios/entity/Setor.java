package com.hepta.funcionarios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SETOR")
	private Integer id;

	@Column(name = "NOME_SETOR", length = 30) //nome da coluna na tabela + tamanho do Varchar, no Banco de Dados
	private String nome;
	
	public Setor() {
	}

	public Setor(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
