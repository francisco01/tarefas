package br.com.teste.twgerenciadortarefas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.teste.twgerenciadortarefas.modelo.Aluguel;
import br.com.teste.twgerenciadortarefas.repositorio.RepositorioAluguel;

@Controller
@RequestMapping("/aluguel")
public class AluguelController {

	@Autowired
	private RepositorioAluguel repositorioAluguel;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluguel/listar");
		mv.addObject("aluguel", repositorioAluguel.findAll());
		return mv;
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluguel/inserir");
		mv.addObject("aluguel", new Aluguel());
		return mv;
	}
}
