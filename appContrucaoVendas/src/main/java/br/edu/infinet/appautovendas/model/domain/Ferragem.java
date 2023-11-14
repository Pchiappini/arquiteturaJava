package br.edu.infinet.appautovendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="FERRAGEM")
public class Ferragem extends Produto {
	
	@Size(min = 2, max = 20, message = "O Tipo deve ter entre {min} e {max} caracteres.")
	private String tipo;
	private boolean nacional;
		
	public String toString() {
		return String.format("%s - Tipo (%s) - nacional (%s)", super.toString() ,tipo, nacional);	
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isNacional() {
		return nacional;
	}

	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}
	
}
