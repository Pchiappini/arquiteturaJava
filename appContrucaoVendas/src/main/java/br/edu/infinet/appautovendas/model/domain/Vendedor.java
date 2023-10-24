package br.edu.infinet.appautovendas.model.domain;

import java.util.List;

public class Vendedor {
	private String nome;
	private String cpf;
	private String email;
	private List<Produto> produtos;
	
	public String toString() {
		return String.format("%s - %s - %s", nome, cpf, email);
		//return String.format("%s - %s - %d", super.toString(), marca, garantiaMeses);
	}	
		
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
