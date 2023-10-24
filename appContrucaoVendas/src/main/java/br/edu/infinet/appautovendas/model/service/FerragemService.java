package br.edu.infinet.appautovendas.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.appautovendas.model.domain.Ferragem;

@Service
public class FerragemService {
	
private Map<String, Ferragem> mapaFerragem = new HashMap<String, Ferragem>(); 
    
	public void incluir(Ferragem ferragem) {
		mapaFerragem.put(ferragem.getTipo(), ferragem);
	}   
	
	public Collection<Ferragem> obterLista(){
		return mapaFerragem.values();
	}
}
