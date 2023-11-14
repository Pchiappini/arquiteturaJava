
package br.edu.infinet.appautovendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.appautovendas.model.domain.Ferragem;
import br.edu.infinet.appautovendas.model.domain.Vendedor;
import br.edu.infinet.appautovendas.model.service.FerragemService;

@Order(3)
@Component
public class FerragemLoader implements ApplicationRunner{

	@Autowired
	private FerragemService ferragemService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/ferragem.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			
			campos=linha.split(";");
			
			Ferragem ferragem = new Ferragem();
			
			ferragem.setCodigo(Integer.valueOf(campos[0]));
			ferragem.setDescricao(campos[1]);
			ferragem.setEstoque(Boolean.valueOf(campos[2]));
			ferragem.setPreco(Float.valueOf(campos[3]));
			ferragem.setTipo(campos[4]);
			ferragem.setNacional(Boolean.valueOf(campos[5]));
			
			Vendedor vendedor = new Vendedor();
			
			vendedor.setId(Integer.valueOf(campos[6]));
			
			ferragem.setVendedor(vendedor);
			
			System.out.println("[Ferragem]" + ferragem);
			
			linha = leitura.readLine();
		}
		
		for (Ferragem ferragem: ferragemService.obterLista()) {
			System.out.println("[Ferragem]" + ferragem);
			
			}		
				
		    leitura.close();		
				
	}
	
	
}
