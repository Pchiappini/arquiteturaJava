package br.edu.infinet.appautovendas;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.appautovendas.model.domain.Ferragem;
import br.edu.infinet.appautovendas.model.domain.Produto;
import br.edu.infinet.appautovendas.model.domain.Tijolo;
import br.edu.infinet.appautovendas.model.domain.Vendedor;
import br.edu.infinet.appautovendas.model.service.ProdutoService;
import br.edu.infinet.appautovendas.model.service.VendedorService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner{
	
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produtos.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		Vendedor vendedor = new Vendedor();
		
		while(linha != null) {
			
			campos=linha.split(";");
			
			switch (campos[6]) {
			case "F":

				Ferragem ferragem = new Ferragem();
				
				ferragem.setCodigo(Integer.valueOf(campos[0]));
				ferragem.setDescricao(campos[1]);
				ferragem.setEstoque(Boolean.valueOf(campos[2]));
				ferragem.setPreco(Float.valueOf(campos[3]));
				ferragem.setTipo(campos[4]);
				ferragem.setNacional(Boolean.valueOf(campos[5]));
								
				vendedor.setId(Integer.valueOf(campos[7]));
				
				ferragem.setVendedor(vendedor);		
								
				
				try {
					produtoService.incluir(ferragem);
				}catch (ConstraintViolationException e ) {
					System.out.println("[PRODUTO]: " + ferragem );
					FileLogger.logException("[PRODUTO]: " + ferragem );
				}
				
				//produtoService.incluir(ferragem);
				
				break;
				
			case "T":
				
				Tijolo tijolo = new Tijolo();
				
				tijolo.setCodigo(Integer.valueOf(campos[0]));
				tijolo.setDescricao(campos[1]);
				tijolo.setEstoque(Boolean.valueOf(campos[2]));
				tijolo.setPreco(Float.valueOf(campos[3]));
				tijolo.setTamanho(campos[4]);
				tijolo.setTipoMaterial(campos[5]);

				vendedor.setId(Integer.valueOf(campos[7]));
				
				tijolo.setVendedor(vendedor);
				
				try {
					produtoService.incluir(tijolo);
				}catch (ConstraintViolationException e ) {
					System.out.println("[PRODUTO]: " + tijolo );
					FileLogger.logException("[PRODUTO]: " + tijolo );
				}
				//produtoService.incluir(tijolo);
				
				break;

			default:
				break;
			}
			
			linha = leitura.readLine();
		}
		
		for(Vendedor v : vendedorService.obterLista()) {
			for(Produto produto: produtoService.obterLista(v)) {
				System.out.println("[Produto]" + produto);
			}
			
		}
			
/*			for (Produto produto: produtoService.obterLista()) {
				System.out.println("[Produto]" + produto);	
				}
			System.out.println("Produtos do vendedor: " + vendedor.getId());
			for(Produto produto: produtoService.obterLista(vendedor.getId())) {
				System.out.println("[Produto]" + produto);
			}
			for(Produto produto: produtoService.obterLista(vendedor)) {
				System.out.println("[Produto]" + produto);
			}
*/
			
		    leitura.close();
		
}
}
