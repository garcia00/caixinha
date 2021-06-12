package br.com.cx.caixinha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cx.caixinha.modelo.Pessoa;

@Controller
@RequestMapping
public class ControllerHome {
	
	private static final String HOME = "home";

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView(HOME);
		mv.addObject(new Pessoa());
		return mv;
	}

}
