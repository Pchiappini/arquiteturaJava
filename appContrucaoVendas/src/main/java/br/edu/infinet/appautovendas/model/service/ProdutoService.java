package br.edu.infinet.appautovendas.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.appautovendas.model.domain.Produto;

@Service
public class ProdutoService {
private Map<Integer, Produto> mapaProduto = new HashMap<Integer, Produto>(); 
    
	public void incluir(Produto produto) {
		mapaProduto.put(produto.getCodigo(), produto);
	}
	
	public Collection<Produto> obterLista(){
		return mapaProduto.values();
	}
}