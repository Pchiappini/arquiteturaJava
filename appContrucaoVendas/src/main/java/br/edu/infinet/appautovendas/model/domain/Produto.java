package br.edu.infinet.appautovendas.model.domain;

public class Produto {

	private String descricao;
	private int codigo;
	private float preco;
	private boolean estoque;
	
	@Override
	public String toString() {
		return String.format("%s - %d - %.2f - %s", descricao, codigo, preco, estoque);
		//return String.format("%s - %s - %d", super.toString(), marca, garantiaMeses);
	}
	
	public String getDescrição() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int campos) {
		this.codigo = campos;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float campos) {
		this.preco = campos;
	}
	public boolean getEstoque() {
		return estoque;
	}
	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
	
	
	
}
