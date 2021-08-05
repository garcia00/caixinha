package br.com.cx.caixinha.controller;

import br.com.cx.caixinha.modelo.Pessoa;
import br.com.cx.caixinha.repository.Pessoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


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
	public String salvar(@Validated Pessoa pessoa, Errors erros, RedirectAttributes attributes) {
		
		if(erros.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		pessoas.save(pessoa);
		attributes.addFlashAttribute("mensagem", "Cotista salvo com sucesso!");
		return "redirect:/pessoas";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Pessoa> todasPessoas = pessoas.findAll();
		ModelAndView mv = new ModelAndView("pesquisarCotista");

		List<CotistaDetailResopnse> details =  new ArrayList<>();
		for(Pessoa pessoa :todasPessoas){

			details.add(new CotistaDetailResopnse(pessoa));

		}

		mv.addObject("pessoas",details);
		return mv;
		}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Pessoa pessoa) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW); 
		mv.addObject(pessoa);
		return mv;
	}
	
	@RequestMapping(value="pessoas/excluir", method= RequestMethod.POST)
	public String excluir(@RequestParam("id") Long id, RedirectAttributes attributes) {
		pessoas.deleteById(id);
		
		attributes.addFlashAttribute("mensagem", "Cotista excluído com sucesso!");
		return PESQUISA_VIEW;
	}
	

}
