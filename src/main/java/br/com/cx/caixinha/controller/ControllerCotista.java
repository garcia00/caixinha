package br.com.cx.caixinha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cx.caixinha.modelo.Pessoa;
import br.com.cx.caixinha.repository.Pessoas;

@Controller
@RequestMapping("/pessoas")
public class ControllerCotista {
	
	@Autowired
	private Pessoas pessoas;
	
	private static final String CADASTRO_VIEW = "cadastroCotista";
	
	private static final String PESQUISA_VIEW = "pesquisarCotista";
	


	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Pessoa());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Pessoa pessoa, Errors erros) {
		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);
		if(erros.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		pessoas.save(pessoa);
		mv.addObject("mensagem", "Cotista salvo com sucesso!");
		return "redirect:/pessoas/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Pessoa> todasPessoas = pessoas.findAll();
		ModelAndView mv = new ModelAndView("pesquisarCotista");
		mv.addObject("pessoas",todasPessoas);
		return mv;
		}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Pessoa pessoa) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW); 
		mv.addObject(pessoa);
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Pessoa id, RedirectAttributes attributes) {
		pessoas.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
		return PESQUISA_VIEW;
	}
	

}
