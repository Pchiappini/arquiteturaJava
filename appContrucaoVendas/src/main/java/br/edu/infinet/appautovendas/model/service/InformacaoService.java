package br.edu.infinet.appautovendas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appautovendas.clients.IInformacaoClient;
import br.edu.infinet.appautovendas.model.domain.Informacao;

@Service
public class InformacaoService {
	
	@Autowired
	public IInformacaoClient informacaoClient;
	
	public List<Informacao> obterLista(){
		return informacaoClient.obterLista();
	}
	
	public Informacao incluir (Informacao informacao) {
		return informacaoClient.incluir(informacao);
	}

}


/*

	@GetMapping(value = "/lista")
	public List<Informacao> obterLista();
	
	@PostMapping(value="incluir")
	public Informacao incluir (Informacao informacao);
*/