package br.edu.infinet.appautovendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name="PRODUTO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@PositiveOrZero
	private int codigo;
	@Positive
	private float preco;
	@NotNull
	private boolean estoque;
	
	@ManyToOne
	@JoinColumn(name = "IdVendedor")
	private Vendedor vendedor;
	
	@Override
	public String toString() {
		return String.format("id (%d) - descricao (%s) - codigo (%d) - preço (%.2f) - estoque (%s)", id, descricao, codigo, preco, estoque);
		//return String.format("%s - %s - %d", super.toString(), marca, garantiaMeses);
	}
	
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}



	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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
