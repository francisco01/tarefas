package br.com.teste.twgerenciadortarefas.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.teste.twgerenciadortarefas.modelo.Cliente;
import br.com.teste.twgerenciadortarefas.repositorio.RepositorioCliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clientes/listar");
		mv.addObject("clientes", repositorioCliente.findAll());
		return mv;
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clientes/inserir");
		mv.addObject("cliente", new Cliente());
		return mv;
	}
	
	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Cliente cliente, BindingResult result, HttpServletRequest request) {
		ModelAndView  mv = new ModelAndView();
		if (cliente.getNome() == null) {
			result.rejectValue("Nome", "cliente.nome", "Nome não informado");
		}else if (result.hasErrors()) {
			mv.setViewName("clientes/inserir");
			mv.addObject(cliente);
		}else {
			repositorioCliente.save(cliente);
			mv.setViewName("redirect:/clientes/listar");
		}
		return  mv;
	}
}
