package br.edu.infinet.appautovendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appautovendas.clients.IEnderecoClient;
import br.edu.infinet.appautovendas.model.domain.Endereco;
import br.edu.infinet.appautovendas.model.domain.Vendedor;
import br.edu.infinet.appautovendas.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
	   
	public void incluir(Vendedor vendedor) {
		
		Endereco endereco = enderecoClient.buscaCep(vendedor.getEndereco().getCep());
		
		vendedor.setEndereco(endereco);
		vendedorRepository.save(vendedor);
	}
	
	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}
	
	public Collection<Vendedor> obterLista(){
		return (Collection<Vendedor>) vendedorRepository.findAll();
	}
	public long obterQtde() {
		return vendedorRepository.count();
	}
}
