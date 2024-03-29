package com.hepta.funcionarios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerar os ID's automaticamente
	@Column(name = "ID_FUNCIONARIO") //nome da coluna na tabela do Banco de Dados
	private Integer id;

	@Column(name = "NOME_FUNCIONARIO", length = 100) //nome da coluna na tabela + tamanho do Varchar no Banco de Dados
	private String nome;

	@ManyToOne
	@JoinColumn(name = "FK_SETOR") //nome da coluna na tabela do Banco de Dados
	private Setor setor;

	@Column(name = "NU_SALARIO") //nome da coluna na tabela do Banco de Dados
	private Double salario;

	@Column(name = "DS_EMAIL", length = 30) //nome da coluna na tabela + tamanho do Varchar no Banco de Dados
	private String email;

	@Column(name = "NU_IDADE") //nome da coluna na tabela do Banco de Dados
	private Integer idade;
	
	public Funcionario() {
		
	}
	
	public Funcionario(Integer id, String nome, Setor setor, Double salario, String email, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.setor = setor;
		this.salario = salario;
		this.email = email;
		this.idade = idade;
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", setor=" + setor + ", salario=" + salario + ", email="
				+ email + ", idade=" + idade + "]";
	}
	
	

}
