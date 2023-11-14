package br.edu.infinet.appautovendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.appautovendas.model.domain.Tijolo;
import br.edu.infinet.appautovendas.model.domain.Vendedor;
import br.edu.infinet.appautovendas.model.service.TijoloService;

@Order(4)
@Component
public class TijoloLoader implements ApplicationRunner{

	@Autowired
	private TijoloService tijoloService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/tijolo.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			
			campos=linha.split(";");
			
			Tijolo tijolo = new Tijolo();
			
			tijolo.setCodigo(Integer.valueOf(campos[0]));
			tijolo.setDescricao(campos[1]);
			tijolo.setEstoque(Boolean.valueOf(campos[2]));
			tijolo.setPreco(Float.valueOf(campos[3]));
			tijolo.setTamanho(campos[4]);
			tijolo.setTipoMaterial(campos[5]);
			
			Vendedor vendedor = new Vendedor();
			
			vendedor.setId(Integer.valueOf(campos[6]));
			
			tijolo.setVendedor(vendedor);
			
			System.out.println("[Tijolo]" + tijolo);
			
			linha = leitura.readLine();
		}
		
		for (Tijolo tijolo: tijoloService.obterLista()) {
			System.out.println("[Tijolo]" + tijolo);
			
			}
		
		    leitura.close();		
				
	}
	
	
}
