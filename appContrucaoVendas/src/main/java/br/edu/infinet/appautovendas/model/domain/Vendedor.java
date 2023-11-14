package br.edu.infinet.appautovendas.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
//@Table(name="VENDEDOR")

@Table(name = "VENDEDOR", 
uniqueConstraints = {
		@UniqueConstraint(columnNames = {"cpf"}),
		@UniqueConstraint(columnNames = {"email"})})
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 2, max = 100)
	private String nome;
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
	//@Column(unique = true )
	private String cpf;
	@Size(min = 2, max = 50)
	//@Column(unique = true )
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdVendedor")
	private List<Produto> produtos;
	
	@OneToOne(cascade = CascadeType.PERSIST) //efetua a persistencia do Endereco e Vendedor ao mesmo tempo
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public String toString() {
		//return String.format("%d - %s - %s - %s - %d", id, nome, cpf, email, produtos.size());
		return String.format("id (%d) - nome (%s) - cpf (%s) - email (%s) - endereco (%s) - produtos (%d)", 
				id, nome, cpf, email, endereco,
				//operador alternario
				produtos != null ? produtos.size(): 0);
	}	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
