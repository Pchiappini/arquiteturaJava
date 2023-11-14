package br.edu.infinet.appautovendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appautovendas.model.domain.Tijolo;
import br.edu.infinet.appautovendas.model.repository.TijoloRepository;

@Service
public class TijoloService {
	
	@Autowired
	private TijoloRepository tijoloRepository;
 
	public void incluir(Tijolo tijolo) {
		//mapaTijolo.put(tijolo.getDescrição(), tijolo);
		tijoloRepository.save(tijolo);
	}   
	
	public Collection<Tijolo> obterLista(){
		//return mapaTijolo.values();
		return (Collection<Tijolo>) tijoloRepository.findAll();
	}
	public long obterQtde() {
		return tijoloRepository.count();
	}
}
