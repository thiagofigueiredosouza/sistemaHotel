package com.trabalhopoo.hotelapp.rh.controle;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.trabalhopoo.hotelapp.rh.dominio.Cliente;
import com.trabalhopoo.hotelapp.rh.dominio.ClienteRepositorio;

@Controller
public class ClienteControle {
	
	private ClienteRepositorio clienteRepo;
	
	public ClienteControle(ClienteRepositorio clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

	@GetMapping("/rh/clientes")
	public String clientes(Model model) {
		model.addAttribute("listaClientes", clienteRepo.findAll());
		return "rh/clientes/index";
	}
	
	
	@GetMapping("/rh/clientes/nova")
	public String novoCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		return "rh/clientes/form";
	}
	
	@PostMapping("/rh/clientes/salvar")
	public String salvarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "rh/clientes/form";
		}
		
		clienteRepo.save(cliente);
		return "redirect:/rh/clientes";
	}

	
	@GetMapping("/rh/clientes/{id}")
	public String alterarCliente(@PathVariable("id") long id, Model model) {
		Optional<Cliente> clienteOpt = clienteRepo.findById(id);
		if (!clienteOpt.isPresent()) {
			throw new IllegalArgumentException("Cliente inválido.");
		}
		
		model.addAttribute("cliente", clienteOpt.get());
		
		return "rh/clientes/form";
	}
	
	
	@GetMapping("/rh/clientes/excluir/{id}")
	public String excluirCliente(@PathVariable("id") long id) {
		Optional<Cliente> clienteOpt = clienteRepo.findById(id);
		if (clienteOpt.isEmpty()) {
			throw new IllegalArgumentException("Cliente inválido.");
		}
		
		clienteRepo.delete(clienteOpt.get());
		return "redirect:/rh/clientes";
	}
	
}