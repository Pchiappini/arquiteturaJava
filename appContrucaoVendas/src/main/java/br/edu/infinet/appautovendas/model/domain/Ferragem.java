package br.edu.infinet.appautovendas.model.domain;

public class Ferragem extends Produto {
	
	private String tipo;
	private boolean nacional;
		
	public String toString() {
		return String.format("%s - %s - %s", super.toString() ,tipo, nacional);	
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
