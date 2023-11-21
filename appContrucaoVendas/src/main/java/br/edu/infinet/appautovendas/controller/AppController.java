package br.edu.infinet.appautovendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infinet.appautovendas.model.domain.Informacao;
import br.edu.infinet.appautovendas.model.service.FerragemService;
import br.edu.infinet.appautovendas.model.service.InformacaoService;
import br.edu.infinet.appautovendas.model.service.ProdutoService;
import br.edu.infinet.appautovendas.model.service.TijoloService;
import br.edu.infinet.appautovendas.model.service.VendedorService;

//@RestController
//@RequestMapping("/api/informacao")
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
		
	@Autowired
	private InformacaoService informacaoService;
	

	/*@GetMapping(value="/lista")
	public List<Informacao> obeterLista() {
		return informacaoService.obterLista();
	}
	
	@PostMapping(value="/incluir")
	public Informacao incluir(@RequestBody Informacao informacao) {
		return informacaoService.incluir(informacao);
	}
*/	
	
	@GetMapping(value="/")
	public String showHome(Model model) {
			
		model.addAttribute("informacoes", informacaoService.obterLista());

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