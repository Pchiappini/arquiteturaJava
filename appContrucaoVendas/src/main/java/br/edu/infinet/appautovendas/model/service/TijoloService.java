package br.edu.infinet.appautovendas.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import br.edu.infinet.appautovendas.model.domain.Tijolo;

@Service
public class TijoloService {
	
private Map<String, Tijolo> mapaTijolo = new HashMap<String, Tijolo>(); 
    
	public void incluir(Tijolo tijolo) {
		mapaTijolo.put(tijolo.getDescrição(), tijolo);
	}   
	
	public Collection<Tijolo> obterLista(){
		return mapaTijolo.values();
	}
}
