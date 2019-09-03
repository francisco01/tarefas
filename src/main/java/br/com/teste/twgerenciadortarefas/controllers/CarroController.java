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

import br.com.teste.twgerenciadortarefas.modelo.Carro;
import br.com.teste.twgerenciadortarefas.repositorio.RepositorioCarro;

@Controller
@RequestMapping("/carros")
public class CarroController {
	
	@Autowired
	private RepositorioCarro repositorioCarro;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/carros/listar");
		mv.addObject("carros", repositorioCarro.findAll());
		return mv;
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/carros/inserir");
		mv.addObject("carro", new Carro());
		return mv;
	}
	
	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Carro carro, BindingResult result, HttpServletRequest request) {
		ModelAndView  mv = new ModelAndView();
		if (carro.getModelo() == null) {
			result.rejectValue("Modelo", "carro.modelo", "Modelo não informado");
		}else if (result.hasErrors()) {
			mv.setViewName("carros/inserir");
			mv.addObject(carro);
		}else {
			repositorioCarro.save(carro);
			mv.setViewName("redirect:/carros/listar");
		}
		return  mv;
	}

}
