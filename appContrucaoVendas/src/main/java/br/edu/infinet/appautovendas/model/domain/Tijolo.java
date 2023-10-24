package br.edu.infinet.appautovendas.model.domain;

public class Tijolo extends Produto{
		
		
		private String tamanho;
		private String tipoMaterial;

		
		public String toString() {
			return String.format("%s - %s - %s", super.toString() ,tamanho, tipoMaterial);
		}


		public String getTamanho() {
			return tamanho;
		}


		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
		}


		public String isTipoMaterial() {
			return tipoMaterial;
		}


		public void setTipoMaterial(String tipoMaterial) {
			this.tipoMaterial = tipoMaterial;
		}	
		

}
