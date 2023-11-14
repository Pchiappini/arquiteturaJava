package br.edu.infinet.appautovendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infinet.appautovendas.model.service.FerragemService;
import br.edu.infinet.appautovendas.model.service.ProdutoService;
import br.edu.infinet.appautovendas.model.service.TijoloService;
import br.edu.infinet.appautovendas.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private FerragemService ferragemService;
	@Autowired
	private TijoloService tijoloService;
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value="/")
	public String showHome(Model model) {
		//model.addAttribute("listagem",vendedorService.obterLista());
		//model.addAttribute("qtdVendedor", vendedorService.obterLista().size());
		model.addAttribute("qtdVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdProduto", produtoService.obterQtde());
		model.addAttribute("qtdFerragem",ferragemService.obterQtde());
		model.addAttribute("qtdTijolo",tijoloService.obterQtde());
		return "home";
	}

	@GetMapping(value="/produto/lista")
	public String obterListaProduto(Model model) {
		model.addAttribute("titulo","Produtos:");
		model.addAttribute("listagem",produtoService.obterLista());
		return showHome(model);
	}
	@GetMapping(value="/ferragem/lista")
	public String obterListaFerragem(Model model) {
		model.addAttribute("titulo","Tijolos:");
		model.addAttribute("listagem",ferragemService.obterLista());
		return showHome(model);
	}
	@GetMapping(value="/tijolo/lista")
	public String obterListaTijolo(Model model) {
		model.addAttribute("titulo","Ferragem:");
		model.addAttribute("listagem",tijoloService.obterLista());
		return showHome(model);
	}

	

}