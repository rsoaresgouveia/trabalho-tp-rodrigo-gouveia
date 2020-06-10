package com.example.trabalho_tp_02_android_rodrigo_soares;

import java.io.Serializable;

public class Traveler implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String nome, email, telefone, cpf,localidade;

	public Traveler(String nome, String email, String telefone, String cpf,
			String localidade) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.localidade = localidade;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
}
