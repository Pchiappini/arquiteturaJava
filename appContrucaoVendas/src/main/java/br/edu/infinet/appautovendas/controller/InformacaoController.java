package br.edu.infinet.appautovendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.appautovendas.model.domain.Informacao;
import br.edu.infinet.appautovendas.model.service.InformacaoService;

@Controller
public class InformacaoController {

	@Autowired
	private InformacaoService informacaoService;
	
	// <form action="/informacao/incluir" method="post">
	@PostMapping(value = "/informacao/incluir")
	//public String incluir(String campo, String descricao) {
	public String incluir(Informacao informacao) {
		
		System.out.println("Informação: " + informacao);
		
		Informacao result = informacaoService.incluir(informacao);
		
		System.out.println("Result: " + result);

		//System.out.println("Informação: " + informacao);
		return "redirect:/"; // reiniciar o mapeamento
	}

}
