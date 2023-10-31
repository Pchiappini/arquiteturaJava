package br.edu.infinet.appautovendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appautovendas.model.domain.Ferragem;
import br.edu.infinet.appautovendas.model.repository.FerragemRepository;

@Service
public class FerragemService {
	
	@Autowired
	private FerragemRepository ferragemRepository;
	
	public void incluir(Ferragem ferragem) {
	//	mapaFerragem.put(ferragem.getTipo(), ferragem);
		ferragemRepository.save(ferragem);
		
	}   
	
	public Collection<Ferragem> obterLista(){
		return (Collection<Ferragem>) ferragemRepository.findAll();
	}
}
