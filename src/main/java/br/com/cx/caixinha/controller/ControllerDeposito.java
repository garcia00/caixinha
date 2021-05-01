package br.com.cx.caixinha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cx.caixinha.modelo.Pessoa;
import br.com.cx.caixinha.repository.Pessoas;
import br.com.cx.caixinha.service.DepositoService;

@Controller
@RequestMapping("/deposito")
public class ControllerDeposito {
	
	@Autowired
	private Pessoas pessoas;
	
	@Autowired
	private DepositoService depositoService;
	
	private static final String CADASTRO_VIEW = "pagamentoCota";
		


	//@RequestMapping(value="/", method = RequestMethod.GET)
	@GetMapping("{id}")
	public ModelAndView novo(@PathVariable("id") Pessoa pessoa) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(pessoa);
		
		return mv;
	}
	
	@RequestMapping(value = "/{id}/depositar", method = RequestMethod.PUT)
	public @ResponseBody String depositar(@PathVariable Long id) {
		return depositoService.receber(id);
	}
	
	

}
